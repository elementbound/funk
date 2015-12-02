package funk;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
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
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import funk.antlr.funkBaseVisitor;
import funk.antlr.funkLexer;
import funk.antlr.funkParser;
import funk.antlr.funkParser.ArgsContext;
import funk.antlr.funkParser.AssignContext;
import funk.antlr.funkParser.BlockContext;
import funk.antlr.funkParser.CommentContext;
import funk.antlr.funkParser.ExprContext;
import funk.antlr.funkParser.ForLoopContext;
import funk.antlr.funkParser.IfThenElseContext;
import funk.antlr.funkParser.StatementContext;

public class Interpreter extends funkBaseVisitor<Object> {
	//Valtozok
	public Stack<SymbolTable> variableTable= new Stack<SymbolTable>();
	
	//Fuggvenyek
	public Map<String, ICallable> functionTable = new HashMap<>();
	
	//Debug stream
	public PrintStream dbgStream = new PrintStream(new NullOutputStream());
	
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
			code = code.replaceAll(" \t\r\n", "");
			code = code.replaceAll("\t", "");
			code = code.replaceAll("\r", "");
			code = code.replaceAll("\n", "");
			//dbgStream.printf("After replace: %s\n", code);
			
			for(ParseTree node = parser.statement(); 
					!node.getText().startsWith("<EOF>") && !node.getText().trim().equals(""); 
					node = parser.statement()) 
				//System.out.println(node.getText());
				eval(node);
		}
		catch(NoViableAltException e) {
			/*e.printStackTrace(); 
			dbgStream.printf("Got %s, expected %s\n", e.getOffendingToken(), e.getExpectedTokens());
			dbgStream.printf("Node text: \"%s\"\n", e.getCtx().getText().trim());*/
			//Silently continue
		}
	}
	
	@Override 
	public Object defaultResult() {
		return new Object();
	}
	
	@Override 
	public Object visitEnclosedExpr(funkParser.EnclosedExprContext ctx) {
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
		return new Object(Integer.parseInt(ctx.NUMBER().getText()));
	}
	
	@Override
	public Object visitStringLiteral(funkParser.StringLiteralContext ctx) {
		return new Object(ctx.STRING().getText());
	}
	
	@Override 
	public Object visitUnaryOp(funkParser.UnaryOpContext ctx) {
		String op = ctx.OP().getText();
		ExprContext expr = ctx.expr();
		
		if(op.equals("+"))
			return visit(expr);
		else if(op.equals("-"))
			return new Object("TODO: funk.Object.negate()"); //TODO: negate
		else 
			//throw InvalidUnaryOp(op)
			return new Object("Unknown unary operator: " + op);
	}
	
	@Override 
	public Object visitBinaryOp(funkParser.BinaryOpContext ctx) {
		dbgStream.printf("Binary operation: %s\n", ctx.getText());
		
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
		String selfName = ctx.ID(0).getText();
		String functionName = ctx.ID(1).getText();
		ArgsContext args = ctx.args();
		
		dbgStream.printf("Function call: %s . %s(...)\n", selfName, functionName);
		
		if(!functionTable.containsKey(functionName))
			//throw new UnknownFunctionException(functionName);
			return new Object("Unknown function: " + functionName);

		Object selfObject = getVariable(selfName);
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
		return result; 
	}
	
	@Override 
	public Object visitSingleStatement(funkParser.SingleStatementContext ctx) {
		return visit(ctx.expr());
	}
	
	private Object eval(ParseTree node) throws UnknownVariableException, IllegalCastException, UnknownFunctionException {
		dbgStream.printf("Evaluating node: [%s]%s\n", node.getClass().getName(),node.getText());
		
		//Kideriteni hogy milyen szabalyol jott: 
		//Ha statement: 
		
		if(node instanceof StatementContext) {
			//Kiertekelni az expr reszet
			dbgStream.println("Statement");
			return eval(Utils.extractNodes(node).get(0));
		}
		//Ha komment: 
		else if(node instanceof CommentContext) {
			//Nincs nagyon dolgunk vele, de mivel mindig vissza kell dobjunk egy Object-et, 
			//visszadobjuk magat a szoveget
			dbgStream.printf("Comment: %s\n", node.getText());
			return new Object(node.getText());
		}
		//Ha block
		else if(node instanceof BlockContext){
			dbgStream.printf("Block: %s\n", node.getText());
			
			variableTable.push(new SymbolTable());
			
			List<ParseTree> nodes = Utils.extractNodes(node);
			Object result = new Object();
			for(ParseTree n : nodes)
				result = eval(n);
			
			variableTable.pop();
			
			return result; 
		}
		//Ha literal: 
		else if(node instanceof LiteralContext) {
			//Megnezni hogy milyen tipusu es visszaadni a megfelelo funk.Object-et
			String literalStr = node.getText();
			Object result; 
			
			if(literalStr.charAt(0) == '\"' || literalStr.charAt(0) == '\'')
				result = new Object(literalStr.substring(1, literalStr.length()-1));
			else if(literalStr.equals("True"))
				result = new Object(true);
			else if(literalStr.equals("False"))
				result = new Object(false);
			else
				result = new Object(Integer.parseInt(literalStr));
			
			dbgStream.printf("Literal: %s (%s)\n", result, literalStr);
			return result; 
		}
		//Ha object ( object: id | literal )
		else if(node instanceof ObjectContext) {
			return eval(Utils.extractNodes(node).get(0));
		}
		//Ha memberCall: 
		else if(node instanceof MemberCallContext) {
			//Kikeresni a fuggvenyek kozt a megfelelo fuggvenyt
			//Kimasolni az arg-okat
			//Kiertekelni az arg-okat es az igy kapott funk.Object-eket listaba tenni
			//atadni a listat a kikeresett fuggvenynek es visszaadni amit ad
			
			List<ParseTree> nodes = Utils.extractNodes(node);
			List<Token> tokens = Utils.extractTokens(node);
			
			ParseTree selfNode = nodes.get(0);
			Token functionToken = tokens.get(1);
			ParseTree argsNode = null; 
			if(nodes.size() >= 2)
				argsNode = nodes.get(1);
			
			dbgStream.printf("Function call: %s . %s(...)\n", selfNode.getText(), functionToken.getText());
			
			if(!functionTable.containsKey(functionToken.getText()))
				throw new UnknownFunctionException(functionToken.getText());

			List<Object> args = new ArrayList<>();
			if(argsNode != null) {
				ParseTree at = argsNode;
				List<ParseTree> subats;
				
				while(true) {
					subats = Utils.extractNodes(at);
					ParseTree lhs = subats.get(0);
					ParseTree rhs = null; 
					if(subats.size() >= 2)
						rhs = subats.get(1);
					
					if(rhs != null) {
						dbgStream.printf("\t%s , %s\n", lhs.getText(), rhs.getText());
						dbgStream.printf("\tCollected argument: %s\n", rhs.getText());
						args.add(eval(rhs));
					}
					
					if(lhs instanceof ArgsContext) {
						dbgStream.printf("\tMoving on to %s\n", lhs.getText());
						at = lhs;
					}
					else {
						dbgStream.printf("\tCollected final argument: %s\n", lhs.getText());
						args.add(eval(lhs.getChild(0)));
						break;
					}
				}
			}
			
			Collections.reverse(args);
			
			ICallable function = functionTable.get(functionToken.getText());
			return function.call(eval(selfNode), args.toArray(new Object[args.size()])); //Pass as varargs
		}
		//Ha assign: 
		else if(node instanceof AssignContext) {
			ParseTree expr = Utils.extractNodes(node).get(0);
			Token id = Utils.extractTokens(node).get(0);
			
			
		}
		//Ha ( expr ) avagy closedExpr
		else if(node instanceof ClosedExprContext) {
			ParseTree subnode = Utils.extractNodes(node).get(0);
			
			dbgStream.printf("Closed expr: %s\n", subnode.getText());
			return eval(subnode);
		}
		//Ha if-then-else
		else if(node instanceof IfThenElseContext) {
			List<ParseTree> nodes = Utils.extractNodes(node);
			ParseTree expr = nodes.get(0);
			ParseTree thenScope = nodes.get(1);
			ParseTree elseScope = null;
			if(nodes.size() >= 3)
				elseScope = nodes.get(2);

			if(elseScope != null)
				dbgStream.printf("if( %s ) then %s else %s\n", expr.getText(), thenScope.getText(), elseScope.getText());
			else
				dbgStream.printf("if( %s ) then %s\n", expr.getText(), thenScope.getText());
			
			if(eval(expr).asBoolean())
				return eval(thenScope);
			else
				if(elseScope != null)
					return eval(elseScope);
				else
					return new Object();
		}
		//Ha for loop: 
		else if(node instanceof ForLoopContext) {
			List<ParseTree> nodes = Utils.extractNodes(node);
			
			ParseTree initNode = nodes.get(0);
			ParseTree conditionNode = nodes.get(1);
			ParseTree stepNode = nodes.get(2);
			ParseTree scopeNode = nodes.get(3);
			
			Object result;
			
			result = eval(initNode);
			while(eval(conditionNode).asBoolean()) {
				result = eval(scopeNode);
				eval(stepNode);
			}
			
			return result; 
		}
		//Ha expr: 
		else if(node instanceof ExprContext) {
			//Egytagu, vagyis a fentiek egyike lesz
			if(node.getChildCount() == 1) {
				dbgStream.println("Lone-child expr");
				return eval(node.getChild(0));
			}
			//Kulonben expr <op> expr: 
			else {
				
			}
		}
		else {
			dbgStream.println("The fuck is this");
		}

		return new Object("No return happened, dumbfuck");
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

class Utils {
	//Ide mehetnek majd az olyan utility fuggvenyek mint amik multkor tortentek
	//Pl. extractNodes, extractTokens, ilyesmik
	
	public static int classifyNode(ParseTree node) {
		ParserRuleContext ctx = (ParserRuleContext)node.getPayload();

		return 0;
	}
	
	public static List<ParseTree> extractNodes(ParseTree node) {
		List<ParseTree> ret = new ArrayList<>();
		
		for(int i = 0; i < node.getChildCount(); i++)
		{
			ParseTree c = node.getChild(i);
			if(c.getPayload() instanceof ParserRuleContext)
				ret.add(c);
		}
		
		return ret; 
	}
	
	public static List<Token> extractTokens(ParseTree node) {
		List<Token> ret = new ArrayList<Token>();
		
		for(int i = 0; i < node.getChildCount(); i++)
		{
			ParseTree c = node.getChild(i);
			if(c.getPayload() instanceof Token)
				ret.add((Token)c.getPayload());
		}
		
		return ret; 
	}
}