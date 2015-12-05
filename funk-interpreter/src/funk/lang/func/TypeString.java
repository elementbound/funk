package funk.lang.func;

import funk.Interpreter;
import funk.lang.IFunction;
import funk.lang.Object;

public class TypeString implements IFunction {
	@Override
	public Object call(Interpreter funk, Object self, Object... args) {
		return new funk.lang.types.String(self.typeString());
	}

	@Override
	public int expectedArgumentCount() {
		return 0;
	}
}
