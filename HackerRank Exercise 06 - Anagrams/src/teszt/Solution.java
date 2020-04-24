package teszt;

import java.util.Scanner;

public class Solution {
	
	static String inputOneLow;
	static String inputTwoLow;
	
	
	
	//String abc    = "Abc".toLowerCase();
    static boolean isAnagram(String a, String b) {
    
       	boolean returnValue = false;
    	
    	inputOneLow = a.toLowerCase();
    	inputTwoLow = b.toLowerCase();
    	
    	int index1 = 0;
    	int index2 = 0;
    
    	int ascii1 = 0 ;
    	int ascii2 = 0 ;
    	
    	 for(int i = 0; i < inputOneLow.length() ; i++){        
    	     char character1 = inputOneLow.charAt(i); 
    	     ascii1 = ascii1 + (int) character1; 
    	     
    	     
        	 if(inputTwoLow.indexOf(ascii1)< index2)
        	 	 index2 = inputTwoLow.indexOf(character1);
     	     //System.out.println(index2);
    	
       	 }
    	// System.out.println(ascii1);
   
    	 for(int i = 0; i < inputTwoLow.length() ; i++){        
 	        char character2 = inputTwoLow.charAt(i); 
 	         ascii2 = ascii2 + (int) character2; 

 	    	 if(inputOneLow.indexOf(ascii2)< index1)
 	    		 index1 = inputOneLow.indexOf(character2);
 	    	// System.out.println(index1);
    	 }
    	 //System.out.println(ascii2);
    
    	 if(ascii1 == ascii2 & index1 >= 0 && index2 >=0 )
    		 
    		 returnValue = true;
       
    	 return returnValue;
		
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
