package teszt;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		

		Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        
        String output =  S.substring(start, end);
        
        System.out.println(output);
	}

}
