package funk.lang.types;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import funk.lang.StandardErrors;


import funk.lang.Object; 

public class Collection extends Object {
	private List<Entry<Object, Object>> collection = new ArrayList<>();
	private int iterator=0;
	private boolean isArray = true; 
		
	@Override
	public boolean asBoolean() {
		if(!collection.isEmpty())
			return true;
		
		return false;
	}

	@Override
	public java.lang.String asString() {
		StringBuilder strb = new StringBuilder();
		strb.append("{ Collection | ");
		
		for(Entry<Object, Object> f : collection) 
			strb.append(f.getKey().toString())
				.append(": ")
				.append(f.getValue().toString())
				.append("; ");
		
		return strb.append('}').toString();
	}
	
	private boolean incrementalArraynessValidation(Object newKey) {
		if(!(newKey instanceof Number)) 
			return false; 
		
		Number nkey = (Number) newKey; 
		if(nkey.value < 0)
			return false; 
		
		if(nkey.value != (int) nkey.value)
			return false; 
		
		int n = (int) nkey.value; 
		if(n == 0)
			return true; 
		
		if(!this.has(new Number(n-1)))
			return false; 
		
		return true; 
	}
	
	public void put(Object key, Object value) {
		for(Entry<Object, Object> f : collection) 
			if(f.getKey().equals(key)) {
				f.setValue(value);
				return;
			}
		
		collection.add(new SimpleEntry<Object, Object>(key, value));
		
		this.isArray &= incrementalArraynessValidation(key);
	}
	
	public void add(Object value) {
		int maxVal = -1;
		for(Entry<Object,Object> entry : collection)
			if(entry.getKey() instanceof Number){ 
				Number num = (Number) entry.getKey();
				
				if(num.value>maxVal)
					maxVal = (int) ((Number) entry.getKey()).value;
			}
		
		collection.add(new SimpleEntry<Object,Object>(new Number(maxVal+1), value));
	}
	
	public Object get(Object key) {
		for(Entry<Object, Object> e: collection)
			if(e.getKey().equals(key))
				return e.getValue();
		
		return null;
	}
	
	public List<Object> keys() {
		List<Object> returnList= new ArrayList<Object>();
		
		for(Entry<Object,Object> entry : collection)
			returnList.add(entry.getKey());
			
		return returnList;
	}
	
	public List<Object> values() {
		List<Object> returnList= new ArrayList<Object>();
		
		for(Entry<Object,Object> entry : collection)
			returnList.add(entry.getValue());
		
		return returnList; 
	}
	
	public int size() { 
		return collection.size();
	}
	
	public boolean has(Object key) {
		for(Entry<Object, Object> e: collection)
			if(e.getKey().equals(key))
				return true;
		
		return false; 
	}
	
	public boolean hasValue(Object value) {
		for(Entry<Object, Object> e: collection)
			if(e.getValue().equals(value))
				return true;
		
		return false; 
	}
	
	public void rewind() {
		iterator=0;
	}
	
	public boolean pastEnd() {
		if(iterator >= collection.size())
			return true;
		
		return false; 
	}
	
	public void next() {
		iterator++;
	}
	
	public Object key() {
		return collection.get(iterator).getKey();
	}
	
	public Object value() {
		return collection.get(iterator).getValue();
	}
	
	public static Collection mergeArrays(Collection... collections) {
		Collection result = new Collection();
		
		for(Collection c: collections)
			for(Object o: c.values())
				result.add(o);
		
		return result; 
	}
	
	public static Collection mergeMaps(Collection... collections) {
		Collection result = new Collection();
		
		for(Collection c: collections)
			for(Entry<Object, Object> e: c.collection)
				result.put(e.getKey(), e.getValue());
		
		return result; 
	}
	
	@Override 
	public Object accessIndex(Object index) {
		Object result = this.get(index);
		if(result == null)
			return StandardErrors.UnknownIndexError(index, this);
		
		return result;
	}

	@Override 
	public Object assignIndex(Object index, Object value) {
		this.put(index, value);
		return value; 
	}
	
	@Override 
	public Object assignEmptyIndex(Object value) {
		this.add(value);
		return value;
	}
	
	@Override
	public Object opAdd(Object rhs) {
		// Alapj�raton k�pezze a k�t halmaz uni�j�t - csin�ljon egy �j Collection-t, pakolja bele this �sszes elem�t, 
		// majd rhs-nek azon elemeit amelyek kulcsa m�g nem szerepel az eredm�nyben

		if(!(rhs instanceof Collection)) 
			return StandardErrors.IllegalOperation("opAdd", this, rhs);
		
		Collection rhsc = (Collection) rhs;
		
		if(this.isArray() && rhsc.isArray())
			return mergeArrays(this, rhsc);
		else 
			return mergeMaps(this, rhsc);
	}

	@Override
	public Object opSubtract(Object rhs) {
		// Meh. Csak adjon vissza egy IllegalOperation error-t. 
		return StandardErrors.IllegalOperation("opSubtract", this);
	}

	public Object opMultiply(Object rhs) {
		// IllegalOperation error
		return StandardErrors.IllegalOperation("opMultiply", this);
	}

	@Override
	public Object opDivide(Object rhs) {
		// IllegalOperation error
		return StandardErrors.IllegalOperation("opDivide", this);
	}

	@Override
	public Object opNegate() {
		// IllegalOperation error
		return StandardErrors.IllegalOperation("opNegate", this);
	}

	@Override
	public boolean equals(Object rhs) {
		if(!typesMatch(rhs))
			return false; 
		
		Collection rhsc = (Collection) rhs; 
		
		if(this.size() != rhsc.size())
			return false; 
		
		for(Entry<Object, Object> e: collection)
			if(!e.getValue().equals(rhsc.get(e.getKey())))
				return false;
		
		return true; 
	}

	@Override
	public boolean lowerThan(Object rhs) {
		if(!typesMatch(rhs))
			return false; 
		
		return this.size() < ((Collection) rhs).size();
	}

	@Override
	public boolean greaterThan(Object rhs) {
		if(!typesMatch(rhs))
			return false; 
		
		return this.size() > ((Collection) rhs).size();
	}

	public boolean isArray() {
		return this.isArray; 
	}
}
