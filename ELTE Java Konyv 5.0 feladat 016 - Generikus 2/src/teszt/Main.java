package teszt;

public class Main {

	public static void main(String[] args) {
		
		Gen<Integer> gi = new Gen <Integer>();
		
		Gen<String>  gs = new Gen <String>();
		
		gi.a = 10;
		
		gs.a = "Hello";

		gi.si = 10;
		
		gi.si = 11;
	}

}
