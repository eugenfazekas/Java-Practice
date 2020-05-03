package connection;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstConnection {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int hozzaadas; 
		String nev, cim;

		DB db = new DB();
		
		System.out.println("Hany Usert szeretne hozzaadni?");
		
		hozzaadas = scan.nextInt();
		while(hozzaadas-- >0) {
			nev = scan.next();
			cim = scan.next();
			db.addUserSimpleStatement(nev, cim);
		}
		scan.close();
		
		System.out.println("These are users table columns");
		db.showUsersMeta();System.out.println();
		
		System.out.println("Here are usesrs from database:");
		db.showAllUsers();System.out.println();
		
		System.out.println("This is the ArrayList with users:");
		ArrayList<User> users = db.getAllUsers();
			for(User u : users)
				System.out.println(u.getName() + " " + u.getAddress() );
	}

}
