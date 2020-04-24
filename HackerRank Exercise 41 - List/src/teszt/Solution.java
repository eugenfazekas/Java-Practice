package teszt;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
	
	ArrayList<Integer> tomb = new ArrayList<Integer>();	int i = 0; int queries; int element = 0;
	
	String query; String Insert_Delete;

	Scanner scan = new Scanner(System.in); System.out.println("Hany elemet fog tartalmazni a tomb?");

	int tombmeret = scan.nextInt(); System.out.println("Kerem oket");
	
	while(i< tombmeret) {
		tomb.add(scan.nextInt());
		
		i++;
	}
	
		i=0;
		
		System.out.println("Hany feladat lesz?");
		queries = scan.nextInt();
		
		while (i < queries) {
			
			    query = scan.next();
				int index  = scan.nextInt();
				
				if(query.equals("Insert"))
				 element = scan.nextInt();
			    
				if(query.equals("Insert")) 
					tomb.add(index, element);
				if(query.equals("Delete"))
					tomb.remove(index);

			i++;
		}
		
		for(int s : tomb)
			System.out.print(s +" " );
	
}
}
