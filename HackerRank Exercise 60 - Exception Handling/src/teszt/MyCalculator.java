package teszt;

public class MyCalculator {

	public String power(int n, int p) {
	String pow ;
		
		if( n == 0 && p == 0)
			pow= "java.lang.Exception: n and p should not be zero.";
		else if(n < 0|| p < 0)
			pow="java.lang.Exception: n or p should not be negative.";
		else
			pow = String.valueOf((int)Math.pow(n, p));
		
		return pow;
	}

}
