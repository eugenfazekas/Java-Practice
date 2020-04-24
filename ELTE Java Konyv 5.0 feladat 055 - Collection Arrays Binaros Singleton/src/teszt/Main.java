package teszt;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

	
	public static void main(String[] args) {
		
	// Tipus helyeseg ellenorzes
		Set<String> stringHalmaz = Collections.checkedSet(new HashSet<String>(),String.class);
		
		
		//BinarySearch
		List<String> lista = new LinkedList();
		lista.add("Anna");
		lista.add("Adel");
		lista.add("Tunde");
		lista.add("Viky");
		int i1 = Collections.binarySearch("Anna");
		
		String [] konyvek = new String [4];
		konyvek[0] = "Anna";
		konyvek[1] = "Adel";
		konyvek[2] = "Maria";
		konyvek[3] = "Adrien";
		
		List<String> konylista = Arrays.asList(konyvek);
	}
}