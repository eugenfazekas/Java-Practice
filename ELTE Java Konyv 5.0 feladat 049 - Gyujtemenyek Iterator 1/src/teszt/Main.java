package teszt;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		java.util.Collection<String> c = new java.util.ArrayList<String>();

		for(int i = 0; i < 10; i++) 
			c.add(Integer.toString(i));
		String s = null;
		Iterator<String> it = c.iterator();
		System.out.print("Minden Szam: \n");
		while(it.hasNext()) {
			s=it.next();
			System.out.print(s+ ", ");
						if(Integer.valueOf(s).intValue() > 4)it.remove();
		}
		System.out.println();
		Iterator<String> it2 = c.iterator();
		System.out.println("5 nel kisebb szamok: ");
		while(it2.hasNext()) {
			s = (String) it2.next();
			System.out.print(s+", ");
		}
		
	}

}
