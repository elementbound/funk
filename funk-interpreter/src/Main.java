import java.util.Scanner;

import org.antlr.v4.runtime.RecognitionException;

import funk.IllegalCastException;
import funk.Interpreter;
import funk.UnknownFunctionException;
import funk.UnknownVariableException;

public class Main {
	public static void main(String... args) {
		Interpreter funk = new Interpreter();
		funk.dbgStream = System.out; 
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			
			try {
				funk.execute(line);
			} catch (RecognitionException | UnknownVariableException | IllegalCastException e) {
				e.printStackTrace();
			}
		}
		
		sc.close();
		
		funk.dumpVariables(System.out);
	}
}
