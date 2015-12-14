package funk.lang.func;

import funk.Interpreter;
import funk.lang.IFunction;
import funk.lang.Object;
import funk.lang.StandardErrors;
import funk.lang.types.Number;
import funk.lang.types.Generic;
import funk.lang.types.Error;

public class Pow implements IFunction {

	@Override
	public Object call(Interpreter funk, Object self, Object... args) {
		if(args.length < 1)
			return StandardErrors.WrongArgumentCount(args.length, 1);
		
		if(!(args[0] instanceof Number))
			return StandardErrors.WrongArgumentType(args[0].typeString(), "Number");
		
		//
		
		if(self instanceof funk.lang.types.String) {
			funk.lang.types.String n = (funk.lang.types.String)self;
			Number p = (Number)args[0];
			
			StringBuilder strb = new StringBuilder();
			for(int i = 0; i < p.value; i++)
				strb.append(n.value);
			
			return new funk.lang.types.String(strb.toString());
		}
		else {
			Object result = self;
			Number p = (Number) funk.cast(args[0], Number.class);
			double exponent = p.value;
			
			for(int i = 1; i < exponent; i++) 
				result = result.opMultiply(self);
			
			return result;
		}
	}

	@Override
	public int expectedArgumentCount() {
		return 1;
	}

	@Override
	public Object expectedSelfType() {
		return Generic.instance; 
	}
}
