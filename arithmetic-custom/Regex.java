import java.util.regex.Pattern;
import java.util.regex.Matcher;


class Regex implements IMatchable{
	String exp = new String();	
	public String name;

	public Regex(String name, String exp) {
		this.exp = "^(" + exp + ")";
		this.name = name; 
	}

	public boolean match(String s){
		System.out.printf("[%s]matching %s... %s\n", this.name, s, Pattern.matches(exp, s) ? "y" : "n");
		return Pattern.matches(exp, s);
	}

	public String consume(String s){
		Pattern p = Pattern.compile(exp);
		Matcher m = p.matcher(s);
		
		System.out.printf("[%s]consuming\n\t%s\n\t%s", this.name, s, m.replaceFirst(""));
		return  m.replaceFirst("");
	}
}
