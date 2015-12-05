package funk;

import java.io.PrintStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import funk.antlr.funkBaseVisitor;
import funk.antlr.funkLexer;
import funk.antlr.funkParser;
import funk.antlr.funkParser.ArgsContext;
import funk.antlr.funkParser.ExprContext;
import funk.antlr.funkParser.StatementContext;
import funk.lang.IFunction;
import funk.lang.ICastRule;
import funk.lang.Object;
import funk.lang.cast.BooleanToNumber;
import funk.lang.func.Pow;
import funk.lang.func.Print;
import funk.lang.func.Println;
import funk.lang.func.Reverse;
import funk.lang.func.Substr;
import funk.lang.types.Error;
import funk.lang.types.Number;
import funk.lang.types.Boolean; 

public class Interpreter extends funkBaseVisitor<Object> {
	//Valtozok
	public Stack<SymbolTable> variableTable= new Stack<SymbolTable>();
	
	//Fuggvenyek
	public Map<String, IFunction> functionTable = new HashMap<>();
	
	//Cast rules
	public List<ICastRule<?,?>> castRules = new ArrayList<>();
	
	//Debug stream
	public PrintStream dbgStream = new PrintStream(new NullOutputStream());
	
	//Erro stream 
	public PrintStream errorStream = new PrintStream(System.out);
	
	private static Object defaultResult = new Error("void");
	
	public Interpreter(){
		functionTable.put("reverse", new Reverse());
		functionTable.put("substr", new Substr());
		functionTable.put("println", new Println());
		functionTable.put("print", new Print());
		functionTable.put("pow", new Pow());
		
		variableTable.push(new SymbolTable());
		
		castRules.add(new BooleanToNumber());
	}
	
	//=========================================================================================
	//Variables
	
	Map<String,Object> getAllTable(){
		Map<String, Object> temp= new HashMap<>();
		
		for(Iterator<SymbolTable> iterator=variableTable.iterator();iterator.hasNext();){
			SymbolTable table=iterator.next();
			temp.putAll(table.table);
		}
		
		return temp;
	}
	
	boolean exists(String key){
		Map<String, Object> temp= getAllTable();
		
		return temp.containsKey(key);
	}
	
	public Object getVariable(String key) {
		Map<String, Object> temp= getAllTable();
		
		return temp.get(key);
	}
	
	public void putToTop(String key, Object val){
		SymbolTable temp= variableTable.pop();
		temp.set(key, val);
		
		variableTable.push(temp);
	}
	
	//=========================================================================================
	// Cast
	
	public Object cast(Object from, Class<?> to) {
		if(to.equals(Boolean.class))
			return new Boolean(from.asBoolean());

		if(to.equals(funk.lang.types.String.class))
			return new funk.lang.types.String(from.asString());
		
		for(ICastRule<?,?> rule : castRules) 
			if(rule.from().equals(from.getClass()) && rule.to().equals(to))
				return (Object) rule.cast(from);
		
		return new Error("IllegalCast")
					.addField("from", from.toString())
					.addField("to", to.getSimpleName());
	}
	
	//=========================================================================================
	
	public void execute(String code) throws RecognitionException {
		//Stringbol fat epiteni
		CharStream stream = new ANTLRInputStream(code);
		funkLexer lexer = new funkLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		funkParser parser = new funkParser(tokens);
		
		//Minden utasitast kiertekelni:
		try {
			for(ParseTree node = parser.statement(); 
					!node.getText().startsWith("<EOF>") && !node.getText().trim().equals("");
					node = parser.statement()) {
				dbgStream.printf("Visiting %s\n", node.getText());
				dbgStream.printf("Return: %s\n", visit(node).toString());
			}
		}
		catch(RecognitionException e) {
			if(e.getOffendingToken().getText().equals("<EOF>"))
				return; 
			
			StringBuilder strb = new StringBuilder();
			strb.append("Got token ").append(e.getOffendingToken().getText()).append(";\n");
			strb.append("Expected: ");

			for(int t : e.getExpectedTokens().toList()) {
				strb.append('\n').append(funkParser.VOCABULARY.getDisplayName(t));
			}
			
			errorStream.println(strb);
			errorStream.printf("Node text: \"%s\"\n", e.getCtx().getText().trim());
			errorStream.printf("Error at %s\n", e.getCtx().getSourceInterval());
			
			e.printStackTrace(); 
			//Silently continue
		}
		catch(Exception ex) { 
			ex.printStackTrace(errorStream);
		}
	}
	
