import java.util.Scanner;

import funk.IllegalCastException;
import funk.Interpreter;

public class Main {
	public static void main(String... args) throws IllegalCastException {
		Interpreter funk = new Interpreter();
		//funk.dbgStream = System.out; 
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			
			funk.execute(line);
		}
		
		sc.close();
		
		funk.dumpVariables(System.out);
	}
}
