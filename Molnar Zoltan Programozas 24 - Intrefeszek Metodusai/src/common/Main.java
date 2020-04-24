package common;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
	
		User geza = new User("Geza", 43);
		User amalia = new User("Amalia", 28);
		User jozsi = new User("Jozsi", 33);
		User kati = new User("Kati", 37);
		
		User[] felhasznalok = {geza,amalia,kati,jozsi};
		
		System.out.println(Arrays.toString(felhasznalok));
		
		Arrays.sort(felhasznalok);
		
		System.out.println(Arrays.toString(felhasznalok));
		
		Arrays.sort(felhasznalok,new AgeComparator());
		
		System.out.println(Arrays.toString(felhasznalok));
		

	}

}
