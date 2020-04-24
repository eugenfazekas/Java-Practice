package teszt;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		ArrayList<String> dataArray = new ArrayList<String>();
		
		int i =0; int j = 0; int dataArrayIndex = 0;
		
		Scanner scan = new Scanner(System.in);                        // System.out.println("Hany adatsor?");
		
		int dataInputLines = scan.nextInt();
		
		while(i < dataInputLines+1) {
			
			dataArray.add(scan.nextLine());
			
			i++;
		}                                                             // System.out.println("Hany teszt?");
		
		int testInputLines = scan.nextInt();
		
		while(j < testInputLines+1) {
		
			String inputCheck = scan.nextLine();
			
			if(j>0) {
								
			String [] inputCheckArray = inputCheck.split(" ");  
			
			dataArrayIndex = Integer.valueOf(inputCheckArray[0]);
			
			String stringForCheck = dataArray.get(dataArrayIndex);
			
			String[] stringArrayForCheck = stringForCheck.split(" ");
			
			try {
				System.out.println(stringArrayForCheck[Integer.valueOf(inputCheckArray[1])]);
			}catch(Exception e){
				System.out.println("ERROR");
			}

	
			}
			j++;
		}

	}
}	
		
	




