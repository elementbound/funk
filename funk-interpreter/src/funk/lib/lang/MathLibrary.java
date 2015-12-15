package funk.lib.lang;

import funk.Interpreter;
import funk.lang.FunctionTemplate;
import funk.lang.IFunclet;
import funk.lang.ILibrary;
import funk.lang.Object;
import funk.lang.types.Number;

public class MathLibrary implements ILibrary {

	@Override
	public void inject(Interpreter funk) {
		//I really needed some stuff
		
		//Number.round()
		funk.registerFunction("round", new FunctionTemplate(new Number(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Number self = (Number) baseSelf;
				
				return new Number(Math.round(self.value));
			}
		}));
		
		//Number.modulo(x)
		funk.registerFunction("modulo", new FunctionTemplate(new Number(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Number self = (Number) baseSelf;
				Number x = (Number)args[0];
				
				return new Number(self.value % x.value);
			}
		}, Number.class));
	}

	@Override
	public String getName() {
		return "Math";
	}

}
