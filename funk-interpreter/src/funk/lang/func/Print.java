package funk.lang.func;

import funk.Interpreter;
import funk.lang.IFunction;
import funk.lang.Object; 

public class Print implements IFunction{
	
	@Override
	public Object call(Interpreter funk, Object self, Object... args) {
		System.out.print(self.asString());
		return self;
	}

	@Override
	public int expectedArgumentCount() {
		return 0;
	}
}
