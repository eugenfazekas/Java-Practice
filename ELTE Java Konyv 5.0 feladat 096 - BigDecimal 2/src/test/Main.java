package test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {

	public static void main(String[] args) {
		
		BigDecimal a = new BigDecimal("2"); BigDecimal b = new BigDecimal("3"); MathContext mc1 = new MathContext(7, RoundingMode.HALF_EVEN);
		
		BigDecimal c = a.divide(b,mc1); System.out.println(c); // 0.6666667
		
		MathContext mc2 = new MathContext(7, RoundingMode.DOWN);
		
		c = a.divide(b,mc2); System.out.println(c); //0.6666666
		
		BigDecimal d = new BigDecimal("10.00");  
		
		print(d.divide(new BigDecimal("5"),BigDecimal.ROUND_UNNECESSARY)); // 2.00
		
		print(d.divide(new BigDecimal("5"),RoundingMode.UNNECESSARY)); // 2.00
		
		//print(d.divide(new BigDecimal("3"),BigDecimal.ROUND_UNNECESSARY)); //   Aritmethic Exception 
		
		// print(d.divide(new BigDecimal("3"),RoundingMode.UNNECESSARY)); // 	Aritmethic Exception 
		
		print(d.divide(new BigDecimal("3"),10,BigDecimal.ROUND_DOWN)); // 3.3333333333
		
		print(d.divide(new BigDecimal("3"),10,RoundingMode.DOWN)); // 3.333333333
		
		print(d.divide(new BigDecimal("3"),10,BigDecimal.ROUND_CEILING)); // 3.33333333334
		
		print(d.divide(new BigDecimal("3"),10,RoundingMode.CEILING)); // 3.3333333334

	}

	static void print (BigDecimal b) {
		System.out.println(b);
		}
}
