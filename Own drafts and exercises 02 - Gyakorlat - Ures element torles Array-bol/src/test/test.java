package test;

import java.util.Arrays;
import java.util.Scanner;

public class test {

  
	public static void main(String[] args) throws Exception  {
      
    	Scanner scan = new Scanner(System.in);
    	
    	
		
    	String s = scan.nextLine();
    	
    	scan.close();
    	
    	String[] st = s.split("[()]");
    	
    	
    	st= Arrays.stream(st)
                .filter(new_string -> (new_string != null && new_string.length() > 0))
                .toArray(String[]::new);
    	
    	for (int i =0; i < st.length; i++)
    		System.out.println(i +st[i]);
    	}
    	
    }

