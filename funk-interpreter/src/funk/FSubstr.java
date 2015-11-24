package funk;

public class FSubstr implements ICallable {

	@Override
	public Object call(Object self, Object... args) throws IllegalCastException {
		String ret = self.asString();
		int from = 0;
		int to = ret.length();
		
		if(args.length==1){
			to=args[0].asNumber();;
		}
		else if(args.length > 1) {
			from = args[0].asNumber();
			to = args[1].asNumber();
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

		return new Object(ret.substring(from, to));
	}
}
