package teszt;

import java.util.Scanner;

public class Solution {

	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String s = scan.next();
	       System.out.println(isPalindrome(s));
	    }
	    
	    public static String isPalindrome(String str) {
	    	
	    	String true2 =null;
	    	
	        boolean true1 = str.equals(new StringBuilder(str).reverse().toString());
	        if(true1 == true) 
	         true2 = "Yes";
	        else 
	        	true2 = "No";
	        return true2;
	    
	        }
		
	    }
	