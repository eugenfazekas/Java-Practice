package teszt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;



	public class Solution {

		public static void main(String[] args) throws IOException {
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			 int [] szamolas = new int [10000];
			  
		
						Scanner scan = new Scanner (System.in);	
			
		            	for(int i = 1 ; i < 10000; i++) {
		            	
		            		String st1 = br.readLine();
		            		
		            		String st = st1;
		            		
		            		szamolas[i] = i;
		            	 
		            		if(st != null)
							System.out.println(szamolas[i] + " "+ st );
							
							
		            	}
		            	}
		                  
		       
		            }     