package teszt;

import java.util.Scanner;

public class Teszt {

	public static void main(String[] args) {
	
		byte a = Byte.MIN_VALUE;
		byte b = Byte.MAX_VALUE;
		
		short c = Short.MIN_VALUE;
		short d = Short.MAX_VALUE;
		
		int e = Integer.MIN_VALUE;
		int f = Integer.MAX_VALUE;
		
		long g = Long.MIN_VALUE;
		long h = Long.MAX_VALUE;

		 Scanner scan = new Scanner(System.in);
	        int t=scan.nextInt();
	        for(int i=0;i<t;i++)
	        {
	        	
	            try
	            { 
	                long x=scan.nextLong();
	               
	                System.out.println(x+" can be fitted in:");
	                if(x>= a && x<= b)System.out.println("* byte");
	                if(x>= c && x<= d)System.out.println("* short");
	                if(x>= e && x<= f)System.out.println("* int");
	                if(x>= g && x<= h)System.out.println("* long");
	              
	            }
	            catch(Exception k)
	            {
	                System.out.println(scan.next()+" can't be fitted anywhere.");
	            }

	        }

	}

}
