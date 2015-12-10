package funk.lib.Random;

import funk.Interpreter;
import funk.Utils;
import funk.lang.IFunction;
import funk.lang.ILibrary;
import funk.lang.Object;
import funk.lang.types.Number;
import funk.lang.types.Error;

public class Library implements ILibrary {

	@Override
	public void inject(Interpreter funk) {
		funk.registerType("Random", new Random());
		
		//-------------------------------------------------------------------------------------
		//seed(val)
		funk.registerFunction("seed", new IFunction() {
			private Object type = new Random();
			
			@Override
			public Object expectedSelfType() {
				return type;
			}
			
			@Override
			public int expectedArgumentCount() {
				return 1;
			}
			
			@Override
			public Object call(Interpreter funk, Object self, Object... args) {
				Object seedObj = funk.cast(args[0], Number.class);
				if(seedObj instanceof Error)
					return seedObj;
				
				((Random) self).seed(((Number)seedObj).value);
				return self; 
			}
		});
		
		//-------------------------------------------------------------------------------------
		//randomNumber()
		funk.registerFunction("number", new IFunction() {
			private Object type = new Random();
			
			@Override
			public Object expectedSelfType() {
				return type; 
			}
			
			@Override
			public int expectedArgumentCount() {
				return 0;
			}
			
			@Override
			public Object call(Interpreter funk, Object self, Object... args) {
				return new Number((int) ((Random)self).randomNumber());
			}
		});
		
		//-------------------------------------------------------------------------------------
		//randomNumber(min, max)
		funk.registerFunction("number", new IFunction() {
			private Object type = new Random();
			
			@Override
			public Object expectedSelfType() {
				return type;
			}
			
			@Override
			public int expectedArgumentCount() {
				return 2;
			}
			
			@Override
			public Object call(Interpreter funk, Object self, Object... args) {
				Number minObj = (Number) funk.cast(args[0], Number.class);
				Number maxObj = (Number) funk.cast(args[1], Number.class);
				
				return new Number((int) ((Random)self).randomNumber(minObj.value, maxObj.value));
			}
		});
		
		//-------------------------------------------------------------------------------------
		//randomBoolean()
		funk.registerFunction("boolean", new IFunction() {
			private Object type = new Random();
			
			@Override
			public Object expectedSelfType() {
				return type;
			}
			
			@Override
			public int expectedArgumentCount() {
				return 0;
			}
			
			@Override
			public Object call(Interpreter funk, Object self, Object... args) {
				return new funk.lang.types.Boolean(((Random)self).randomBoolean());
			}
		});
		
		//-------------------------------------------------------------------------------------
		//randomString(length)
		funk.registerFunction("string", new IFunction() {
			private Object type = new Random();
			
			@Override
			public Object expectedSelfType() {
				return type;
			}
			
			@Override
			public int expectedArgumentCount() {
				return 1;
			}
			
			@Override
			public Object call(Interpreter funk, Object self, Object... args) {
				Object lengthObj = funk.cast(args[0], Number.class);
				if(lengthObj instanceof funk.lang.types.Error)
					return lengthObj; 
				
				int length = (int) ((Number)lengthObj).value;
				
				return new funk.lang.types.String(((Random)self).randomString(length));
			}
		});
		
		//-------------------------------------------------------------------------------------
		//randomString(length, min, max)
		funk.registerFunction("string", new IFunction() {
			private Object type = new Random();
			
			@Override
			public Object expectedSelfType() {
				return type;
			}
			
			@Override
			public int expectedArgumentCount() {
				return 3;
			}
			
			@Override
			public Object call(Interpreter funk, Object self, Object... args) {
				Object lengthObj = funk.cast(args[0], Number.class);
				Object minObj = funk.cast(args[1], Number.class);
				Object maxObj = funk.cast(args[2], Number.class);
				
				Error e = Utils.gatherErrors(lengthObj, minObj, maxObj);
				if(e != null)
					return e; 
				
				int length = (int) ((Number)lengthObj).value;
				int min = (int) ((Number)minObj).value; 
				int max = (int) ((Number)maxObj).value;
				
				return new funk.lang.types.String(((Random)self).randomString(length, min, max));
			}
		});
		
		//-------------------------------------------------------------------------------------
		//randomString(length, alphabet)
		funk.registerFunction("string", new IFunction() {
			private Object type = new Random();
			
			@Override
			public Object expectedSelfType() {
				return type;
			}
			
			@Override
			public int expectedArgumentCount() {
				return 2;
			}
			
			@Override
			public Object call(Interpreter funk, Object self, Object... args) {
				Object lengthObj = funk.cast(args[0], Number.class);
				
				if(lengthObj instanceof Error)
					return lengthObj; 
				
				String alphabet = args[1].asString();
				int length = (int) ((Number)lengthObj).value;
				
				return new funk.lang.types.String(((Random)self).randomString(length, alphabet));
			}
		});
	}

	@Override
	public String getName() {
		return "Random";
	}

}
