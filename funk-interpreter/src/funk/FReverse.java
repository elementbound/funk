package funk;

public class FReverse implements ICallable {

	@Override
	public Object call(Object self, Object... args) {
		switch(self.getType()) {
			case Number: {
				StringBuilder strb = new StringBuilder();
				strb.append(self.asString());
				strb.reverse();
				
				return new Object(Integer.parseInt(strb.toString()));
			}
			
			case String: {
				StringBuilder strb = new StringBuilder();
				strb.append(self.asString());
				strb.reverse();
				
				return new Object(strb.toString());
			}

			default:
				return self;
		}
	}

}
