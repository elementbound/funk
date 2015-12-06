package funk.lang.func;

import funk.Interpreter;
import funk.lang.IFunction;
import funk.lang.Object;
import funk.lang.types.Boolean;

public class TypeMatch implements IFunction {

	@Override
	public Object call(Interpreter funk, Object self, Object... args) {
		return new Boolean(self.typesMatch(args[0]));
	}

	@Override
	public int expectedArgumentCount() {
		return 1;
	}

	@Override
	public Class<? extends Object> expectedSelfType() {
		return Object.class;
	}
}
