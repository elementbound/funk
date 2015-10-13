public class Rule {
	private List<IMatchable> ruleItems = new ArrayList<IMatchable>(); 
	private String consumedString; 
	
	public boolean match(String s) {
		s = ""; 
		
		for(IMatchable item : ruleItems)
		{
			if(!item.match(s))
				return false; 
			else 
				s = item.consume(s);
		}
		
		consumedString = s; 
		
		return true; 
	}
	
	public String consume() {
		return consumedString; 
	}
}
