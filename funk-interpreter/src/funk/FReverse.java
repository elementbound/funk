package funk;

import funk.lang.Object;
import funk.lang.types.Error;
import funk.lang.types.Number; 

public class FReverse implements ICallable {

	@Override
	public Object call(Object self, Object... args) {
		if(self instanceof Number) {
			StringBuilder strb = new StringBuilder();
			strb.append(self.asString());
			strb.reverse();
			
			return new Number(Integer.parseInt(strb.toString()));
		}
		
		if(self instanceof funk.lang.types.String) {
			StringBuilder strb = new StringBuilder();
			strb.append(self.asString());
			strb.reverse();
			
			return new funk.lang.types.String(strb.toString());
		}
		
		return new Error("WrongSelfType")
				.addField("type", self.typeString())
				.addField("self", self.toString())
				.addField("expectedType", "String, Number");
	}

}
