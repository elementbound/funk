package funk;

import funk.lang.Object; 

public class FPrint implements ICallable{
	
	@Override
	public Object call(Object self, Object... args) {
		System.out.println(self.asString());
		return self;
	}
}
