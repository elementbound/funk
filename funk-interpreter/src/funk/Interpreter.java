package funk;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import funk.antlr.funkLexer;
import funk.antlr.funkParser;
import funk.antlr.funkParser.ArgsContext;
import funk.antlr.funkParser.AssignContext;
import funk.antlr.funkParser.ClosedExprContext;
import funk.antlr.funkParser.CommentContext;
import funk.antlr.funkParser.ExprContext;
import funk.antlr.funkParser.IdContext;
import funk.antlr.funkParser.IfThenElseContext;
import funk.antlr.funkParser.LiteralContext;
import funk.antlr.funkParser.MemberCallContext;
import funk.antlr.funkParser.ScopeContext;
import funk.antlr.funkParser.StatementContext;

public class Interpreter {
	//Valtozok
	public Map<String, Object> variableTable = new HashMap<>();
	
	//Fuggvenyek
	public Map<String, ICallable> functionTable = new HashMap<>();
	
	//Debug stream
	public PrintStream dbgStream = new PrintStream(new NullOutputStream());
	
	public Interpreter(){
		functionTable.put("reverse", new FReverse());
		functionTable.put("substr", new FSubstr());
	}
	
	public void execute(String code) throws RecognitionException, UnknownVariableException, IllegalCastException {
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
	
	private Object eval(ParseTree node) throws UnknownVariableException, IllegalCastException {
		dbgStream.printf("Evaluating node: %s\n", node.getText());
		
		//Kideriteni hogy milyen szabalyb�l jott: 
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
		//Ha scope: 
		else if(node instanceof ScopeContext) {
			dbgStream.printf("Scope: %s\n", node.getText());
			
			List<ParseTree> nodes = Utils.extractNodes(node);
			
			Object result = new Object();
			for(ParseTree n : nodes)
				result = eval(n);
			
			return result; 
		}
		//Ha id: 
		else if(node instanceof IdContext) {
			//Megkeresni a valtozok kozt az ID nevet es visszaadni
			Token idToken = Utils.extractTokens(node).get(0);
			String id = idToken.getText();
			
			dbgStream.printf("id: %s\n", id);
			
			if(!variableTable.containsKey(id))
				throw new UnknownVariableException(id);
			
			return variableTable.get(id);
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
				return new Object(); //TODO: throw appropriate exception

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
			
			dbgStream.printf("Assignment: %s = %s\n", id.getText(), expr.getText());
			
			//Kiertekelni expr-t
			Object result = eval(expr);
			
			//A kapott Object-et eltenni ID neve valtozokent
			if(variableTable.containsKey(id.getText()))
				variableTable.remove(id.getText());
			variableTable.put(id.getText(), result);
			
			dbgStream.printf("Saved variable: %s = %s\n", id.getText(), result);
			
			//A kapott Object-et visszaadni
			return result; 
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
		//Ha expr: 
		else if(node instanceof ExprContext) {
			//Egytagu, vagyis a fentiek egyike lesz
			if(node.getChildCount() == 1) {
				dbgStream.println("Lone-child expr");
				return eval(node.getChild(0));
			}
			//Kulonben expr <op> expr: 
			else {
				dbgStream.printf("Possibly addition: %s\n", node.getText());
				
				List<ParseTree> nodes = Utils.extractNodes(node);
				List<Token> tokens = Utils.extractTokens(node);
				
				//Kiszedni a ket expr-t es az operatort
				ParseTree leftNode = nodes.get(0);
				ParseTree rightNode = nodes.get(1);
				Token operator = tokens.get(0);
				
				dbgStream.printf("%s %s %s\n", leftNode.getText(), operator.getText(), rightNode.getText());
				
				//Mindkettot kiertekelni
				Object leftResult = eval(leftNode);
				Object rightResult = eval(rightNode);
				
				//A ket kapott Object-etre alkalmazni a megfelelo operatort
				if(operator.getText().equals("+")) {
					return leftResult.add(rightResult);
				}
				else if(operator.getText().equals("-")) {
					return leftResult.subtract(rightResult);
				}
				else if(operator.getText().equals("*")) {
					return leftResult.multiply(rightResult);
				}
				else if(operator.getText().equals("/")) {
					return leftResult.divide(rightResult);
				}
				else if(operator.getText().equals("=="))
					return leftResult.compare(rightResult);
				else
					return new Object("Unknown operator: " + operator.getText());
			}
		}
		else {
			dbgStream.println("The fuck is this");
		}

		return new Object("No return happened, dumbfuck");
	}
	
	public void dumpVariables(PrintStream out) {
		for(Entry<String, Object> p : variableTable.entrySet()) {
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