import java.util.Random;
import java.util.Scanner;

public class Tipplelosjatek {

	public static void main(String[] args) {
		
		Scanner beolvaso = new Scanner(System.in);
		Random veletlenSzamGenerator = new Random(3);
		
		while(true) {
			int gondoltSzam = veletlenSzamGenerator.nextInt(3)+1;
			System.out.print("Gondoltam egy szamra 1 es 3 kozot, tippelj melyik az! ");
			int tipp = beolvaso.nextInt();
				if(gondoltSzam == tipp) {
					System.out.println("Eltalatad!");
				}else {
					System.out.println("Nem talalt, nem erre a szamra gondoltam:" + gondoltSzam);
				}
				System.out.print("Szeretnel ujra tippelni? (i/n) ");
				beolvaso.nextLine(); // beolvassa az elozo szam bekeres vegen levo eneter-t
				String tovabb = beolvaso.nextLine();
					if(!tovabb.equals("i")) {
						break;
					}
		}
				beolvaso.close();
	}

}
