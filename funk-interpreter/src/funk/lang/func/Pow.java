package funk.lang.func;

import funk.lang.IFunction;
import funk.lang.Object;
import funk.lang.types.Number;
import funk.lang.types.Error;

public class Pow implements IFunction {

	@Override
	public Object call(Object self, Object... args) {
		if(args.length < 1)
			return new Error("WrongArgumentCount")
						.addField("argCount", Integer.toString(args.length))
						.addField("expectedArgCount", "1");
		
		if(!(args[0] instanceof Number))
			return new Error("WrongArgumentType")
						.addField("argType", args[0].typeString())
						.addField("expectedType", "Number");
		
		//
		
		if(self instanceof Number) {
			Number n = (Number)self;
			Number p = (Number)args[0];
			
			return new Number((int)Math.pow(n.value, n.value));
		}
		
		if(self instanceof funk.lang.types.String) {
			funk.lang.types.String n = (funk.lang.types.String)self;
			Number p = (Number)args[0];
			
			StringBuilder strb = new StringBuilder();
			for(int i = 0; i < p.value; i++)
				strb.append(n.value);
			
			return new funk.lang.types.String(strb.toString());
		}
		
		return new Error("WrongSelfType")
					.addField("type", self.typeString())
					.addField("self", self.toString())
					.addField("expectedType", "String, Number");
	}
}
