package funk.lib.Random;

import java.util.ArrayList;
import java.util.List;

import funk.Interpreter;
import funk.Utils;
import funk.lang.FunctionTemplate;
import funk.lang.IFunclet;
import funk.lang.IFunction;
import funk.lang.ILibrary;
import funk.lang.Object;
import funk.lang.types.Boolean;
import funk.lang.types.Number;
import funk.lang.types.Error;

public class Library implements ILibrary {

	@Override
	public void inject(Interpreter funk) {
		funk.registerType("Random", new Random());
		
		//-------------------------------------------------------------------------------------
		//seed(val)
		funk.registerFunction("seed", new FunctionTemplate(new Random(), new IFunclet() {
			@Override
			public Object call(Object baseSelf, Object... args) {
				Random self = (Random) baseSelf;
				int seed =(int) ((Number)args[0]).value; 
				
				self.seed(seed);
				return self;
			}
		}, Number.class));
		
		//-------------------------------------------------------------------------------------
		//randomNumber()
		funk.registerFunction("number", new FunctionTemplate(new Random(), new IFunclet() {
			@Override
			public Object call(Object baseSelf, Object... args) {
				Random self = (Random) baseSelf;
				
				return new Number((int) self.randomNumber());
			}
		}));
		
		//-------------------------------------------------------------------------------------
		//randomNumber(min, max)
		funk.registerFunction("number", new FunctionTemplate(new Random(), new IFunclet() {
			@Override
			public Object call(Object baseSelf, Object... args) {
				Random self = (Random) baseSelf;
				double min = ((Number)args[0]).value;
				double max = ((Number)args[1]).value; 
				
				return new Number(self.randomNumber(min, max));
			}
		}, Number.class, Number.class));
		
		//-------------------------------------------------------------------------------------
		//randomBoolean()
		funk.registerFunction("boolean", new FunctionTemplate(new Random(), new IFunclet() {
			@Override
			public Object call(Object baseSelf, Object... args) {
				Random self = (Random) baseSelf;
				
				return new Boolean(self.randomBoolean());
			}
		}));
		
		//-------------------------------------------------------------------------------------
		//randomString(length)
		funk.registerFunction("string", new FunctionTemplate(new Random(), new IFunclet() {
			@Override
			public Object call(Object baseSelf, Object... args) {
				Random self = (Random) baseSelf;
				int length = (int) ((Number)args[0]).value;
				
				return new funk.lang.types.String(self.randomString(length, 32, 125));
			}
		}, Number.class));
		
		//-------------------------------------------------------------------------------------
		//randomString(length, min, max)
		funk.registerFunction("string", new FunctionTemplate(new Random(), new IFunclet() {
			@Override
			public Object call(Object baseSelf, Object... args) {
				Random self = (Random) baseSelf;
				int length = (int) ((Number)args[0]).value;
				int min = (int) ((Number)args[1]).value;
				int max = (int) ((Number)args[2]).value;
				
				return new funk.lang.types.String(self.randomString(length, min, max));
			}
		}, Number.class, Number.class, Number.class));
		
		//-------------------------------------------------------------------------------------
		//randomString(length, alphabet)
		funk.registerFunction("string", new FunctionTemplate(new Random(), new IFunclet() {
			@Override
			public Object call(Object baseSelf, Object... args) {
				Random self = (Random) baseSelf;
				int length = (int) ((Number) args[0]).value;
				String alphabet = args[1].asString();
				
				return new funk.lang.types.String(self.randomString(length, alphabet));
			}
		}, Number.class, Object.class));
	}

	@Override
	public String getName() {
		return "Random";
	}

}
