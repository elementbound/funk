package funk.lang;

import funk.Interpreter;

public interface IFunclet {
	public Object call(Interpreter funk, Object baseSelf, Object... args);
}
