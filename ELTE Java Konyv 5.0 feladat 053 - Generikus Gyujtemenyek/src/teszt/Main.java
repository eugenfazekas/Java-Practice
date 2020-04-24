package teszt;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {
		
		List<String> lista = new LinkedList<String>();
		
		lista.add("Anna");
		
		lista.add("Adrien");

		lista.add("Timea");
		
		Iterator<String> it = lista.iterator();
		
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
	}
}