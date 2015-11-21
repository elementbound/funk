package funk;

public class IllegalCastException extends Exception {
	Type from;
	Type to; 
	
	public IllegalCastException(Type from, Type to) {
		super("Illegal cast from " + from + " to " + to);
		
		this.from = from;
		this.to = to;
	}
}
