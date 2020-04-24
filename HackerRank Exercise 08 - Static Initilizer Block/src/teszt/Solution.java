package teszt;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	
	static Scanner scan  = new Scanner(System.in);
	
	static String exception = "java.lang.Exception: Breadth and height must be positive";
	
	static int B = scan.nextInt() ;	
	
	static int H = scan.nextInt() ;
	
	static boolean flag = B*H >=0 && B>0 && H>0; 
	
	static {
		if(B<=0 || H<=0) 
			System.out.println(exception);
		}
	

 public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class
