
public class Tombok {

	static String[] nevek5 = {" Anna", " Adriana", " Angela", " Adel"};
	static int[] szamok = {1,2,3,4,5,6,7,8,9,10};
	
	public static void main(String[] args) {
		
		int[] tomb1 = new int [10];
		
		int[] tomb2 = new int [] {1,2,3,4,5,6,7,8,9,10};
		
		for(int i = 0; i < tomb1.length; i++) {
			System.out.print(tomb1[i] + " ");
		}
		
			System.out.println( " "); // tavolsagok
		
		for(int i = 0; i < tomb1.length; i++) {
				System.out.print(tomb2[i] + " ");
		}	
			String[] nevek = new String[] {"Bozsi, ","Bea, ","Anna, ","Timi "};	
		
			nevek[0] = "Eniko, ";
			
			System.out.println( " ");
			
	for (int i=0 ; i<nevek.length ; i++) {
		System.out.print(nevek[i]);
	}
	}//Console
///
}//    0 0 0 0 0 0 0 0 0 0  
//     1 2 3 4 5 6 7 8 9 10  
//     Eniko Bea, Anna, Timi 
