package funk.lang;

public interface ICastRule<From, To> {
	public To cast(From from);
}