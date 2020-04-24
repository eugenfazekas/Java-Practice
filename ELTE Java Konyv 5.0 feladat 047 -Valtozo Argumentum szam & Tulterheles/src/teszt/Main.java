package teszt;

public class Main {

	static void udvozol1( String nev) {
		System.out.println("Szia: "+nev);
		
	}
	
	static void udvozol1( String nev1 ,String nev2) {
		System.out.println("Szia: "+nev1 +" Szia: "+nev2);
		
	}
	
	static void udvozoltomb(String[] nevek) {
		for( String i : nevek)
			System.out.println("Szia: "+ i );
	}
	
	static void udvozol2(String... nevek) {
		for( String i : nevek)
			System.out.print(" Szia: "+ i );
	}
	
	static void udvozol3(Double szamo, String... nevek2) { // valtozo szamu fogado utolso kell  legyen
		
	}
	public static void main(String[] args) {
		
		String [] nevek= {"Anna","Punci"};
		
		udvozol1("Anna");
		udvozoltomb(new String[] {"Anna","Balazs","Csaba"});
		udvozol1("Anna","Bela");
		udvozoltomb(nevek);
		udvozol2("Anna", "Punci","Digi","Dugi");
	}

}
