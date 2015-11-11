import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ParseInfo;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;

class ErrorVisitor extends logicBaseVisitor<Void>{
	private int errors = 0;
	
	public Void visitExpr(logicParser.ExprContext ctx) 
	{
		if(ctx.exception != null)
			errors++;
		
		return visitChildren(ctx); 
	}
	
	public int getErrors() {
		return errors; 
	}
}

class PrintVisitor extends logicBaseVisitor<Void>{
	public Void visitExpr(logicParser.ExprContext ctx) 
	{
		return visitChildren(ctx); 
	}
}

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
			line = sc.nextLine(); 
			System.out.println("Parsing line: " + line);
			
			CharStream stream = new ANTLRInputStream(line);
			logicLexer lexer = new logicLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(lexer); 
			
			logicParser parser = new logicParser(tokens);
			ErrorVisitor visitor = new ErrorVisitor();
			ParseTree tree = parser.s();
			
			visitor.visit(tree);
			
			if(visitor.getErrors() != 0) {
				System.out.printf("Found %d error(s)\n", visitor.getErrors());
			}
			else {
				printNode(tree);
			}
		}
		
		sc.close();
	}
	
	public static void printNode(ParseTree node) {
		if(node.getChildCount() != 0) {
			RuleContext ctx = (RuleContext)node.getPayload();
			
			Util.Indent(ctx.depth() * 2);
			System.out.printf("%s [%d]\n", node.getText(), node.getChildCount());
			
			for(int i = 0; i < node.getChildCount(); i++)
				printNode(node.getChild(i));
		}
		else {
			Token t = (Token)node.getPayload();
			//System.out.printf("%s\n", t.getText());
		}
	}
}
