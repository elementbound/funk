package funk.lang.types;

import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import funk.lang.Object;
import funk.lang.StandardErrors;

public class Aggregate extends Object {
	public String typeName = "Aggregate";
	public List<String> fields = new ArrayList<>();
	public Map<String, Object> values = new HashMap<>();
	
	public Aggregate() {
		
	}
	
	public Aggregate(String type) {
		this.typeName = type; 
	}
	
	public Aggregate addField(String name) {
		fields.add(name);
		return this;
	}
	
	@Override 
	public Object construct(Object... args) {
		Aggregate result = new Aggregate(this.typeName);
		result.fields.addAll(this.fields); 
		
		for(int i = 0; i < result.fields.size(); i++) {
			if(i < args.length) 
				result.values.put(result.fields.get(i), args[i]);
			else 
				result.values.put(result.fields.get(i), new Boolean(false));
		}
		
		return result; 
	}
	
	@Override
	public boolean asBoolean() {
		if(!fields.isEmpty())
			return values.get(fields.get(0)).asBoolean();
		
		return false;
	}

	@Override
	public String asString() {
		StringBuilder strb = new StringBuilder();
		strb.append("{ Aggregate ")
			.append(typeName)
			.append(" | ");
		
		for(String f : fields) 
			strb.append(f)
				.append(": ")
				.append(values.get(f).asString())
				.append("; ");
		
		return strb.append('}').toString();
	}
	
	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();
		strb.append('{')
			.append(this.typeString())
			.append(" | ");
		
		for(String f : fields)
			strb.append(f)
				.append(": ")
				.append(values.get(f))
				.append("; ");
		
		return strb.append('}').toString();
	}
	
	@Override 
	public String typeString() {
		return "Aggregate:" + typeName;
	}
	
	@Override
	public boolean typesMatch(Object rhs) {
		if(super.typesMatch(rhs))
			return this.typeName.equals(((Aggregate)rhs).typeName);
		else 
			return false; 
	}

	@Override
	public Object opAdd(Object rhs) {
		return StandardErrors.IllegalOperation("add", this, rhs);
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
	public Object opNegate() {
		return StandardErrors.IllegalOperation("negate", this, new Error("void"));
	}

	@Override
	public boolean equals(Object rhs) {
		if(!typesMatch(rhs))
			return false; 
		
		for(Entry<String, Object> e : values.entrySet())
			if(!e.getValue().equals(((Aggregate)rhs).values.get(e.getKey())))
				return false;
			
		return true; 
	}

	@Override
	public boolean lowerThan(Object rhs) {
		return false;
	}

	@Override
	public boolean greaterThan(Object rhs) {
		return false;
	}
}
