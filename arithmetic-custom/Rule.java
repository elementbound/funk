import java.util.List; 
import java.util.ArrayList; 

public class Rule {
	private List<IMatchable> ruleItems = new ArrayList<IMatchable>(); 
	private String consumedString; 
	public String name;
	
	public Rule(String name) {
		super();
		this.name = name; 
	}
	
	public Rule(String name, IMatchable... items) {
		super(); 
		this.name = name; 
		this.add(items); 
	}
	
	public boolean match(String s) {
		//s = ""; 
		
		System.out.printf("[%s]matching start\n", this.name);
		for(IMatchable item : ruleItems)
		{
			if(!item.match(s))
			{
				System.out.printf("[%s]matching fail\n", this.name);
				return false;
			}
			else 
				s = item.consume(s);
		}
		
		consumedString = s; 
		
		return true; 
	}
	
	public String consume() {
		System.out.printf("[%s]consuming\n\t%s\n", this.name, this.consumedString);
		return consumedString; 
	}
	
	public void add(IMatchable... items)
	{
		for(IMatchable item : items)
			ruleItems.add(item); 
	}
}
