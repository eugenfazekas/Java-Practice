package test;


import java.math.BigInteger;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		
		BigInteger a = new BigInteger(1,  new byte[]{(byte)128});   System.out.println(a);
		BigInteger b = new BigInteger(-1, new byte[]{(byte)128});
		BigInteger c = new BigInteger(0,  new byte[]{(byte)0}); 
		
		BigInteger d = new BigInteger(1, new Random()); 		System.out.println(d);
		BigInteger e = new BigInteger(8, new Random());			System.out.println(e); 

		BigInteger f = new BigInteger(32,1000, new Random());	System.out.println(f);
		
		BigInteger g = new BigInteger("74681464618416461464646464578678986967067056906578458878666413467457858578678987968976");
		
		BigInteger i = new BigInteger("74681464618416461464646464578678986967067056906578458878666413467457858578678987968972");
		
		BigInteger h = g.add(i); System.out.println(h);
		
		boolean aa = g.compareTo(i) > 0;
		
		System.out.println(aa);
	}

}
