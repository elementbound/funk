package funk.lang;

import funk.Interpreter;

public interface IFunction {
	public Object call(Interpreter funk, Object self, Object... args);
	public int expectedArgumentCount();
	public Object expectedSelfType(); 
}
