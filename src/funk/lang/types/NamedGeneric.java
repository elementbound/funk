package funk.lang.types;

import java.lang.String;

import funk.lang.Object; 

public class NamedGeneric extends Generic {
	private String typeName = "Generic Generic"; 
	
	public NamedGeneric(String typeName) {
		this.typeName = typeName;
	}
	
	@Override 
	public String asString() {
		return typeName;
	}
	
	@Override 
	public String typeString() {
		return this.typeName;
	}
	
	@Override 
	public boolean typesMatch(Object rhs) {
		if(!super.typesMatch(rhs))
			return false; 
		
		return this.typeName.equals(((NamedGeneric)rhs).typeName);
	}
	
	@Override
	public Object construct(Object... args) throws InstantiationException, IllegalAccessException {
		return new NamedGeneric(this.typeName);
	}
}
