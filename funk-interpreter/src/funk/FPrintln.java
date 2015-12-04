package funk;

import funk.lang.Object; 

public class FPrintln implements ICallable {

	@Override
	public Object call(Object self, Object... args) {
		System.out.println(self.asString());
		return self;
	}

}
