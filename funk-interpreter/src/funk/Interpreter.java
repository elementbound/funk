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
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import funk.antlr.funkBaseVisitor;
import funk.antlr.funkLexer;
import funk.antlr.funkParser;
import funk.antlr.funkParser.ArgsContext;
import funk.antlr.funkParser.ExprContext;
import funk.antlr.funkParser.StatementContext;

public class Interpreter extends funkBaseVisitor<Object> {
	//Valtozok
	public Stack<SymbolTable> variableTable= new Stack<SymbolTable>();
	
	//Fuggvenyek
	public Map<String, ICallable> functionTable = new HashMap<>();
	
	//Debug stream
	public PrintStream dbgStream = new PrintStream(new NullOutputStream());
	
	//Erro stream 
	public PrintStream errorStream = new PrintStream(System.out);
	
	private static Object defaultResult = new Object();
	
	public Interpreter(){
		functionTable.put("reverse", new FReverse());
		functionTable.put("substr", new FSubstr());
		functionTable.put("println", new FPrintln());
		functionTable.put("print", new FPrint());
		functionTable.put("pow", new FPow());
		
		variableTable.push(new SymbolTable());
	}
	
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
	
	public void execute(String code) throws RecognitionException, UnknownVariableException, IllegalCastException, UnknownFunctionException {
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
		
		return super.visitChildren(node);
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
		return new Object(Integer.parseInt(ctx.NUMBER().getText()));
	}
	
	@Override
	public Object visitStringLiteral(funkParser.StringLiteralContext ctx) {
		dbgStream.printf("String literal: %s\n", ctx.getText());
		
		String str = ctx.STRING().getText();
		str = str.substring(1, str.length()-1);
		
		return new Object(str);
	}
	
	@Override 
	public Object visitBooleanLiteral(funkParser.BooleanLiteralContext ctx) {
		if(ctx.BOOLEAN().getText().equals("True"))
			return new Object(true);
		else if(ctx.BOOLEAN().getText().equals("False"))
			return new Object(false);
		else 
			return new Object("The fuck is this boolean");
	}
	
	@Override 
	public Object visitUnaryOp(funkParser.UnaryOpContext ctx) {
		dbgStream.printf("Unary op: %s\n", ctx.getText());
		
		String op = ctx.OP().getText();
		ExprContext expr = ctx.expr();
		
		if(op.equals("+"))
			return visit(expr);
		else if(op.equals("-"))
			return visit(expr).negate(); 
		else 
			//throw InvalidUnaryOp(op)
			return new Object("Unknown unary operator: " + op);
	}
	
	@Override 
	public Object visitBinaryOp(funkParser.BinaryOpContext ctx) {
		dbgStream.printf("Binary op: %s\n", ctx.getText());
		
		//Kiszedni a ket expr-t es az operatort
		ParseTree lhs = ctx.expr(0);
		ParseTree rhs = ctx.expr(1);
		String operator = ctx.OP().getText();
		
		dbgStream.printf("%s %s %s\n", lhs.getText(), operator, rhs.getText());
		
		//A ket kapott Object-etre alkalmazni a megfelelo operatort
		try {
			if(operator.equals("+")) 
				return visit(lhs).add(visit(rhs));
			else if(operator.equals("-")) 
				return visit(lhs).subtract(visit(rhs));
			else if(operator.equals("*")) 
				return visit(lhs).multiply(visit(rhs));
			else if(operator.equals("/")) 
				return visit(lhs).divide(visit(rhs));
			else if(operator.equals("==")) 
				return visit(lhs).eq(visit(rhs));
			else if(operator.equals("!=")) 
				return visit(lhs).neq(visit(rhs));
			else if(operator.equals("<")) 
				return visit(lhs).le(visit(rhs));
			else if(operator.equals(">")) 
				return visit(lhs).ge(visit(rhs));
			else
				return new Object("Unknown binary operator: " + operator);
		}
		catch(IllegalCastException ex) {
			//TODO: We should REALLY solve throwing exceptions from visitor
			return new Object(ex.getMessage());
		}
	}
	
	@Override 
	public Object visitDirectMemberCall(funkParser.DirectMemberCallContext ctx) {
		dbgStream.printf("Direct member call: %s\n", ctx.getText());
		
		ExprContext selfExpr = ctx.expr();
		String functionName = ctx.ID().getText();
		ArgsContext args = ctx.args();
		
		dbgStream.printf("Function call: %s . %s(...)\n", selfExpr.getText(), functionName);
		
		if(!functionTable.containsKey(functionName))
			//throw new UnknownFunctionException(functionName);
			return new Object("Unknown function: " + functionName);

		Object selfObject = visit(selfExpr);
		List<Object> argObjects = new ArrayList<>();
		for(ExprContext arg : args.expr()) 
			argObjects.add(visit(arg));
		
		ICallable function = functionTable.get(functionName);
		
		try {
			//Pass as varargs
			return function.call(selfObject, argObjects.toArray(new Object[argObjects.size()]));
		} catch (IllegalCastException e) {
			return new Object("Illegal cast exception: " + e.getMessage());
		} 
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
		
		try {
			if(visit(expr).asBoolean())
				return visit(thenScope);
			else
				if(elseScope != null)
					return visit(elseScope);
				else
					return new Object();
		}
		catch(IllegalCastException ex) {
			//TODO: Exceptions from visitors
			return new Object("Illegal cast exception: " + ex.getMessage());
		}
	}
	
	@Override
	public Object visitForLoop(funkParser.ForLoopContext ctx) {
		ExprContext initNode = ctx.expr(0);
		ExprContext conditionNode = ctx.expr(1);
		ExprContext stepNode = ctx.expr(2);
		StatementContext scopeNode = ctx.statement();
		
		Object result;
		
		result = visit(initNode);
		try {
			while(visit(conditionNode).asBoolean()) {
				result = visit(scopeNode);
				visit(stepNode);
			}
		} catch (IllegalCastException ex) {
			//TODO: Exceptions from visitors
			return new Object("Illegal cast exception: " + ex.getMessage());
		}
		
		return result; 
	}
	
	public Object visitBlock(funkParser.BlockContext ctx) {
		dbgStream.printf("Block: %s\n", ctx.getText());
		
		variableTable.push(new SymbolTable());
		
		Object result = new Object();
		for(ParseTree n : ctx.statement())
			result = visit(n);
		
		variableTable.pop();
		
		return result; 
	}
	
	public Object visitComment(funkParser.CommentContext ctx) {
		//Nincs nagyon dolgunk vele, de mivel mindig vissza kell dobjunk egy Object-et, 
		//visszadobjuk magat a szoveget
		dbgStream.printf("Comment: %s\n", ctx.COMMENT().getText());
		return new Object(ctx.COMMENT().getText());
	}
	
	public void dumpVariables(PrintStream out) {
		for(Entry<String, Object> p : getAllTable().entrySet()) {
			if(p.getValue().getType() != Type.String)
				out.printf("%s %s = %s;\n", p.getValue().getType(), p.getKey(), p.getValue().asString());
			else 
				out.printf("%s %s = \'%s\';\n", p.getValue().getType(), p.getKey(), p.getValue().asString());
		}
	}
}