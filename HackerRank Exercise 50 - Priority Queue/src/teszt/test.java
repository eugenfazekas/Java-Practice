package teszt;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	String st = scan.nextLine();
	String[] sta = st.split(" ");
	
	for(String s : sta)
		System.out.println("A "+ s);

	}

}
