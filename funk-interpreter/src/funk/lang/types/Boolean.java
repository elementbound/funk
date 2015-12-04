package funk.lang.types;

import funk.lang.Object;

public class Boolean extends Object {
	public boolean value; 
	
	public Boolean() {
		this.value = false;
	}
	
	public Boolean(boolean v) {
		value = v;
	}

	@Override
	public boolean asBoolean() {
		return value;
	}

	@Override
	public String asString() {
		return value ? "True" : "False";
	}

	@Override
	public Object opAdd(Object rhs) {
		return new Boolean(this.asBoolean() || rhs.asBoolean());
	}

	@Override
	public Object opSubtract(Object rhs) {
		return new Boolean(this.asBoolean() && !rhs.asBoolean());
	}

	@Override
	public Object opMultiply(Object rhs) {
		return new Boolean(this.asBoolean() && rhs.asBoolean());
	}

	@Override
	public Object opDivide(Object rhs) {
		return new Boolean(this.asBoolean() || rhs.asBoolean());
	}

	@Override
	public boolean equals(Object rhs) {
		return this.value == rhs.asBoolean();
	}

	@Override
	public boolean lowerThan(Object rhs) {
		return (this.value?1:0) < (rhs.asBoolean()?1:0);
	}

	@Override
	public boolean greaterThan(Object rhs) {
		return (this.value?1:0) > (rhs.asBoolean()?1:0);
	}
}
