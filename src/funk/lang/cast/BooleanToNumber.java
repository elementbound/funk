package funk.lang.cast;

import funk.lang.ICastRule;

import funk.lang.Object; 
import funk.lang.types.Boolean;
import funk.lang.types.Number;

public class BooleanToNumber implements ICastRule<funk.lang.types.Boolean, funk.lang.types.Number> {

	@Override
	public Number cast(Object from) {
		Boolean b = (Boolean)from;
		return b.value ? new Number(1) : new Number(0);
	}

	@Override
	public Class<Boolean> from() {
		return Boolean.class;
	}

	@Override
	public Class<Number> to() {
		return Number.class; 
	}

}
