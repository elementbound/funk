package funk.lang.func;

import funk.Interpreter;
import funk.lang.IFunction;
import funk.lang.Object;
import funk.lang.types.Generic; 

public class Println implements IFunction {
	@Override
	public Object call(Interpreter funk, Object self, Object... args) {
		System.out.println(self.asString());
		
		return self;
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
