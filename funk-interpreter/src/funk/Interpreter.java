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

import funk.antlr.funkLexer;
import funk.antlr.funkParser;
import funk.antlr.funkParser.AssignContext;
import funk.antlr.funkParser.CommentContext;
import funk.antlr.funkParser.ExprContext;
import funk.antlr.funkParser.IdContext;
import funk.antlr.funkParser.LiteralContext;
import funk.antlr.funkParser.MemberCallContext;
import funk.antlr.funkParser.StatementContext;

class reverse implements ICallable{

	@Override
	public Object call(Object self, Object... args) {
		switch(self.getType()){
			case Boolean:
				return self;
				
			case Number:{
				String number;
				String temp="";
				try {
					number = Integer.toString(self.asNumber());
					for(int i=number.length();i>0;i--){
						temp+=number.substring(i-1,i);
					}
				} 
				catch (IllegalCastException e) {
					e.printStackTrace();
				}
				System.out.println("Reverse: "+temp);
				return new Object(Integer.parseInt(temp));
			}
			
			case String:{
				String temp="";
				for(int i=self.asString().length();i>0;i--){
					temp+=self.asString().substring(i-1, i);
				}
				System.out.println("Reverse: "+temp);
				return new Object(temp);
			}
			default:
				//return new Object();
				return self;
		}
		
	}

}

class substr implements ICallable{

	@Override
	public Object call(Object self, Object... args) {
		switch(self.getType()){
			case Boolean:
				return self;
				
			case Number:{
				String number;
				String temp="";
			
				try {
					number = Integer.toString(self.asNumber());
					if(args.length>1){
						for(int i=args[0].asNumber();i<args[1].asNumber() && 
							i<self.asString().length();i++){
								temp+=number.substring(i, i-1);
						}
					}else if(args.length==1){
						for(int i=0;i<args[1].asNumber() && 
							i<self.asString().length();i++){
								temp+=number.substring(i, i-1);
						}
					}
				} 
				catch (IllegalCastException e) {
					e.printStackTrace();//TODO dbgStream
				}
		
				return new Object(Integer.parseInt(temp));
			}
			case String:{
				String temp="";
				try{
					if(args.length>1){
						for(int i=args[0].asNumber();i<args[1].asNumber() && 
							i<self.asString().length();i++){
								temp+=self.asString().substring(i, i-1);
						}
					}
					else if(args.length==1){
						for(int i=0;i<args[1].asNumber() && 
							i<self.asString().length();i++){
								temp+=self.asString().substring(i, i-1);
						}
					}
				}
				catch(IllegalCastException e){
					e.printStackTrace();
				}
				
				return new Object(temp);
			}
			default:
				//return new Object();
				return self;
		}
	}
	
}

public class Interpreter {
	//Valtozok
	public Map<String, Object> variableTable = new HashMap<>();
	
	//Fuggvenyek
	public Map<String, ICallable> functionTable = new HashMap<>();
	
	//Debug stream
	public PrintStream dbgStream = new PrintStream(new NullOutputStream());
	
	public Interpreter(){
		functionTable.put("reverse", new reverse());
		functionTable.put("substr", new substr());
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
			Object rev= new Object();
			
			dbgStream.printf(tokens.get(1).getText()+" "+nodes.get(0).getText()+"\n");
			
			if(variableTable.containsKey(nodes.get(0).getText()))
				rev=variableTable.get(nodes.get(0).getText());
			else 
				rev=new Object(nodes.get(0).getText());
			
			if(nodes.size()==1)
				return functionTable.get(tokens.get(1).getText()).call(rev);//rev=self
			else if(nodes.size()==2)
				return functionTable.get(tokens.get(1)).call(rev,rev);
			
			return functionTable.get(tokens.get(1).getText()).call(rev);//temp solution
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