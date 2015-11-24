package funk;

public class FPow implements ICallable {

	@Override
	public Object call(Object self, Object... args) throws IllegalCastException {
		switch(self.getType()) {
			case Number: {
				return new Object((int)Math.pow(self.asNumber(),
						Integer.parseInt(args[0].asString())));
			}
		
			case String: {
				String temp="";
				
				for(int i=0;i<Integer.parseInt(args[0].asString());i++)
					temp+=self.asString();

				return new Object(temp);
			}
			default:
				return self;
		}
	}
}
