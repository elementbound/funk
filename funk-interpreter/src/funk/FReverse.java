package funk;

public class FReverse implements ICallable {

	@Override
	public Object call(Object self, Object... args) {
		switch(self.getType()) {
			case Number: {
				StringBuilder strb = new StringBuilder();
				strb.append(self.asString());
				strb.reverse();
				
				try {
					System.out.printf("Reversing number: %d\n", self.asNumber());
				} catch (IllegalCastException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return new Object(Integer.parseInt(strb.toString()));
			}
			
			case String: {
				StringBuilder strb = new StringBuilder();
				strb.append(self.asString());
				strb.reverse();

				System.out.printf("Reversing string: %s\n", self.asString());
				
				return new Object(strb.toString());
			}

			default:
				return self;
		}
	}

}
