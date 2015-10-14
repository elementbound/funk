import java.util.List;
import java.util.ArrayList; 

public class Nonterminal implements IMatchable
{
	private List<Rule> rules = new ArrayList<Rule>(); 
	private String consumedString;
	
	public Nonterminal() {
		super();
	}
	
	public Nonterminal(Rule... rules)
	{
		super();
		this.add(rules); 
	}

	public boolean match(String s){

		for(Rule rule:rules){
			if(rule.match(s))
				s=rule.consume();			
		}

		consumedString = s;
		
		if(s.isEmpty())
			return true;

		return false;
	}
	
	public String consume(String s){
		return consumedString;
	}

	public void add(Rule... rules){
		for(Rule temprule:rules)
			this.rules.add(temprule);
	} 
}
