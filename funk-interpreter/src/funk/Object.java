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
	// Get value
	
	public String asString() throws IllegalCastException {
		switch(type)  {
			case Number: 
				return Integer.toString(this.asNumber);
				
			case Boolean:
				return Boolean.toString(this.asBoolean);
				
			case String: 
				return this.asString;
				
			default: 
				throw new IllegalCastException(this.type, Type.String);
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
}
