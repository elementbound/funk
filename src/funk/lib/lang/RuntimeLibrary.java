package funk.lib.lang;

import funk.Interpreter;
import funk.lang.FunctionTemplate;
import funk.lang.IFunclet;
import funk.lang.ILibrary;
import funk.lang.Object;
import funk.lang.StandardErrors;
import funk.lang.types.Boolean;
import funk.lang.types.Collection;
import funk.lang.types.NamedGeneric;

public class RuntimeLibrary implements ILibrary {

	@Override
	public void inject(Interpreter funk) {
		NamedGeneric type = new NamedGeneric("Runtime");
		
		funk.registerType("Runtime", type);
		
		//Runtime.variables()
		funk.registerFunction("variables", new FunctionTemplate(type, new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection result = new Collection();
				for(String name : funk.listVariableNames())
					result.add(new funk.lang.types.String(name));
				
				return result;
			}
		}));
		
		//Runtime.hasVariable(varName)
		funk.registerFunction("hasVariable", new FunctionTemplate(type, new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				String varName = args[0].asString();
				
				return new Boolean(funk.hasVariable(varName));
			}
		}, funk.lang.types.String.class));
		
		//Runtime.getVariable(varName)
		funk.registerFunction("getVariable", new FunctionTemplate(type, new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				String varName = args[0].asString();
				
				Object result = funk.getVariable(varName);
				if(result == null)
					return StandardErrors.UnknownVariable(varName);
				else 
					return result;
			}
		}, funk.lang.types.String.class));
		
		//Runtime.functions()
		funk.registerFunction("functions", new FunctionTemplate(type, new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection result = new Collection();
				for(String name : funk.listFunctionNames())
					result.add(new funk.lang.types.String(name));
				
				return result;
			}
		}));
		
		//Runtime.types()
		funk.registerFunction("types", new FunctionTemplate(type, new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection result = new Collection();
				for(String name : funk.listTypeNames())
					result.add(new funk.lang.types.String(name));
				
				return result;
			}
		}));
	}

	@Override
	public String getName() {
		return "Runtime";
	}

}
