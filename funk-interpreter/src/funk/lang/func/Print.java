package funk.lang.func;

import funk.lang.IFunction;
import funk.lang.Object; 

public class Print implements IFunction{
	
	@Override
	public Object call(Object self, Object... args) {
		System.out.println(self.asString());
		return self;
	}
}
