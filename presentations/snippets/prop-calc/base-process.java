public static String pruneNegations(String str) {
	String prevLine = "";
	String line = str;
	
	while(true) {
		//Sor értelmezése
		CharStream stream = new ANTLRInputStream(line);
		logicLexer lexer = new logicLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		
		logicParser parser = new logicParser(tokens);
		ParseTree ntree = parser.s();

		//A sor módosítása
		line = pruneNegationsOnNode(ntree);
		
		//( Esetlegesen ) előlről
		if(line.equals(prevLine))
			break;
		
		prevLine = line; 
		System.out.printf("PruneIter: %s\n", line);
	}
	
	//Siker!
	return line; 
}
