package funk.lib.Random;

import funk.lang.types.Generic;

public class Random extends Generic {
	private java.util.Random rng = new java.util.Random();
	
	public void seed(long s) {
		rng.setSeed(s);
	}
	
	//
	
	public double randomNumber() {
		return rng.nextDouble();
	}
	
	public double randomNumber(double min, double max) { 
		double val = rng.nextDouble();
		return (1.0-val)*min + val*max;
	}
	
	//
	
	public boolean randomBoolean() {
		return rng.nextBoolean();
	}
	
	//
	
	public char randomChar() {
		return (char)rng.nextInt();
	}
	
	public char randomChar(int min, int max) {
		return (char)(min + rng.nextInt(max-min));
	}
	
	public char randomChar(String alphabet) {
		return alphabet.charAt(rng.nextInt(alphabet.length()));
	}
	
	//
	
	public String randomString(int length) {
		StringBuilder strb = new StringBuilder();
		for(int i = 0; i < length; i++)
			strb.append(this.randomChar());
		return strb.toString();
	}
	
	public String randomString(int length, int min, int max) {
		StringBuilder strb = new StringBuilder();
		for(int i = 0; i < length; i++)
			strb.append(this.randomChar(min, max));
		return strb.toString();
	}
	
	public String randomString(int length, String alphabet) {
		StringBuilder strb = new StringBuilder();
		for(int i = 0; i < length; i++)
			strb.append(this.randomChar(alphabet));
		return strb.toString();
	}
	
	//

	@Override
	public java.lang.String asString() {
		return "Random";
	}
}
