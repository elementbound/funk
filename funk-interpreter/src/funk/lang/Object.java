package funk.lang;

import funk.lang.types.Boolean;

abstract public class Object implements Cloneable {
	public abstract boolean asBoolean(); 
	public abstract String asString();

	@Override
	public final String toString() {
		StringBuilder strb = new StringBuilder();
		strb.append('[')
			.append(this.typeString())
			.append("] ")
			.append(this.asString());
		
		return strb.toString();
	}
	
	public String typeString() {
		return this.getClass().getSimpleName();
	}
	
	public boolean typesMatch(Object rhs) {
		return this.getClass().equals(rhs.getClass());
	}
	
	//Basic arithmetic operators
	public abstract Object opAdd(Object rhs);
	public abstract Object opSubtract(Object rhs);
	public abstract Object opMultiply(Object rhs);
	public abstract Object opDivide(Object rhs);
	
	public abstract Object opNegate();
	
	//Relational functions
	public abstract boolean equals(Object rhs);
	public abstract boolean lowerThan(Object rhs); 
	public abstract boolean greaterThan(Object rhs);
	
	public boolean lowerOrEquals(Object rhs) {
		return this.equals(rhs) || this.lowerThan(rhs);
	}
	
	public boolean greaterOrEquals(Object rhs) {
		return this.equals(rhs) || this.greaterThan(rhs);
	}
	
	//Relational operators
	public Object opEquals(Object rhs) { 
		return new Boolean(this.equals(rhs));
	}
	
	public Object opNotEquals(Object rhs) {
		return new Boolean(!this.equals(rhs));
	}
	
	public Object opLowerThan(Object rhs) {
		return new Boolean(this.lowerThan(rhs));
	}
	
	public Object opGreaterThan(Object rhs) {
		return new Boolean(this.greaterThan(rhs));
	}
	
	public Object opLowerOrEquals(Object rhs) {
		return new Boolean(this.lowerOrEquals(rhs));
	}
	
	public Object opGreaterOrEquals(Object rhs) {
		return new Boolean(this.greaterOrEquals(rhs));
	}
}
