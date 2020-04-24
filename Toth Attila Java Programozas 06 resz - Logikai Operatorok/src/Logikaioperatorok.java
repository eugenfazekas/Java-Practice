
public class Logikaioperatorok {

	public static void main(String[] args) {
		
		int szam1 = 7;
		
		int szam2 = 3;
		
		
		System.out.println(szam1 == szam2 && szam1 >= szam2);//false
		System.out.println(szam1 >= szam2 && szam1 != szam2);//true
		
		// && - mind igaz kelle legyen
		System.out.println(szam1 == szam2 || szam1 <= szam2 );//false
		System.out.println(szam1 > szam2 || szam1 < szam2 );//true
	
		// || - eleg egynek igaz legyen
		
		boolean a = true;
		boolean b = false;
		
		boolean c = a ^ b;   //csak es kizarolag egyik lehet igaz ^   
		
		System.out.println(c);
	}
	

}
