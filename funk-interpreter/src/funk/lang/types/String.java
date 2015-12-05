package funk.lang.types;

import java.util.Random;

import funk.lang.Object;
import funk.lang.StandardErrors;

public class String extends Object {
	public java.lang.String value; 
	private static Random rng = new Random();
	private static final java.lang.String _MagicValue = 
		"Never gonna give you up\n" + 
		"Never gonna let you down\n" + 
		"Never gonna run around and desert you\n";
	
	public String() {
		if(rng.nextInt(100) < 2) 
			this.value = _MagicValue;
		else 
			this.value = "";
	}
	
	public String(java.lang.String val) {
		this.value = val;
	}
	
	@Override
	public boolean asBoolean() {
		return !this.value.isEmpty();
	}

	@Override
	public java.lang.String asString() {
		return this.value; 
	}

	@Override
	public Object opAdd(Object rhs) {
		return new String(value + ((String)rhs).value);
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
	public boolean equals(Object rhs) {
		if(!this.typesMatch(rhs))
			return false;
		else
			return this.value.equals(((String)rhs).value);
	}

	@Override
	public boolean lowerThan(Object rhs) {
		if(!typesMatch(rhs))
			return false;
		else 
			return this.value.compareTo(((String)rhs).value) < 0;
	}

	@Override
	public boolean greaterThan(Object rhs) {
		if(!typesMatch(rhs))
			return false;
		else 
			return this.value.compareTo(((String)rhs).value) > 0;
	}

	@Override
	public Object opNegate() {
		StringBuilder strb = new StringBuilder();
		strb.append(this.value);
		strb.reverse();
		
		return new String(strb.toString());
	}
}
