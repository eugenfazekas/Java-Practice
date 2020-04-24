package teszt;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
	   
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        //

        int[] a = new int[n];
		
		int e = 0;
	
		int l = 0;
		
		while (e < n) {

				a[e] = scan.nextInt();

			e++;
		}
      
        
        //
        
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}