package funk;

public class Main {
	public static void main(String... args) throws IllegalCastException {
		Object number = new Object(5);
		Object string = new Object("2");
		
		Object add1 = number.add(string);
		Object add2 = string.add(number);
		
		System.out.println(add1.asString());
		System.out.println(add2.asString());
	}
}
