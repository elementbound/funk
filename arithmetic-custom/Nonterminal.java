import java.util.List;
import java.util.ArrayList; 

public class Nonterminal implements IMatchable
{
	private List<Rule> rules = new ArrayList<Rule>(); 
	
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

		if(s.isEmpty())
			return true;

		return false;
	}
	
	public String consume(String s){
		return null;//i have no idea what i'm doing
	}

	public void add(Rule... rules){
		for(Rule temprule:rules)
			this.rules.add(temprule);
	} 
}
