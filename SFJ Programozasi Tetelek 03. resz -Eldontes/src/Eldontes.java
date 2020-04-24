
public class Eldontes {

	public static void main(String[] args) {
		
		int[] tomb = {1,3,5,8,5,43};
		
		int keresendo = 5;
		
		byte i = 0;
		
		while(i<tomb.length && tomb[i] != keresendo)
			i++;
		
		if(i<tomb.length)
			System.out.println("Talalt");
		else
			System.out.println("Nincs talalat");
		

	}

}
