package teszt;

public class Main {

	public static void main(String[] args) {
		
		char []karaktertomb = {'m','e','g','g','y'};
		
		String szo3= new String(karaktertomb,2,3); //2-es index 3 karakter;
		
		String szo = new String(karaktertomb);
		
		double d =5.25;
		
		boolean l = false;
		
		String szo2= String.valueOf(d) +" "+ String.valueOf(l);
		
		System.out.println(szo +" "+szo3 +" "+szo2);
		
		char []karaktertomb2 = {'c','s','e','r','e','s','z','n','y','e'};
		
		String s13 = String.copyValueOf(karaktertomb2);
		
		char []karaktertomb3 = new char[10];
		
		System.out.println(s13);
		
		String s14 = String.copyValueOf(karaktertomb2);
		
		s14.getChars(0, 7, karaktertomb3, 0);  // input  kezdo ertek i-dik betu/  input zaro ertek i-dik betu / melyik Stringbol / tomb melyik indexen kezdodjon

		System.out.println(karaktertomb3);
		
		char []karaktertomb4 = s13.toCharArray();
		
		System.out.print(karaktertomb4);

	}

}
