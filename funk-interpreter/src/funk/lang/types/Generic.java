package funk.lang.types;

import funk.lang.Object;
import funk.lang.StandardErrors;

/* The purpose of this type to match any other type when compared. 
 * This only works on when lhs is the AnyType instance
 */
public class Generic extends Object {
	public static final Generic instance = new Generic(); 

	@Override
	public boolean asBoolean() {
		return true;
	}

	@Override
	public java.lang.String asString() {
		return "Any";
	}

	@Override
	public Object opAdd(Object rhs) {
		return StandardErrors.IllegalOperation("add", this, rhs);
	}

	@Override
	public Object opSubtract(Object rhs) {
		return StandardErrors.IllegalOperation("subtract", this, rhs);
	}

	@Override
	public Object opMultiply(Object rhs) {
		return StandardErrors.IllegalOperation("multiply", this, rhs);
	}

	@Override
	public Object opDivide(Object rhs) {
		return StandardErrors.IllegalOperation("divide", this, rhs);
	}

	@Override
	public Object opNegate() {
		return StandardErrors.IllegalOperation("negate", this);
	}

	@Override
	public boolean equals(Object rhs) {
		return false;
	}

	@Override
	public boolean lowerThan(Object rhs) {
		return false;
	}

	@Override
	public boolean greaterThan(Object rhs) {
		return false;
	}
}
