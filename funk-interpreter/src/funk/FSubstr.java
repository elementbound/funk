package funk;

import funk.lang.IFunction;
import funk.lang.Object; 
import funk.lang.types.Number; 

public class FSubstr implements IFunction {

	@Override
	public Object call(Object self, Object... args) {
		String ret = self.asString();
		int from = 0;
		int to = ret.length();
		
		if(args.length==1){
			to=((Number)args[0]).value;
		}
		else if(args.length > 1) {
			from = ((Number)args[0]).value;
			to = ((Number)args[1]).value;
		}
		
		if(from < 0)
			from += ret.length();
		if(to < 0)
			to += ret.length();
		
		if(to < from) {
			int tmp = to;
			to = from;
			from = tmp;
		}

		return new funk.lang.types.String(ret.substring(from, to));
	}
}
