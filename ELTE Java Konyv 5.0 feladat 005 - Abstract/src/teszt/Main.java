package teszt;

public class Main {

	public static void main(String[] args) {
	
		Teglalap teglalap = new Teglalap(2,4);
		
		Kor kor = new Kor(5);
		
		System.out.println(teglalap.kerulet());
		System.out.println(teglalap.terulet());
		
		System.out.println(kor.kerulet());
		System.out.println(kor.terulet());

		System.out.println(Sikidom.szam);
		Sikidom.szam = 2;
		System.out.println(Sikidom.szam);
	}

	

	
	
}
