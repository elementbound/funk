import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.antlr.v4.runtime.RecognitionException;

import funk.IllegalCastException;
import funk.Interpreter;
import funk.UnknownFunctionException;
import funk.UnknownVariableException;

public class Main {
	public static void main(String... args) {
		Interpreter funk = new Interpreter();
		//funk.dbgStream = System.out; 
		
		if(args.length > 0)
			batch(args[0], funk);
		else
			interactive(funk);
		
		funk.dumpVariables(System.out);
	}
	
	public static void interactive(Interpreter funk) {
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
	}
	
	public static void batch(String fname, Interpreter funk) {
		Scanner sc;
		try {
			sc = new Scanner(new File(fname));
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't open file: " + fname);
			return; 
		}
		
		StringBuilder strb = new StringBuilder();
		
		while(sc.hasNextLine()) 
			strb.append(sc.nextLine());
		
		sc.close();
		
		try {
			funk.execute(strb.toString());
		} catch (RecognitionException | UnknownVariableException | IllegalCastException e) {
			e.printStackTrace();
		}
	}
}
