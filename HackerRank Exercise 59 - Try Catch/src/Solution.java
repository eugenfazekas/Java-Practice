import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long one;
		long two;
		
		try {
			one = scan.nextInt();
			two = scan.nextInt();
			System.out.println(one/two);
		}catch(InputMismatchException e) {
			System.out.println("java.util.InputMismatchException");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}
	}


