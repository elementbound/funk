package funk.lang.types;

import java.util.Random;

import funk.lang.Object;

public class Number extends Object {
	public double value; 
	private static Random rng = new Random(80085);
	
	public Number() {
		this.value = rng.nextInt();
	}
	
	public Number(int v) {
		value = v;
	}
	
	public Number(double v) {
		value = v;
	}
	
	@Override
	public boolean asBoolean() {
		return this.value != 0;
	}

	@Override
	public java.lang.String asString() {
	    if(value == (long) value)
	        return java.lang.String.format("%d",(long)value);
	    else
	        return java.lang.String.format("%s",value);
	}

	@Override
	public Object opAdd(Object rhs) {
		return new Number(value + ((Number)rhs).value);
	}

	@Override
	public Object opSubtract(Object rhs) {
		return new Number(value - ((Number)rhs).value);
	}

	@Override
	public Object opMultiply(Object rhs) {
		return new Number(value * ((Number)rhs).value);
	}

	@Override
	public Object opDivide(Object rhs) {
		return new Number(value / ((Number)rhs).value);
	}

	@Override
	public boolean equals(Object rhs) {
		if(!this.typesMatch(rhs))
			return false;
		else 
			return value == ((Number)rhs).value;
	}

	@Override
	public boolean lowerThan(Object rhs) {
		if(!this.typesMatch(rhs))
			return false;
		else 
			return value < ((Number)rhs).value;
	}

	@Override
	public boolean greaterThan(Object rhs) {
		if(!this.typesMatch(rhs))
			return false;
		else 
			return value > ((Number)rhs).value;
	}

	@Override
	public Object opNegate() {
		return new Number(-this.value);
	}
}
