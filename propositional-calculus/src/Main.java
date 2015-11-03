import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		String line; 
		while(sc.hasNext())
		{
			line = sc.nextLine(); 
			
			System.out.println(line); 
		}
		
		sc.close();
	}

}
