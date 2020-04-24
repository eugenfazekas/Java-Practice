package teszt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		 int [] szamolas = new int [100];
		  
		 for(int i = 1 ; i < szamolas.length ; i++) {
		
			 szamolas[i] = i;
			 	Scanner scan1 = new Scanner (System.in);	
		     //Create Scanner object  
	            Scanner scan = new Scanner(scan1.next());  
	            //Declare the delimiter  
	            scan.useDelimiter(";");  
	            /*Initialize the String pattern which signifies that the String 
	            token contains characters of the alphabet only*/  
	             
	            while(scan.hasNext()){  
	                //Check if the token consists of declared pattern  
	                if(scan.hasNext()){  
	                    System.out.println(szamolas[i] +" "+ scan.next());  
	                }  
	                else  
	                    scan.next();  
	                }  
	                scan.close();  
	        }    
	}
}