package funk;

public class IllegalCastException extends Exception {
	String message;
	Type from;
	Type to; 
	
	public IllegalCastException(Type from, Type to) {
		this.from = from;
		this.to = to;
		
		StringBuilder strb = new StringBuilder();
		strb.append("Illegal cast from ")
			.append(from)
			.append(" to ")
			.append(to);
		
		this.message = strb.toString();
	}
	
	public String what() {
		return this.message;
	}
}
