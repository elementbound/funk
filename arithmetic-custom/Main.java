import java.util.Scanner;

public class Main {
	public static void main(String... args)
	{
		Regex NUM  = new Regex("[1-9][0-9]*|0");
		Regex VAR  = new Regex("[_a-zA-Z][a-zA-Z]*");
		Regex OP   = new Regex("\\+ | \\-");
		Regex LPAR = new Regex("\\(");
		Regex RPAR = new Regex("\\)");
		
		Nonterminal Expression = new Nonterminal();
		Expression.add(new Rule(LPAR, Expression, RPAR));
		Expression.add(new Rule(VAR));
		Expression.add(new Rule(NUM));
		Expression.add(new Rule(Expression, OP, Expression));

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
