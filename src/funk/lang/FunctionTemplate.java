package funk.lang;

import java.util.ArrayList;
import java.util.List;

import funk.Interpreter;
import funk.lang.types.Error;

public class FunctionTemplate implements IFunction {
	private Object typeInstance = null;
	private List<Class<? extends Object>> argTypes = new ArrayList<>();
	private IFunclet implementation = null;
	
	public FunctionTemplate(Object selfType, IFunclet implementation, Class<? extends Object>... argTypes) {
		this.typeInstance = selfType;
		
		for(Class<? extends Object> c : argTypes)
			this.argTypes.add(c);
		
		this.implementation = implementation;
	}

	@Override
	public Object call(Interpreter funk, Object self, Object... args) {
		List<Object> castArgs = new ArrayList<>();
		for(int i = 0; i < args.length; i++) {
			Object arg = args[i];
			Class<? extends Object> type = this.argTypes.get(i);
			
			if(type.equals(Object.class)) 
				castArgs.add(arg);
			else {
				Object castArg = funk.cast(arg, type);
				if(castArg instanceof Error)
					return castArg;
				
				castArgs.add(castArg);
			}
		}
		
		return implementation.call(funk, self, (Object[]) castArgs.toArray(new Object[castArgs.size()]));
	}

	@Override
	public int expectedArgumentCount() {
		return argTypes.size();
	}

	@Override
	public Object expectedSelfType() {
		return typeInstance;
	}

}
