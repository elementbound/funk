import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;

class Util {
	public static void Indent(int n) {
		for(int i = 0; i < n; i++)
			System.out.print(" ");
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		String line; 
		while(sc.hasNext())
		{
			line = sc.nextLine() + "#"; 

			try{
				CharStream stream = new ANTLRInputStream(line);
				logicLexer lexer = new logicLexer(stream);
				CommonTokenStream tokens = new CommonTokenStream(lexer); 
				
				logicParser parser = new logicParser(tokens);
				ParseTree tree = parser.s();
				
				pruneNegations(tree, System.out);
				System.out.println();
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
	
	public static void negateNode(ParseTree node, PrintStream out) {
		out.print("(!");
		atomizeNegationsOnNode(node, out); //TODO!
		out.print(") ");
	}
	
	//=========================================================================================
	// Atomize negations
	
	public static void atomizeNegationsOnNode(ParseTree node, PrintStream out) {
		if(node.getPayload() instanceof ParserRuleContext) {
			if(classifyNode(node) == RULE_NEGATION) {
				ParseTree subnode = extractNodes(node).get(0);
				
				if(classifyNode(subnode) == RULE_BINARY_OP) {
					List<Token> tokens = extractTokens(subnode);
					List<ParseTree> nodes = extractNodes(subnode);
					
					Token operator = tokens.get(1);
					
					if(operator.getText().equals("&")) {
						out.print("( ");
						negateNode(nodes.get(0), out);
						out.print(" | ");
						negateNode(nodes.get(1), out);
						out.print(") ");
					}
					else if(operator.getText().equals("|")) {
						out.print("( ");
						negateNode(nodes.get(0), out);
						out.print(" & ");
						negateNode(nodes.get(1), out);
						out.print(") ");
					}
					else 
						; //???!
				}
				//No need to handle the negation(subnode) case here, that will be handled by pruneNegations
				else 
					for(int i = 0; i < node.getChildCount(); i++)
						atomizeNegationsOnNode(node.getChild(i), out);
			}
			else {
				for(int i = 0; i < node.getChildCount(); i++)
					atomizeNegationsOnNode(node.getChild(i), out);
			}
		}
		else if(node.getPayload() instanceof Token) {
			Token t = (Token)node.getPayload();
			out.printf("%s ", t.getText());
		}
		else {
			//???!
		}
	}
	
	public static void atomizeNegations(ParseTree tree, PrintStream out) {
		String prevLine = "";
		String line = tree.getText();
		
		while(true) {
			CharStream stream = new ANTLRInputStream(line);
			logicLexer lexer = new logicLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(lexer); 
			
			logicParser parser = new logicParser(tokens);
			ParseTree ntree = parser.s();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			atomizeNegationsOnNode(ntree, ps);
			
			line = baos.toString();
			if(line.equals(prevLine))
				break;
			
			prevLine = line; 
			System.out.printf("Iter: %s\n", line);
		}
		
		out.print(line);
	}
	
	//=========================================================================================
	// Prune negations
	
	public static void pruneNegations(ParseTree tree, PrintStream out) {
		String prevLine = "";
		String line = tree.getText();
		
		while(true) {
			CharStream stream = new ANTLRInputStream(line);
			logicLexer lexer = new logicLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(lexer); 
			
			logicParser parser = new logicParser(tokens);
			ParseTree ntree = parser.s();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			pruneNegationsOnNode(ntree, ps);
			
			line = baos.toString();
			if(line.equals(prevLine))
				break;
			
			prevLine = line; 
			System.out.printf("NegIter: %s\n", line);
		}
		
		out.print(line);
	}
	
	public static void pruneNegationsOnNode(ParseTree node, PrintStream out) {
		if(node.getPayload() instanceof ParserRuleContext) {
			if(classifyNode(node) == RULE_NEGATION) {
				ParseTree subnode = extractNodes(node).get(0);
				
				if(classifyNode(subnode) == RULE_NEGATION) {
					pruneNegationsOnNode(extractNodes(subnode).get(0), out);
				}
				else 
					for(int i = 0; i < node.getChildCount(); i++)
						pruneNegationsOnNode(node.getChild(i), out);
			}
			else {
				for(int i = 0; i < node.getChildCount(); i++)
					pruneNegationsOnNode(node.getChild(i), out);
			}
		}
		else if(node.getPayload() instanceof Token) {
			Token t = (Token)node.getPayload();
			out.printf("%s ", t.getText());
		}
		else {
			//???!
		}
	}
}
