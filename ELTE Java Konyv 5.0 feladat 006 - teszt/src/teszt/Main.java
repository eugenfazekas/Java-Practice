package teszt;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
	
		Scanner  scan = new Scanner(System.in);
		
		System.out.println("Gepeljen be egy szamot h tudja meg mennyi elosztva 100-al");
				
		while(scan.hasNext()) {
			
			System.out.println("Gepeljen be egy szamot h tudja meg mennyi elosztva 100-al");
		try {
			
			String szam0 = scan.next();
			float szam = Float.parseFloat(szam0);
			
			System.out.println(100/szam);
		}catch(java.lang.NumberFormatException e) {
			System.out.println("A szam beolvasasa nem sikerult "+ e);
			
			}	

			}

		byte b = 0;	short s; int i; long l;
		float f = 0; double d; char c;
		s=b; c = (char) b;
		i=s;i=c;l=i;d=f;
		f=l;
		b=12;
	
		Konyvteszt1 konyv1,konyv2;
		Konyvteszt2 sorozat1,sorozat2;
		sorozat1 = new Konyvteszt2();
		konyv1 = new Konyvteszt1();
		konyv2 = sorozat1;
		sorozat2 = (Konyvteszt2)konyv2;
		
		konyv2=konyv1;
		sorozat2 = (Konyvteszt2) konyv2;
	
	}

}
