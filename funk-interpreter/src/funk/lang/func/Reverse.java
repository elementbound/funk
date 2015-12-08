package funk.lang.func;

import funk.Interpreter;
import funk.lang.IFunction;
import funk.lang.Object;
import funk.lang.types.Generic;
import funk.lang.types.Number; 

public class Reverse implements IFunction {
	@Override
	public Object call(Interpreter funk, Object self, Object... args) {
		if(self instanceof Number) {
			StringBuilder strb = new StringBuilder();
			strb.append(self.asString());
			strb.reverse();
			
			return new Number(Integer.parseInt(strb.toString()));
		}

		StringBuilder strb = new StringBuilder();
		strb.append(self.asString());
		strb.reverse();
		
		return new funk.lang.types.String(strb.toString());
	}

	@Override
	public int expectedArgumentCount() {
		return 0;
	}

	@Override
	public Object expectedSelfType() {
		return Generic.instance; 
	}
}
