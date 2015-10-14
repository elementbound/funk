import java.util.Scanner;

public class Main {
	public static void main(String... args)
	{
		Regex NUM  = new Regex("NUM", "[1-9][0-9]*|0");
		Regex VAR  = new Regex("VAR", "[_a-zA-Z][a-zA-Z]*");
		Regex OP   = new Regex("OP", "\\+ | \\-");
		Regex LPAR = new Regex("LPAR", "\\(");
		Regex RPAR = new Regex("RPAR", "\\)");
		
		Nonterminal Value = new Nonterminal(
			"Value", 
			new Rule("num", NUM), 
			new Rule("var", VAR)
		);
		
		Nonterminal Expression = new Nonterminal("Expression");
		Expression.add(new Rule("(a)", LPAR, Value, RPAR));
		Expression.add(new Rule("a+b", Value, OP, Value));
		Expression.add(new Rule("a", Value));

		//Validate lines 
		Scanner sc = new Scanner(System.in); 
		while(sc.hasNextLine())
		{	String nextLine=sc.nextLine();
			nextLine=nextLine.replaceAll("\\s","");

			if(!Expression.match(nextLine))
				System.out.println("Nope");
			else 
				System.out.println("Is ok");
		}
	}
}
