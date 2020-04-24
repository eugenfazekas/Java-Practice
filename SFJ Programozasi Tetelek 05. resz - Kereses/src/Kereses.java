
public class Kereses {

	public static void main(String[] args) {
		 
		int[] tomb = {1,3,5,6,43,8,};
		
		int keresendo = 8;
		
		int i = 0;
			
			while(i<tomb.length && tomb[i] != keresendo) //Nagyon fontos 
				i++;	// a felteteli sorrend
			
		if(i < tomb.length) 
			
			System.out.println("Van Talalat a "+ (i+1) + " helyen");
		
		else
			System.out.println("Nincs talalat");
		
		}

}
