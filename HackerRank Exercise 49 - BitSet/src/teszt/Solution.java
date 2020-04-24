package teszt;

import java.util.BitSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		int bitSetLength;
		int operations;
		int i = 0;

		Scanner scan = new Scanner(System.in);

		bitSetLength = scan.nextInt();

		operations = scan.nextInt();

		BitSet b1 = new BitSet(bitSetLength);
		BitSet b2 = new BitSet(bitSetLength);
		

		while (i < operations) {
			String op = scan.next();
			int szam1 = scan.nextInt();
			int szam2 = scan.nextInt();
			int count =0;
					
			if (op.equals("AND") && szam1 == 1) {
				b1.and(b2);
			}
			
			if (op.equals("AND") && szam1 == 2) {
				b2.and(b1);
			}
			if (op.equals("SET") && szam1 == 1) {
				b1.set(szam2, true);
			}
			if (op.equals("SET") && szam1 == 2) {
				b2.set(szam2, true);
			}

			if (op.equals("FLIP") && szam1 == 1 && b1.get(szam2) == false && count==0) {
				b1.set(szam2, true);count++;
			}
			
			if (op.equals("FLIP") && szam1 == 1 && b1.get(szam2) == true&& count==0) {
				b1.set(szam2, false);count++;
			}
			
			if (op.equals("FLIP") && szam1 == 2 && b2.get(szam2) == false&& count==0) {
				b2.set(szam2, true); count++;
			}
			
			if (op.equals("FLIP") && szam1 == 2 && b2.get(szam2) == true&& count==0) {
				b2.set(szam2, false);count++;
			}
			
			if(op.equals("OR") && szam1 ==2)
				b2.or(b1);
			
			if(op.equals("OR") && szam1 ==1)
				b1.or(b2);
			
			if(op.equals("XOR") && szam1 ==2)
				b2.xor(b1);
			
			if(op.equals("XOR") && szam1 ==1)
				b1.xor(b2);
			
			System.out.print(b1.cardinality());System.out.print(" ");System.out.print(b2.cardinality());System.out.println();
			i++;
		}

	}

}
