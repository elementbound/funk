package funk;

public class Object {
	private Type	type;
	private String	asString;
	private int		asNumber;
	private boolean	asBoolean; 
	
	public Type getType() {
		return type; 
	}
	
	//=========================================================================================
	// Constructors
	
	public Object() {
		type = Type.Boolean;
		asBoolean = false;
	}
	
	public Object(boolean b) {
		type = Type.Boolean;
		asBoolean = b;
	}
	
	public Object(int n) {
		type = Type.Number;
		asNumber = n;
	}
	
	public Object(String str) {
		type = Type.String;
		asString = str;
	}
	
	//=========================================================================================
	// Get value
	
	public String asString() {
		switch(type)  {
			case Number: 
				return Integer.toString(this.asNumber);
				
			case Boolean:
				return Boolean.toString(this.asBoolean);
				
			case String: 
				return this.asString;
				
			default: 
				return "???";
		}
	}
	
	public boolean asBoolean() throws IllegalCastException {
		switch(type) {
			case Number: 
				return this.asNumber != 0;
				
			case Boolean:
				return this.asBoolean;
				
			case String:
				return this.asString.length() > 0;
				
			default: 
				throw new IllegalCastException(type, Type.Boolean);
		}
	}
	
	public int asNumber() throws IllegalCastException {
		switch(type) {
			case Number: 
				return this.asNumber;
				
			case Boolean: 
				return this.asBoolean ? 1 : 0;
				
			case String: 
			default: 
				throw new IllegalCastException(type, Type.Number);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();
		return strb.append("[").append(this.type).append("] ").append(this.asString()).toString();
	}
	
	//=========================================================================================
	// Set value
	
	public void assign(Object rhs) {
		this.type = rhs.type;
		this.asBoolean = rhs.asBoolean;
		this.asNumber = rhs.asNumber;
		this.asString = rhs.asString;
	}
	
	public void assign(int x) {
		this.type = Type.Number;
		this.asNumber = x;
	}
	
	public void assign(boolean x) {
		this.type = Type.Boolean;
		this.asBoolean = x;
	}
	
	public void assign(String str) {
		this.type = Type.String;
		this.asString = str;
	}
	
	//=========================================================================================
	// Builtin operators
	
	public Object add(Object rhs) throws IllegalCastException {
		switch(type) {
			case Boolean: 
				return new Object(this.asBoolean || rhs.asBoolean());
				
			case Number: 
				return new Object(this.asNumber + rhs.asNumber());
				
			case String: 
				return new Object(this.asString + rhs.asString());
				
			default:
				return new Object();
		}
	}
}
