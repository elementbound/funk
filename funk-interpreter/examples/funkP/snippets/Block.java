...

if(node instanceof BlockContext){
			dbgStream.printf("Block: %s\n", node.getText());
			
			variableTable.push(new SymbolTable());
			
			List<ParseTree> nodes = Utils.extractNodes(node);
			Object result = new Object();
			for(ParseTree n : nodes)
				result = eval(n);
			
			variableTable.pop();
			
			return result; 
		}
		
...