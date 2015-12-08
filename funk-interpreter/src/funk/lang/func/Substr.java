package funk.lang.func;

import funk.Interpreter;
import funk.lang.IFunction;
import funk.lang.Object;
import funk.lang.types.Generic;
import funk.lang.types.Number; 

public class Substr implements IFunction {
	private int argCount; 
	
	public Substr() {
		this.argCount = 1;
	}
	
	/* 
	 * This function is written to accept one or two arguments. 
	 * We didn't want to write two separate classes for the same thing, 
	 * so instead Substr instances can be constructed to accept one or two 
	 * arguments. 
	 */
	public Substr(int argCount) {
		if(argCount <0 || argCount > 2)
			argCount = 1;
		this.argCount = argCount;
	}
	
	@Override
	public Object call(Interpreter funk, Object self, Object... args) {
		String ret = self.asString();
		int from = 0;
		int to = ret.length();
		
		if(args.length==1){
			to=((Number)args[0]).value;
		}
		else if(args.length > 1) {
			from = ((Number)args[0]).value;
			to = ((Number)args[1]).value;
		}
		
		if(from < 0)
			from += ret.length();
		if(to < 0)
			to += ret.length();
		
		if(to < from) {
			int tmp = to;
			to = from;
			from = tmp;
		}

		return new funk.lang.types.String(ret.substring(from, to));
	}

	@Override
	public int expectedArgumentCount() {
		return argCount;
	}

	@Override
	public Object expectedSelfType() {
		return Generic.instance; 
	}
}
