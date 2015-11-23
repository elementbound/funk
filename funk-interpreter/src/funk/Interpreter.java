package funk;

import java.io.PrintStream;
import java.util.ArrayList;
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

import com.sun.xml.internal.ws.util.StringUtils;

import funk.antlr.funkLexer;
import funk.antlr.funkParser;
import funk.antlr.funkParser.AssignContext;
import funk.antlr.funkParser.CommentContext;
import funk.antlr.funkParser.ExprContext;
import funk.antlr.funkParser.IdContext;
import funk.antlr.funkParser.LiteralContext;
import funk.antlr.funkParser.MemberCallContext;
import funk.antlr.funkParser.StatementContext;

public class Interpreter {
	//Változók
	public Map<String, Object> variableTable = new HashMap<>();
	
	//Függvények
	public Map<String, ICallable> functionTable = new HashMap<>();
	
	//Debug stream
	public PrintStream dbgStream = new PrintStream(new NullOutputStream());
	
	public void execute(String code) throws RecognitionException, UnknownVariableException, IllegalCastException {
		//Stringbõl fát építeni
		CharStream stream = new ANTLRInputStream(code);
		funkLexer lexer = new funkLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		funkParser parser = new funkParser(tokens);
		
		//Minden utasítást kiértékelni:
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
		
		//Kideríteni hogy milyen szabályból jött: 
		//Ha statement: 
		if(node instanceof StatementContext) {
			//Kiértékelni az expr részét
			dbgStream.println("Statement");
			return eval(Utils.extractNodes(node).get(0));
		}
		//Ha komment: 
		else if(node instanceof CommentContext) {
			//Nincs nagyon dolgunk vele, de mivel mindig vissza kell dobjunk egy Object-et, 
			//visszadobjuk magát a szöveget
			dbgStream.printf("Comment: %s\n", node.getText());
			return new Object(node.getText());
		}
		//Ha id: 
		else if(node instanceof IdContext) {
			//Megkeresni a változók közt az ID nevût és visszaadni
			Token idToken = Utils.extractTokens(node).get(0);
			String id = idToken.getText();
			
			dbgStream.printf("id: %s\n", id);
			
			if(!variableTable.containsKey(id))
				throw new UnknownVariableException(id);
			
			return variableTable.get(id);
		}
		//Ha literal: 
		else if(node instanceof LiteralContext) {
			//Megnézni hogy milyen típusú és visszaadni a megfelelõ funk.Object-et
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
			//Kikeresni a függvények közt a megfelelõ függvényt
			//Kimásolni az arg-okat
			//Kiértékelni az arg-okat és az így kapott funk.Object-eket listába tenni
			//Átadni a listát a kikeresett függvénynek és visszaadni amit ad
		}
		//Ha assign: 
		else if(node instanceof AssignContext) {
			ParseTree expr = Utils.extractNodes(node).get(0);
			Token id = Utils.extractTokens(node).get(0);
			
			dbgStream.printf("Assignment: %s = %s\n", id.getText(), expr.getText());
			
			//Kiértékelni expr-t
			Object result = eval(expr);
			
			//A kapott Object-et eltenni ID nevû változóként
			if(variableTable.containsKey(id.getText()))
				variableTable.remove(id.getText());
			variableTable.put(id.getText(), result);
			
			dbgStream.printf("Saved variable: %s = %s\n", id.getText(), result);
			
			//A kapott Object-et visszaadni
			return result; 
		}
		//Ha expr: 
		else if(node instanceof ExprContext) {
			//Egytagú, vagyis a fentiek egyike lesz
			if(node.getChildCount() == 1) {
				dbgStream.println("Lone-child expr");
				return eval(node.getChild(0));
			}
			//Különben expr <op> expr: 
			else {
				dbgStream.printf("Possibly addition: %s\n", node.getText());
				
				List<ParseTree> nodes = Utils.extractNodes(node);
				List<Token> tokens = Utils.extractTokens(node);
				
				//Kiszedni a két expr-t és az operátort
				ParseTree leftNode = nodes.get(0);
				ParseTree rightNode = nodes.get(1);
				Token operator = tokens.get(0);
				
				dbgStream.printf("%s %s %s\n", leftNode.getText(), operator.getText(), rightNode.getText());
				
				//Mindkettõt kiértékelni
				Object leftResult = eval(leftNode);
				Object rightResult = eval(rightNode);
				
				//A két kapott Object-etre alkalmazni a megfelelõ operátort
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
	//Ide mehetnek majd az olyan utility függvények mint amik múltkor történtek
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