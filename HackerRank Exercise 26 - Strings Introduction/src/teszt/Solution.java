package teszt;
import java.io.*;
import java.util.*;
public class Solution {
	

	

	    public static void main(String[] args) {
	        
	        Scanner sc=new Scanner(System.in);
	        String A=sc.next();
	        String B=sc.next();
	        /* Enter your code here. Print output to STDOUT. */
	       
	        String a = A.substring(0, 1).toUpperCase() +A.substring(1,A.length());
	        String b = B.substring(0, 1).toUpperCase() +B.substring(1,B.length());
	        
	        int sum = A.length()+B.length();
	        int compare = A.compareTo(B);
	       
	        System.out.println(sum);
	        if(compare > 0)
	        System.out.println("Yes");	
	        else {
	        	System.out.println("No");
	        	
	      
	        }	
	        System.out.println(a+ " " +b);	
	   
	 }
}
