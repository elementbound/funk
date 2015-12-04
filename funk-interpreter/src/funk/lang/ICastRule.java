package funk.lang;

public interface ICastRule<From, To> {
	public To cast(Object from);
	
	public Class<?> from();
	public Class<?> to(); 
}