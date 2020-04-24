import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
	
		File fajl = new File("adatok.txt");
		
		try {
		PrintWriter kimenet = new PrintWriter(fajl);
		kimenet.println("Eniko");
		kimenet.println(21);
		kimenet.println("Szoke");
		kimenet.close();
		}catch(FileNotFoundException ex){
			System.out.println("Hiba, a fajl nem elerheto");
		}
		
		
		try {
			Scanner bemenet = new Scanner(fajl);
			String nev = bemenet.nextLine();
			int kor = bemenet.nextInt();	
			System.out.println(nev);
			System.out.println(kor);
		}
		
			
	catch(FileNotFoundException ex) {
			System.out.println("Hiba, a fajl nem elerheto");
	}
				
}
}