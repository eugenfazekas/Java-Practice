package teszt;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		
		Scanner scan =  new Scanner(System.in);
		
		int tombhossz = scan.nextInt();
		
		int[] tomb = new int[tombhossz];
		
		int i = 0;
	
		int l = 0;
		
		while (i < tombhossz) {

				tomb[i] = scan.nextInt();

			i++;
		}

		for(int m : tomb)
			System.out.println(m);

	}

}