	@Override 
	public Object defaultResult() {
		return defaultResult;
	}
	
	@Override 
	public Object aggregateResult(Object aggregate, Object next) {
		if(aggregate == defaultResult) {
			//dbgStream.printf("Aggregating null and %s; returning %s\n", next, next);
			return next;
		}
		else {
			//dbgStream.printf("Aggregating %s and null; returning %s\n", aggregate, aggregate);
			return aggregate;
		}
	}
	
	@Override
	public Object visitChildren(RuleNode node) {
		dbgStream.printf("Visiting node: %s\n", node.getText());
		dbgStream.printf("Rule: %s\n", funkParser.ruleNames[node.getRuleContext().getRuleIndex()]);
		dbgStream.printf("Context type: %s\n\n", node.getRuleContext().getClass().getName());
		
		Object result = super.visitChildren(node);
		
		if(result instanceof Error) 
			((Error)result).prettyPrint(errorStream);
		
		return result;
	}
	
	@Override 
	public Object visitEnclosedExpr(funkParser.EnclosedExprContext ctx) {
		dbgStream.printf("Enclosed expr: %s\n", ctx.getText());
		return visit(ctx.expr());
	}
	
	@Override 
	public Object visitID(funkParser.IDContext ctx) {
		String id = ctx.ID().getText();
		
		dbgStream.printf("id: %s\n", id);
		
		if(!exists(id))
			return defaultResult(); //throw new UnknownVariableException(id);
		
		return getVariable(id);
	}
	
	@Override 
	public Object visitNumberLiteral(funkParser.NumberLiteralContext ctx) {
		dbgStream.printf("Number literal: %s\n", ctx.getText());
		return new Number(Integer.parseInt(ctx.NUMBER().getText()));
	}
	
	@Override
	public Object visitStringLiteral(funkParser.StringLiteralContext ctx) {
		dbgStream.printf("String literal: %s\n", ctx.getText());
		
		String str = ctx.STRING().getText();
		str = str.substring(1, str.length()-1);
		
		return new funk.lang.types.String(str);
	}
	
	@Override 
	public Object visitBooleanLiteral(funkParser.BooleanLiteralContext ctx) {
		if(ctx.BOOLEAN().getText().equals("True"))
			return new Boolean(true);
		else if(ctx.BOOLEAN().getText().equals("False"))
			return new Boolean(false);
		else 
			return new Error("WrongBooleanLiteral")
						.addField("literal", ctx.BOOLEAN().getText());
	}
	
	@Override 
	public Object visitUnaryOp(funkParser.UnaryOpContext ctx) {
		dbgStream.printf("Unary op: %s\n", ctx.getText());
		
		String op = ctx.OP().getText();
		ExprContext expr = ctx.expr();
		
		if(op.equals("+"))
			return visit(expr);
		else if(op.equals("-"))
			return visit(expr).opNegate(); 
		else 
			return new Error("UnknownUnaryOperator", "op", op);
	}
	
	@Override 
	public Object visitBinaryOp(funkParser.BinaryOpContext ctx) {
		dbgStream.printf("Binary op: %s\n", ctx.getText());
		
		//Kiszedni a ket expr-t es az operatort
		ExprContext lhsExpr = ctx.expr(0);
		ExprContext rhsExpr = ctx.expr(1);
		String operator = ctx.OP().getText();
		
		dbgStream.printf("%s %s %s\n", lhsExpr.getText(), operator, rhsExpr.getText());
		
		Object lhs = visit(lhsExpr);
		Object rhs = visit(rhsExpr);
		rhs = this.cast(rhs, lhs.getClass());
		
		if(rhs instanceof Error)
			return rhs;
		
		//A ket kapott Object-etre alkalmazni a megfelelo operatort
		if(operator.equals("+")) 
			return lhs.opAdd(rhs);
		else if(operator.equals("-")) 
			return lhs.opSubtract(rhs);
		else if(operator.equals("*")) 
			return lhs.opMultiply(rhs);
		else if(operator.equals("/")) 
			return lhs.opDivide(rhs);
		else if(operator.equals("==")) 
			return lhs.opEquals(rhs);
		else if(operator.equals("!=")) 
			return lhs.opNotEquals(rhs);
		else if(operator.equals("<")) 
			return lhs.opLowerThan(rhs);
		else if(operator.equals(">")) 
			return lhs.opGreaterThan(rhs);
		else
			return new Error("UnknownBinaryOperator", "op", operator);
	}
	
