package funk.lang;

import funk.Interpreter;

public interface ILibrary {
	public void inject(Interpreter funk);
	public String getName(); 
}
