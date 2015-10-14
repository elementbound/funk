import java.util.List;
import java.util.ArrayList; 

public class Nonterminal
{
	private List<Rule> rules = new ArrayList<Rule>(); 
	String consumedString;

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
	
	public String consume(){
		return consumedString;
	}

	public boolean addRules(Rule... rules){
		for(Rule temprule:rules)
			this.rules.add(temprule);
		return true;
	} 
}
