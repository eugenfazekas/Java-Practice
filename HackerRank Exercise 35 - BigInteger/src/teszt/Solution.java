package teszt;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		String st1 = scan.nextLine();
		
		String st2 = scan.nextLine();
		
		BigInteger big1 = new BigInteger(st1);
		
		BigInteger big2= new BigInteger(st2);

		System.out.println(big1.add(big2));
		
		System.out.println(big1.multiply(big2));

	}

}
