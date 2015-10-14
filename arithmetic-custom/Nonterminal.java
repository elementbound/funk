import java.util.List;
import java.util.ArrayList; 

public class Nonterminal implements IMatchable
{
	private List<Rule> rules = new ArrayList<Rule>(); 
	private String consumedString;
	public String name;
	
	public Nonterminal(String name) {
		super();
		this.name = name; 
	}
	
	public Nonterminal(String name, Rule... rules)
	{
		super();
		this.name = name; 
		this.add(rules); 
	}

	public boolean match(String s){
		System.out.printf("[%s]matching start\n", this.name);
		
		for(Rule rule:rules){
			if(rule.match(s)) {
				consumedString = rule.consume();
				System.out.printf("[%s]matching success\n", this.name);
				
				return true; 
			}
		}
		
		System.out.printf("[%s]matching fail\n", this.name);
		return false;
	}
	
	public String consume(String s){
		System.out.printf("[%s]consuming\n\t%s\n\t%s\n", this.name, s, this.consumedString);
		return consumedString;
	}

	public void add(Rule... rules){
		for(Rule temprule:rules)
			this.rules.add(temprule);
	} 
}
