package teszt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	


public static void main(String[] args) throws IOException {
	  
	String[] array1 = null;
    char karakter = 0;
    char karakter1 = 0;
    char karakter2 = 0;
    int ascii = 0;
    int ascii1 = 0;
    int ascii2 = 0;
    int tomb = 0;
    int nula = 0;
    
          Scanner scan = new Scanner(System.in);
    
          BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
          
          String input = br.readLine();
              
          String str = input;
          
          String str1 = input;
          
          String str2= input;
          
         
    
          
          for(int i = 0 ; i < str2.length();i++) {
        	  karakter2 = str2.charAt(i);
        	  ascii2 = (int) karakter2;
          	  tomb = tomb + ascii2;
             }  
          if(tomb % 32 == 0) {
                  System.out.println(nula);
                  return;
                    }	  
      
          if(str.contains("?")) {
              str = str.replace("?", " ");
          }
          if(str.contains(",")) {
              str = str.replace("," , " ");
          }
          if(str.contains("'")) {
              str = str.replace("'", " ");
          }
          if(str.contains("!")) {
              str = str.replaceAll("!", " ");
          }
          if(str.contains(".")) {
              str = str.replace(".", " ");
          }
          if(str.contains("_")) {
              str = str.replace("_", " ");
          }
          if(str.contains("@")) {
              str = str.replace("@", " ");
          }
          
          if(str.contains(" ")) {
              str = str.replaceAll("\\s+", " ");
          }
          
          for(int i = 0; i< str.length(); i++)
              karakter = str.charAt(0);
              ascii = (int) karakter;
          
          for(int i = 0; i< str1.length(); i++) 
              karakter1 = str1.charAt(0);
              ascii1 = (int) karakter1;
          
          if(ascii == 32 &&  ascii1 != 44) 
          str = str.trim();
                 
            array1 = str.split("\\s");
            
            if(str.length() > 0)
         System.out.println(array1.length);
            
      for(int i = 0 ; i < array1.length ; i++) 
          
          if(str.length() > 0)
          System.out.println(array1[i]);
      
      br.close();
      scan.close();
  	}
}	                        
		           
		      
  	

