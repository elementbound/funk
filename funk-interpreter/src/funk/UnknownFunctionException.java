package funk;

public class UnknownFunctionException extends Exception {
	public UnknownFunctionException(String name) {
		super("Unknown function: " + name);
	}
}
