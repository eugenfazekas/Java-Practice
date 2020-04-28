package test;

import java.math.BigDecimal;
import java.math.MathContext;

public class Main {

	public static void main(String[] args) {
	
		BigDecimal a = new BigDecimal("-123.456"); //-123.456
		
		BigDecimal b = new BigDecimal("123.");     //123
		
		BigDecimal c = new BigDecimal(".123");     //0.123
		
		BigDecimal d = new BigDecimal("1.23");     //1.2299999999999822
		
		BigDecimal e = new BigDecimal(".0");       // 0.0
		
		BigDecimal f = new BigDecimal("0.");       // 0       ////  0.5 != 0.50 ,  0.0 != 0;
	
		System.out.println(""+a+" ;"+b+" ;"+c+"; "+d+"; "+e+" ;"+f);
		
		BigDecimal g = new BigDecimal("1.23");   BigDecimal h = new BigDecimal("1.230");       
	
		System.out.println(g.equals(h)); 
		
		System.out.println(g.compareTo(h));
		
		BigDecimal i = new BigDecimal("1.25");   BigDecimal j = new BigDecimal("0.25");    
		
		MathContext mc = new MathContext(3);
		
		BigDecimal k = i.multiply(j, mc);     System.out.println("Lebego pontos szamolas: "+k);
		
		k = i.multiply(j); System.out.println("Pontos ertek: "+k);
		
		k = k.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		System.out.println("Skalazo faktor bealitasa utan: "+k);

	}

}
