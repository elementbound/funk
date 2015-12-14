package funk.lang.types;

import java.util.Random;

import funk.lang.Object;

public class Corporal extends Object {
	public double value; 
	private static Random rng = new Random(80085);
	
	public Corporal() {
		this.value = rng.nextDouble();
	}
	
	public Corporal(double v) {
		value = v;
	}
	
	public Corporal(int v) {
		value = (double) v;
	}
	
	@Override
	public boolean asBoolean() {
		return this.value != 0.0;
	}

	@Override
	public java.lang.String asString() {
		return java.lang.String.valueOf(value);
	}

	@Override
	public Object opAdd(Object rhs) {
		return new Corporal(value + ((Corporal)rhs).value);
	}

	@Override
	public Object opSubtract(Object rhs) {
		return new Corporal(value - ((Corporal)rhs).value);
	}

	@Override
	public Object opMultiply(Object rhs) {
		return new Corporal(value * ((Corporal)rhs).value);
	}

	@Override
	public Object opDivide(Object rhs) {
		return new Corporal(value / ((Corporal)rhs).value);
	}

	@Override
	public boolean equals(Object rhs) {
		if(!this.typesMatch(rhs))
			return false;
		else 
			return value == ((Corporal)rhs).value;
	}

	@Override
	public boolean lowerThan(Object rhs) {
		if(!this.typesMatch(rhs))
			return false;
		else 
			return value < ((Corporal)rhs).value;
	}

	@Override
	public boolean greaterThan(Object rhs) {
		if(!this.typesMatch(rhs))
			return false;
		else 
			return value > ((Corporal)rhs).value;
	}

	@Override
	public Object opNegate() {
		return new Corporal(-this.value);
	}
}
