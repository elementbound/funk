package funk.lang.cast;

import funk.lang.ICastRule;
import funk.lang.types.Boolean;
import funk.lang.types.Number;

public class BooleanToNumber implements ICastRule<funk.lang.types.Boolean, funk.lang.types.Number> {

	@Override
	public Number cast(Boolean from) {
		return from.value ? new Number(1) : new Number(0);
	}

}
