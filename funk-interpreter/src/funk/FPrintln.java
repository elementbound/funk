package funk;

public class FPrintln implements ICallable {

	@Override
	public Object call(Object self, Object... args) throws IllegalCastException {
		System.out.println(self.asString());
		return self;
	}

}
