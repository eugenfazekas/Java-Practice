package v35;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Number szam1 = new Integer(5);
		Number szam2 = new Double(7.5);
		
		List<Number> szamok = new LinkedList<>();
		
		szamok.add(szam1);
		szamok.add(szam2);
		szamok.add(new BigDecimal("345345345"));
		
		for(int i = 0; i < szamok.size(); i++) {
			Number aktulalisSzam = szamok.get(i);
			System.out.printf("[%s]%s\n",aktulalisSzam.getClass().getSimpleName(),aktulalisSzam);
		}
		
		kiirat(szamok);
		
		ArrayList<String> nevek =new ArrayList<>();
		nevek.add("Lajos");
		nevek.add("Gizella");
		List<String>nevek2 = nevek;
		Collection<String> nevek3=nevek2;
		Collection<String> nevek4=nevek2;
		
		nevListazo(nevek);
		
	}
		public static void kiirat(List<Number> szamok) {
			System.out.println("Kiirat List<Number> metodus");
				for(int i = 0; i < szamok.size(); i++) {
					Number aktulalisSzam = szamok.get(i);
					System.out.printf("[%s]%s\n",aktulalisSzam.getClass().getSimpleName(),aktulalisSzam);
				}
		}
		
		public static void nevListazo(Collection<String> nevek) {
			System.out.println("Nevek Listaja:");
			Iterator<String> it= nevek.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}
}
