package test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

	public static void main(String[] args) {
		
	BigDecimal a = new BigDecimal("1.24"); // 1.240
	
	System.out.println(a.setScale(3));
	
	BigDecimal b = new BigDecimal("1.00");
	
	b = b.movePointLeft(5); 
	
	System.out.println(b);
	
	b = b.movePointRight(5);
	
	System.out.println(b.movePointRight(5));
	
	}

}
