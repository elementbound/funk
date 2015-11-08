import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRInputStream;

class Visitor extends logicBaseVisitor<Integer>{
	public Integer visitExpr(logicParser.ExprContext ctx) 
	{ 
		System.out.println("Oh hey, an expr! " + ctx.getText());
		return visitChildren(ctx); 
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		String line; 
		while(sc.hasNext())
		{
			line = sc.nextLine(); 
			
			CharStream stream = new ANTLRInputStream(line);
			logicLexer lexer = new logicLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(lexer); 
			logicParser parser = new logicParser(tokens);
			logicVisitor<Integer> visitor = new Visitor();
			visitor.visit(parser.line());
		}
		
		sc.close();
	}

}
