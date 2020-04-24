
public class Metodusok {

	static String[] nevek = {" Anna", " Adriana", " Angela", " Adel"};
	static int[] szamok = {1,2,3,4,5,6,7,8,9,10};
	public static void main(String[] args) {
	
		int osszeg = plusz(5,6);
		System.out.println(osszeg);
	
		for(int i = 0; i < nevek.length; i++ ) {
			System.out.println(hello(nevek[i]));
				}

		for(int i = 0; i < szamok.length; i++) {
			System.out.print(hatvany(szamok[i]) + " ");
		}
		System.out.println(" ");
		
		Irdat();
		for(int i =0; i < szamok.length ; i++ ) {
			System.out.print(szamok[i]+ " ");
			
			
		}
		System.out.println(" ");
		
	System.out.println(	hello(" Aranka"));
	}

	public static int plusz (int a, int b) {
		return  a  + b ;
		
	}

	public static String hello (String nev) {
		String koszones = "Hello" + nev;
		return koszones;
		
	}
	public static int hatvany(int x) {
	return x * x;
}
	public static void Irdat() {
		for(int i = 0 ; i < szamok.length; i++)
			szamok[i] = szamok[i] +5;
		
	}	
}

/*
11
Hello Anna
Hello Adriana
Hello Angela
Hello Adel
1 4 9 16 25 36 49 64 81 100  
6 7 8 9 10 11 12 13 14 15  
Hello Aranka
*/