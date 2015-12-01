...

	//Valtozok
	public Stack<SymbolTable> variableTable= new Stack<SymbolTable>();
	
	//Fuggvenyek
	public Map<String, ICallable> functionTable = new HashMap<>();
	
	//Debug stream
	public PrintStream dbgStream = new PrintStream(new NullOutputStream());
	
	public Interpreter(){
		functionTable.put("reverse", new FReverse());
		functionTable.put("substr", new FSubstr());
		functionTable.put("println", new FPrintln());
		functionTable.put("print", new FPrint());
		functionTable.put("pow", new FPow());
		
		variableTable.push(new SymbolTable());
	}

...