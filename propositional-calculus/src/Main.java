import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.ANTLRErrorStrategy;
import org.antlr.v4.runtime.ANTLRInputStream;

class ErrorVisitor extends logicBaseVisitor<Integer>{
	private int errors = 0;
	
	public Integer visitExpr(logicParser.ExprContext ctx) 
	{
		if(ctx.exception != null)
			errors++;
		
		return visitChildren(ctx); 
	}
	
	public int getErrors() {
		return errors; 
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
			ErrorVisitor visitor = new ErrorVisitor();
			visitor.visit(parser.line());
			
			if(visitor.getErrors() != 0) {
				System.out.printf("Found %d error(s)\n", visitor.getErrors());
			}
		}
		
		sc.close();
	}

}
