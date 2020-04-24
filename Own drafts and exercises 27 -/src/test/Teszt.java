package test;

import java.util.Arrays;
import java.util.Scanner;

public class Teszt {

	public static void main(String[] args) {

	    Scanner scan = new Scanner(System.in);
	    
	    int t=scan.nextInt();
        for(int i=0;i<t;i++){
            
	    int a = scan.nextInt();
	    int b = scan.nextInt();
	    int n = scan.nextInt();
	   
	    sum(a,b,n);
	  	  
        }
	    scan.close();
		
	}
		public static void sum(int inputA , int inputB, int inputN ) {
			
			int a = inputA;
			int b = inputB;
			int n = inputN ;
			
			int[] dupla = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384};
			
			int[] tomb2 = new int[n+1] ;
			int[] tomb3 = new int[1000];
			
			for (int i = 1; i <dupla.length;i++) {
		 			
		 		//System.out.println(dupla[i]);
				}
			int[] tomb1 = Arrays.copyOfRange(dupla, 0, n);
			
			for(int j = 0 ; j < tomb1.length ; j++) {
				tomb1[j] = dupla[j] *b ;
			// System.out.println("tomb1:"+ tomb1[j]);
				
			//tomb2 = Arrays.copyOfRange(tomb1, 0, n);
			
			for(int k = 0; k< tomb2.length; k++) 
			
			tomb2[k] = tomb1[j] + tomb2[k] ;	
			
			//System.out.println(tomb2[j]);
			
			tomb3 = Arrays.copyOfRange(tomb2, 0, n);
			
			for(int l = 0; l< tomb3.length; l++) 
				tomb3[l] = a + tomb2[l] ;
				System.out.print(" "+tomb3[j]);
				
			}
			System.out.println("");
			}
	
}
		



			
				
		
			
			
		
		

