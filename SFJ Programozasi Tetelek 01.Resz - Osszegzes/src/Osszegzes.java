
public class Osszegzes {

	public static void main(String[] args) {
		
		int[] tomb = {1,2,4,5,6,8,10}; 
		
		int osszeg = 0;
		
		for(int i = 0; i < tomb.length; i++) {
			osszeg = osszeg + tomb[i]; 
		}
			
System.out.println(osszeg);
	}

}
