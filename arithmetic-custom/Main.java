import java.util.Scanner;

public class Main {
	public static void main(String... args)
	{
		Regex NUM  = new Regex("NUM", "[1-9][0-9]*");
		Regex VAR  = new Regex("VAR", "[_a-zA-Z][a-zA-Z]*");
		Regex OP   = new Regex("OP", "(\\+)|(\\-)");
		Regex LPAR = new Regex("LPAR", "\\(");
		Regex RPAR = new Regex("RPAR", "\\)");
		
		Nonterminal ExprHead = new Nonterminal("ExprHead"); 
		Nonterminal ExprTail = new Nonterminal("ExprTail"); 
		
		ExprHead.add(
			new Rule("(a)", LPAR, ExprHead, RPAR), 
			new Rule("9Tail", NUM, ExprTail),
			new Rule("aTail", VAR, ExprTail)
		);
		
		ExprTail.add(
			new Rule("+E", OP, ExprHead), 
			new Rule("e")
		);
		
		Nonterminal Expression = ExprHead; 

		//Validate lines 
		Scanner sc = new Scanner(System.in); 
		while(sc.hasNextLine())
		{	String nextLine=sc.nextLine();
			nextLine=nextLine.replaceAll("\\s","");

			if(Expression.match(nextLine))
				if(Expression.consume(nextLine).isEmpty())
				{
					System.out.println("Is ok");
					continue;
				}
			
			System.out.println("Nope");
		}
	}
}
