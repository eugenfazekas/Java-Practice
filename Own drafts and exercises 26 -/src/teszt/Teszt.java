package teszt;

import java.util.Scanner;

public class Teszt {

	public static void main(String[] args) {
		
		int[] szam2 = new int[11];
		
	    Scanner scan = new Scanner(System.in);
	    int szam = scan.nextInt();
	    scan.close();
	    
	    for(int j  = 1 ; j<szam2.length; j++) {
	    	szam2[j] =j;
	    }
	  	
	    for(int i = 1 ; i < 11 ; i++) {
	    	
	    	i = szam2[i];
	    	
	    	System.out.println(szam + " x "+ szam2[i] + " = " +szam*szam2[i] );
	    }
	    
	}

}
