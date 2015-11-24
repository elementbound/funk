package funk;

public class FPrint implements ICallable{
	
	@Override
	public Object call(Object self, Object... args) {
		System.out.println(self);
		
		return self;
	}
}
