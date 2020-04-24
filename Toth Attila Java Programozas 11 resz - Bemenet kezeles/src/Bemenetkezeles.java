import java.util.Scanner;

public class Bemenetkezeles {

	public static void main(String[] args) {
		
		System.out.println("Mi a neved?");

		Scanner bemenet = new Scanner(System.in);
		
		String nev = bemenet.nextLine();
		
		System.out.println("Szia " + nev );
		
		System.out.println("Hany eves vagy? " + nev );
		
		String ev = bemenet.nextLine();
		
		if(Integer.parseInt(ev) <18)
		
		System.out.println("Igyal tejet " + nev );
		
		else
		
			System.out.println("Meghivlak egy sore " + nev );
		
		
		
	
	
	}

}
