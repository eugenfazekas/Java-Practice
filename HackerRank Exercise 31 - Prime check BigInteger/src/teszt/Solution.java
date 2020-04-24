package teszt;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
	


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       String  n = scanner.nextLine();

        scanner.close();
        prim(n);
    }
    
   
    
static void prim (String decimal) {
	
	String pattern = "###.00";
	
	DecimalFormat df = new DecimalFormat(pattern);
	
	Double x = Double.valueOf(decimal+".0");
	
	Double temp;
	
	boolean isPrime=true;
	
	for(int i=2 ; i<= x/ 2 ;i++)
	{
           temp=x % i;
           
	   if( temp==0 )
	   {
	      isPrime=false;
	      break;
	   }
	}
	//If isPrime is true then the number is prime else not
	if(isPrime)
	   System.out.println("prime ");
	else
	   System.out.println("not prime ");
	 return;
	}

}
