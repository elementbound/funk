import java.util.List;
import java.util.ArrayList; 

public class Nonterminal implements IMatchable
{
	private List<Rule> rules = new ArrayList<Rule>(); 
	
	public boolean match(String s); 
	public String  consume(String s); 
	public boolean addRules(Rule... rules); 
}
