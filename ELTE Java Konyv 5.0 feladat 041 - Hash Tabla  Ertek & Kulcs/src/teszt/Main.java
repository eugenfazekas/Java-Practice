package teszt;

import java.util.Hashtable;

public class Main {

	public static void main(String[] args) {
		
		Hashtable<String, Integer> szamok = new Hashtable<String, Integer>();
		szamok.put("harom", new Integer(3));
		szamok.put("negy", new Integer(4));
		szamok.put("ot", new Integer(5));
		
		Integer n = (Integer) szamok.get("negy");
		if(n != null) System.out.println("Negy = "+n);

	}

}
