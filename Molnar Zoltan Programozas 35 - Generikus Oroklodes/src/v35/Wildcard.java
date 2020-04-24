package v35;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Wildcard {

	public static void main(String[] args) {
		
		
		
		List<Object> objektumok = new LinkedList<>();
		objektumok.add("Majom");
		objektumok.add(new Object());
		objektumok.add(0);
		
		List<Number> mindenfeleSzamok = new LinkedList<>();
		mindenfeleSzamok.add(56);
		mindenfeleSzamok.add(13.2);
		
		List<Double> lebegopontosSzamok = new LinkedList<>();
		lebegopontosSzamok.add(5.7);
		lebegopontosSzamok.add(13.897);
		lebegopontosSzamok.add(1.0);
		
		kiiratasList(mindenfeleSzamok);
		kiiratasList(lebegopontosSzamok);
		
		kiiratasListwildExtends(mindenfeleSzamok);
		kiiratasListwildExtends(lebegopontosSzamok);
		
		kiiratasListWild(mindenfeleSzamok);
		kiiratasListWild(lebegopontosSzamok);
		
		//feltoltesListWildSuper(lebegopontosSzamok,3);
		feltoltesListWildSuper(mindenfeleSzamok,3);
		}

	public static void kiiratasListNumber(List<Number> szamok) {
		System.out.println("Kiirat List<Number> metodus");
			for(int i = 0; i < szamok.size(); i++) {
				Number aktulalisSzam = szamok.get(i);
				System.out.printf("[%s]%s\n",aktulalisSzam.getClass().getSimpleName(),aktulalisSzam);
			}
	}
	
	public static final Random Veletlen = new Random();
	
	public static <T extends Number>void kiiratasList(List<T> szamok) {
		System.out.println("Kiirat List<Number> metodus");
		for(int i = 0; i < szamok.size(); i++) {
			Number aktulalisSzam = szamok.get(i);
			System.out.printf("[%s]%s\n",aktulalisSzam.getClass().getSimpleName(),aktulalisSzam);
		}
	}
	public static <T extends Number>void kiiratasListwildExtends(List<? extends Number> szamok) {
		System.out.println("Kiirat List<Number> metodus");
		for(int i = 0; i < szamok.size(); i++) {
			Number aktulalisSzam = szamok.get(i);
			System.out.printf("[%s]%s\n",aktulalisSzam.getClass().getSimpleName(),aktulalisSzam);
		}
}
	// visszarakrja az elkapot elemet
	private static <T> void helper(List<T> l, int i) { // vagy int i  helyet t item, 
		l.add(l.get(i));
	}
	
	// extends adatok kiolvasasa
	public static <T extends Number>void kiiratasListWild(List<?> obiektumok) {
		System.out.println("Kiirat List<Number> metodus");
		for(int i = 0; i < obiektumok.size(); i++) {
			Object o = obiektumok.get(i);
			helper(obiektumok,i);
			System.out.printf("[%s]%s\n",o.getClass().getSimpleName(),o);
		}
}
	
	// super adatok beirasa
	public static void feltoltesListWildSuper(List<? super Number> szamok, int darab) {
		System.out.println("Feltoltes List Super metodus");
		for(int i = 0; i < darab; i++) {
			Number szam = Veletlen.nextInt(100);
			szamok.add(szam);
			System.out.println("Hozzaadjuk "+ szam);
		}
}
}