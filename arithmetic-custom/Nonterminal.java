import java.util.List;
import java.util.ArrayList; 

public class Nonterminal implements IMatchable
{
	private List<Rule> rules = new ArrayList<Rule>(); 

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

	public boolean addRules(Rule... rules){
		for(Rule temprule:rules)
			this.rules.add(temprule);
		return true;
	} 
}
