import java.util.Scanner;

public class Main {
	public static void Main(String... args)
	{
		Nonterminal Expression = new Nonterminal(); 
		//Add rules 
		
		//Validate lines 
		Scanner sc = new Scanner(System.in); 
		while(sc.hasNextLine())
		{
			if(!Expression.match(sc.nextLine()))
				System.out.println("Nope");
			else 
				System.out.println("Is ok");
		}
	}
}
