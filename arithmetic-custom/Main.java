import java.util.Scanner;

public class Main {
	public static void main(String... args)
	{
		Nonterminal Expression = new Nonterminal(); 
		
		Rule rule = new Rule();
		rule.add(new Regex("^[a-zA-Z0-9]*"));
		Expression.addRules(rule);

		rule= new Rule();
		rule.add(new Regex("^\\([a-zA-Z0-9]*\\)"));
		Expression.addRules(rule);

		rule= new Rule();
		rule.add(new Regex("^[a-zA-Z0-9]*((\\+|\\-)[a-zA-Z0-9]+)*"));
		Expression.addRules(rule);

		rule= new Rule();
		rule.add(new Regex("^\\([a-zA-Z0-9]*((\\+|\\-)[a-zA-Z0-9]+)*\\)"));
		Expression.addRules(rule);

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
