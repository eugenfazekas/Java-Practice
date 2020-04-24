package v32;

public class Main {

	public static void main(String[] args) {
		
		Character c = 'a';
		
		Integer[] szamok = {25,13,-128};
		
		Long a = new Long(55);
		
		Long b = new Long(22);
		
		int osszeg = 0;

		for(int i = 0 ;i< szamok.length; i++) {
			System.out.println(szamok[i].compareTo(13));
			osszeg += szamok[i];
		}
		
		System.out.println("Atlag: "+ (Integer.valueOf(osszeg).doubleValue()
				/ szamok.length));
		System.out.println(negyzet(a));
		System.out.println(negyzet(a+b));
	}

	public static Long negyzet(Long szam) {
		return szam *szam;
	}
	
}
