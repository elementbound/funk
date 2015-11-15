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
				
				printNode(tree);
			}
			catch(RuntimeException re) {
				System.out.printf("Error: %s\n", re.getMessage());
			}
		}
		
		sc.close();
	}
	
	public static void printNode(ParseTree node) {
		if(node.getChildCount() != 0) {
			ParserRuleContext ctx = (ParserRuleContext)node.getPayload();
			String ruleStr = "";
			if(ctx.getToken(logicParser.NEG, 0) != null)
				ruleStr = "neg";
			else if(ctx.getToken(logicParser.OP,0) != null)
				ruleStr = "op";
			else 
				ruleStr = "meh";
			
			Util.Indent(ctx.depth() * 2);
			System.out.printf("%s [%d][%s]\n", node.getText(), node.getChildCount(), ruleStr);
			
			for(int i = 0; i < node.getChildCount(); i++)
				printNode(node.getChild(i));
		}
		else {
			Token t = (Token)node.getPayload();
			//System.out.printf("%s\n", t.getText());
		}
	}
}
