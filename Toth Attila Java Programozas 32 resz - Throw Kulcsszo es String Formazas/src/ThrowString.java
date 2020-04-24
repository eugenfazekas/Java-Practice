import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class ThrowString {

	public static void main(String[] args) throws FileNotFoundException {
		
		File fajl = new File("adatok.txt");
		
		PrintWriter kimenet = new PrintWriter(fajl);
		kimenet.println("Eniko");
		kimenet.println(21);
		kimenet.println("Szoke");
		kimenet.close();
		
		
	
			Scanner bemenet = new Scanner(fajl);
			String nev = bemenet.nextLine();
			int kor = bemenet.nextInt();	
			System.out.printf("Nev: %s - Kor: %d ", nev,kor);
		
			
		
}
}