package funk.lang.func;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import funk.Interpreter;
import funk.lang.IFunction;
import funk.lang.Object;

public class UserFunc implements IFunction {
	private List<String> argNames = new ArrayList<>();
	private Class<? extends Object> acceptedType = Object.class;
	private ParseTree userCode = null;
	
	public UserFunc(Class<? extends Object> selfType, List<String> argNames, ParseTree code) {
		this.argNames.addAll(argNames);
		this.acceptedType = selfType;
		this.userCode = code; 
	}
	
	@Override
	public Object call(Interpreter funk, Object self, Object... args) {
		funk.enterScope(); 
		for(int i = 0; i < argNames.size(); i++) 
			funk.setLocalVariable(argNames.get(i), args[i]);
		funk.setLocalVariable("self", self);
		
		funk.visit(userCode);
		Object result = funk.getVariable("self");
		
		funk.exitScope();
		return result; 
	}

	@Override
	public int expectedArgumentCount() {
		return argNames.size();
	}

	@Override
	public Class<? extends Object> expectedSelfType() {
		return acceptedType;
	}

}
