package teszt;

import java.util.HashSet;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {

		HashSet<String> tomb = new HashSet<String>();
		
		Scanner scan = new Scanner(System.in);
		
		int records = scan.nextInt(); int i=0;
		
		while(i<records) {
			if(i ==0)
			scan.nextLine();
			String s = scan.nextLine();
			tomb.add(s);
			System.out.println(tomb.size());
			i++;
		}
	
		

	}

}
