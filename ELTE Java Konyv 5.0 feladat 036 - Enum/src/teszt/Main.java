package teszt;

import teszt.Kartya.Ertek;
import teszt.Kartya.Szin;

public class Main {

	
	
	public static void main(String[] args) {
		
		Kartya kartya = new Kartya(Szin.MAKK,Ertek.FELSO);
		
		System.out.println(kartya);
	}

}
