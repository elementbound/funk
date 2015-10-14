import java.util.regex.Pattern;
import java.util.regex.Matcher;


class Regex implements IMatchable{
	String exp= new String();	

	public Regex(String exp) {
		this.exp = exp;
	}

	public boolean match(String s){
		return Pattern.matches(exp, s);
	}

	public String consume(String s){
		Pattern p = Pattern.compile(exp);
		Matcher m = p.matcher(s);
		return  m.replaceFirst("");
	}
}
