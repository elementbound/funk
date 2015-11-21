import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		boolean chose=false;
		String line; 
		
		while(sc.hasNext())
		{
			line = sc.nextLine() + "#"; 

			try{
				if(chose)
					line = atomizeNegations(line);
				else
					line = toDisjunction(line);
				
				line = pruneNegations(line);	
				System.out.println(line.substring(0, line.length()-2));
			}
			catch(RuntimeException re) {
				System.out.printf("Error: %s\n", re.getMessage());
			}
		}
		
		sc.close();
	}
	
	//=========================================================================================
	// Node utils 
	
	public static final int RULE_ATOM = 0;
	public static final int RULE_NEGATION = 1;
	public static final int RULE_BINARY_OP = 2;
	public static final int RULE_EXPR = 3;
	
	public static int classifyNode(ParseTree node) {
		ParserRuleContext ctx = (ParserRuleContext)node.getPayload();

		if(ctx.getToken(logicParser.NEG, 0) != null)
			return RULE_NEGATION; 
		else if(ctx.getToken(logicParser.OP,0) != null)
			return RULE_BINARY_OP; 
		else if(ctx.getToken(logicParser.ATOM, 0) != null)
			return RULE_ATOM; 
		else 
			return RULE_EXPR; 
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
	
	public static String negate(String str) {
		StringBuilder strb = new StringBuilder();
		return strb.append("( ! ").append(str).append(") ").toString(); 
	}
	
	//=========================================================================================
	// Atomize negations
	
	public static String atomizeNegationsOnNode(ParseTree node) {
		StringBuilder strb = new StringBuilder();
		
		if(node.getPayload() instanceof ParserRuleContext) {
			if(classifyNode(node) == RULE_NEGATION) {
				ParseTree subnode = extractNodes(node).get(0);
				
				if(classifyNode(subnode) == RULE_BINARY_OP) {
					List<Token> tokens = extractTokens(subnode);
					List<ParseTree> nodes = extractNodes(subnode);
					
					Token operator = tokens.get(1);
					
					if(operator.getText().equals("&")) {
						strb.append("( ")
							.append(negate(atomizeNegationsOnNode(nodes.get(0))))
							.append(" | ")
							.append(negate(atomizeNegationsOnNode(nodes.get(1))))
							.append(") ") ;
					}
					else if(operator.getText().equals("|")) {
						strb.append("( ")
						.append(negate(atomizeNegationsOnNode(nodes.get(0))))
						.append(" & ")
						.append(negate(atomizeNegationsOnNode(nodes.get(1))))
						.append(") ") ;
					}
					else if(operator.getText().equals(">")){
						strb.append("( ")
						.append(negate(atomizeNegationsOnNode(nodes.get(0))))
						.append(" | ")
						.append(atomizeNegationsOnNode(nodes.get(1)))
						.append(") ") ;
					}
				}
				//No need to handle the negation(subnode) case here, that will be handled by pruneNegations
				else 
					for(int i = 0; i < node.getChildCount(); i++)
						strb.append(atomizeNegationsOnNode(node.getChild(i)));
			}
			else {
				for(int i = 0; i < node.getChildCount(); i++)
					strb.append(atomizeNegationsOnNode(node.getChild(i)));
			}
		}
		else if(node.getPayload() instanceof Token) {
			Token t = (Token)node.getPayload();
			strb.append(t.getText()).append(' ');
		}
		
		return strb.toString();
	}
	
	public static String atomizeNegations(String str) {
		String prevLine = "";
		String line = str;
		
		while(true) {
			CharStream stream = new ANTLRInputStream(line);
			logicLexer lexer = new logicLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(lexer); 
			
			logicParser parser = new logicParser(tokens);
			ParseTree ntree = parser.s();
			
			line = atomizeNegationsOnNode(ntree);
			if(line.equals(prevLine))
				break;
			
			prevLine = line; 
			System.out.printf("NegIter: %s\n", line);
		}
		
		return line;
	}
	
	//=========================================================================================
	// Prune negations
	
	public static String pruneNegations(String str) {
		String prevLine = "";
		String line = str;
		
		while(true) {
			CharStream stream = new ANTLRInputStream(line);
			logicLexer lexer = new logicLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(lexer); 
			
			logicParser parser = new logicParser(tokens);
			ParseTree ntree = parser.s();

			line = pruneNegationsOnNode(ntree);
			if(line.equals(prevLine))
				break;
			
			prevLine = line; 
			System.out.printf("PruneIter: %s\n", line);
		}
		
		return line; 
	}
	
	public static String pruneNegationsOnNode(ParseTree node) {
		StringBuilder strb = new StringBuilder();
		
		if(node.getPayload() instanceof ParserRuleContext) {
			if(classifyNode(node) == RULE_NEGATION) {
				ParseTree subnode = extractNodes(node).get(0);
				
				if(classifyNode(subnode) == RULE_NEGATION) {
					strb.append(pruneNegationsOnNode(extractNodes(subnode).get(0)));
				}
				else 
					for(int i = 0; i < node.getChildCount(); i++)
						strb.append(pruneNegationsOnNode(node.getChild(i)));
			}
			else {
				for(int i = 0; i < node.getChildCount(); i++)
					strb.append(pruneNegationsOnNode(node.getChild(i)));
			}
		}
		else if(node.getPayload() instanceof Token) {
			Token t = (Token)node.getPayload();
			strb.append(t.getText()).append(' ');
		}
		
		return strb.toString();
	}
	
	//=========================================================================================
	// To disjunctions
	
	public static String toDisjunction(String str) {
		String prevLine = "";
		String line = str;
		
		while(true) {
			CharStream stream = new ANTLRInputStream(line);
			logicLexer lexer = new logicLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(lexer); 
			
			logicParser parser = new logicParser(tokens);
			ParseTree ntree = parser.s();

			line = toDisjunctionNode(ntree);
			if(line.equals(prevLine))
				break;
			
			prevLine = line; 
			
			System.out.println("DisIter: "+line);
		}
		
		return line; 
	}
	
	public static String toDisjunctionNode(ParseTree node) {
		StringBuilder strb = new StringBuilder();
		
		if(node.getPayload() instanceof ParserRuleContext) {
			if(classifyNode(node) == RULE_BINARY_OP) {
					List<Token> tokens = extractTokens(node);
					List<ParseTree> nodes = extractNodes(node);

					Token operator = tokens.get(1);
					
					if(operator.getText().equals("&")) {
						strb.append("( ! ( ")
							.append(negate(toDisjunctionNode(nodes.get(0))))
							.append(" | ")
							.append(negate(toDisjunctionNode(nodes.get(1))))
							.append(") ) ") ;
					}
				else 
					for(int i = 0; i < node.getChildCount(); i++)
						strb.append(toDisjunctionNode(node.getChild(i)));
			}
			else {
				for(int i = 0; i < node.getChildCount(); i++)
					strb.append(toDisjunctionNode(node.getChild(i)));
			}
		}
		else if(node.getPayload() instanceof Token) {
			Token t = (Token)node.getPayload();
			strb.append(t.getText()).append(' ');
		}
		
		return strb.toString();
	}
	
}
