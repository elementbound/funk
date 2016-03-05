package funk.lang.types;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.PrintStream;
import java.lang.String; 

import funk.lang.Object;

public class Error extends Object {
	private String error; 
	private Map<String, String> fields = new HashMap<>(); 
	private boolean fresh = true; 
	
	public Error(String type) {
		error = type; 
	}
	
	public Error(String type, String... data) {
		error = type; 
		for(int i = 0; i < data.length; i += 2) {
			fields.put(data[i], data[i+1]);
		}
	}
	
	public Error addField(String key, String value) {
		fields.put(key, value);
		return this; 
	}
	
	public java.lang.String asPrettyString() {
		StringBuilder strb = new StringBuilder();
		strb.append("Funk error: ")
			.append(this.error)
			.append(" \n");
		
		for(Entry<String, String> e : fields.entrySet())
			strb.append('\t')
				.append(e.getKey())
				.append(": ")
				.append(e.getValue())
				.append('\n');
		
		return strb.toString();
	}
	
	public boolean isFresh() {
		if(fresh) {
			fresh = false;
			return true;
		}
		
		return false; 
	}
	
	public void prettyPrint(PrintStream os) {
		if(this.isFresh())
			os.print(this.asPrettyString());
	}
	
	@Override
	public boolean asBoolean() {
		return false;
	}

	@Override
	public java.lang.String asString() {
		StringBuilder strb = new StringBuilder();
		strb.append("{Error: ")
			.append(this.error)
			.append(" | ");
		
		for(Entry<String, String> e : fields.entrySet())
			strb.append(e.getKey())
				.append(": ")
				.append(e.getValue())
				.append("; ");

		return strb.append('}').toString();
	}
	
	@Override
	public Object opAdd(Object rhs) {
		return this; 
	}

	@Override
	public Object opSubtract(Object rhs) {
		return this;
	}

	@Override
	public Object opMultiply(Object rhs) {
		return this;
	}

	@Override
	public Object opDivide(Object rhs) {
		return this;
	}

	@Override
	public boolean equals(Object rhs) {
		return false; 
	}

	@Override
	public boolean lowerThan(Object rhs) {
		return false;
	}

	@Override
	public boolean greaterThan(Object rhs) {
		return false;
	}
	
	@Override
	public Object opNegate() {
		return this;
	}
}
