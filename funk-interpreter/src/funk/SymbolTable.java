package funk;

import java.util.HashMap;
import java.util.Map;

import funk.lang.Object;

public class SymbolTable {
	public Map<String, Object> table = new HashMap<>();
	
	public Object get(String key){
		return table.get(key);
	}
	
    public void set(String key, Object val){
    	table.put(key, val);
    }
    
    public boolean exists(String key){
    	return table.containsKey(key);
    }
}
