package funk.lib.lang;

import funk.Interpreter;
import funk.lang.FunctionTemplate;
import funk.lang.IFunclet;
import funk.lang.ILibrary;
import funk.lang.Object;
import funk.lang.types.Boolean;
import funk.lang.types.Collection;
import funk.lang.types.Number;

public class CollectionLibrary implements ILibrary {

	@Override
	public void inject(Interpreter funk) {
		//keys()
		funk.registerFunction("keys", new FunctionTemplate(new Collection(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection self = (Collection) baseSelf;
				
				return Collection.fromValues(self.keys());
			}
		}));
		
		//values()
		funk.registerFunction("values", new FunctionTemplate(new Collection(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection self = (Collection) baseSelf;
				
				return Collection.fromValues(self.values());
			}
		}));
		
		//size()
		funk.registerFunction("size", new FunctionTemplate(new Collection(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection self = (Collection) baseSelf;
				
				return new Number(self.size());
			}
		}));
		
		//has(key)
		funk.registerFunction("has", new FunctionTemplate(new Collection(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection self = (Collection) baseSelf;
				
				return new Boolean(self.has(args[0]));
			}
		}, Object.class));
		
		//hasValue(value) 
		funk.registerFunction("hasValue", new FunctionTemplate(new Collection(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection self = (Collection) baseSelf;
				
				return new Boolean(self.hasValue(args[0]));
			}
		}, Object.class));
		
		//rewind()
		funk.registerFunction("rewind", new FunctionTemplate(new Collection(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection self = (Collection) baseSelf;
				
				self.rewind();
				return self;
			}
		}));
		
		//next()
		funk.registerFunction("next", new FunctionTemplate(new Collection(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection self = (Collection) baseSelf;
				
				self.next();
				return self;
			}
		}));
		
		//pastEnd()
		funk.registerFunction("pastEnd", new FunctionTemplate(new Collection(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection self = (Collection) baseSelf;
				
				return new Boolean(self.pastEnd());
			}
		}));
		
		//key()
		funk.registerFunction("key", new FunctionTemplate(new Collection(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection self = (Collection) baseSelf;
				
				return self.key();
			}
		}));
		
		//value()
		funk.registerFunction("value", new FunctionTemplate(new Collection(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection self = (Collection) baseSelf;
				
				return self.value();
			}
		}));
		
		//isArray()
		funk.registerFunction("isArray", new FunctionTemplate(new Collection(), new IFunclet() {
			
			@Override
			public Object call(Interpreter funk, Object baseSelf, Object... args) {
				Collection self = (Collection) baseSelf;
				
				return new Boolean(self.isArray());
			}
		}));
	}

	@Override
	public String getName() {
		return "Collection";
	}

}
