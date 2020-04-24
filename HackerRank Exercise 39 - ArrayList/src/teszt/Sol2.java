package teszt;

import java.util.Scanner;

public class Sol2 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		String st = scan.nextLine();
		
		String[] sts =  st.split(" ");
		
		for (String s:sts)
			System.out.println(s);

	}

}