	@Override 
	public Object visitDirectMemberCall(funkParser.DirectMemberCallContext ctx) {
		dbgStream.printf("Direct member call: %s\n", ctx.getText());
		
		ExprContext selfExpr = ctx.expr();
		String functionName = ctx.ID().getText();
		ArgsContext args = ctx.args();
		
		dbgStream.printf("Function call: %s . %s(...)\n", selfExpr.getText(), functionName);
		
		if(!functionTable.containsKey(functionName))
			return new Error("UnknownFunction", "function", functionName);

		Object selfObject = visit(selfExpr);
		List<Object> argObjects = new ArrayList<>();
		for(ExprContext arg : args.expr()) 
			argObjects.add(visit(arg));
		
		IFunction function = functionTable.get(functionName);
		
		//Pass as varargs
		return function.call(selfObject, argObjects.toArray(new Object[argObjects.size()]));
	}
	
	@Override 
	public Object visitAssign(funkParser.AssignContext ctx) {
		String id = ctx.ID().getText();
		ExprContext expr = ctx.expr();
		
		dbgStream.printf("Assignment: %s = %s\n", id, expr.getText());
		
		//Kiertekelni expr-t
		Object result = visit(expr);
		
		//A kapott Object-et eltenni ID neve valtozokent
		putToTop(id, result);
		
		dbgStream.printf("Saved variable: %s = %s\n", id, result);
		
		//A kapott Object-et visszaadni
		dbgStream.printf("Returning from assign: %s\n", result);
		return result; 
	}
	
	@Override
	public Object visitIfThenElse(funkParser.IfThenElseContext ctx) {
		ExprContext expr = ctx.expr();
		StatementContext thenScope = ctx.statement(0);
		StatementContext elseScope = null;
		if(ctx.statement().size() >= 1)
			elseScope = ctx.statement(1);

		if(elseScope != null)
			dbgStream.printf("if( %s ) then %s else %s\n", expr.getText(), thenScope.getText(), elseScope.getText());
		else
			dbgStream.printf("if( %s ) then %s\n", expr.getText(), thenScope.getText());
		
		if(visit(expr).asBoolean())
			return visit(thenScope);
		else
			if(elseScope != null)
				return visit(elseScope);
			else
				return new Boolean(false);
	}
	
	@Override
	public Object visitForLoop(funkParser.ForLoopContext ctx) {
		ExprContext initNode = ctx.expr(0);
		ExprContext conditionNode = ctx.expr(1);
		ExprContext stepNode = ctx.expr(2);
		StatementContext scopeNode = ctx.statement();
		
		Object result;
		
		result = visit(initNode);
		while(visit(conditionNode).asBoolean()) {
			result = visit(scopeNode);
			visit(stepNode);
		}
		
		return result; 
	}
	
	public Object visitBlock(funkParser.BlockContext ctx) {
		dbgStream.printf("Block: %s\n", ctx.getText());
		
		variableTable.push(new SymbolTable());
		
		Object result = new Boolean();
		for(ParseTree n : ctx.statement())
			result = visit(n);
		
		variableTable.pop();
		
		return result; 
	}
	
	public Object visitComment(funkParser.CommentContext ctx) {
		//Nincs nagyon dolgunk vele, de mivel mindig vissza kell dobjunk egy Object-et, 
		//visszadobjuk magat a szoveget
		dbgStream.printf("Comment: %s\n", ctx.COMMENT().getText());
		return new funk.lang.types.String(ctx.COMMENT().getText());
	}
	
	public void dumpVariables(PrintStream out) {
		for(Entry<String, Object> p : getAllTable().entrySet()) 
			out.printf("%s: %s;\n", p.getKey(), p.getValue().toString());
	}
}