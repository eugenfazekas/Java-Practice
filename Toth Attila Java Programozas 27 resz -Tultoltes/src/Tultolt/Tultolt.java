package Tultolt;

// method Overloading - metodus tultoltes

public class Tultolt {

	public void greeting() {
		System.out.println("Hello Vilag!");
	}
	public void greeting(String nev) {
		System.out.println("Hello " + nev);
	}
	
	public void greeting(String nev, String udv) {
		System.out.println(udv +" "+nev);
	}
	public void greeting(String nev, int x) {
		System.out.println(nev + x + "Eves");
	}
}
