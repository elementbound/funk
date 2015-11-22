package funk;

public class UnknownVariableException extends Exception {
	public UnknownVariableException(String name) {
		super("Uknown variable: " + name);
	}
}
