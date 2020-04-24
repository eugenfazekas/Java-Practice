package teszt;

public class Main {

	static String[] args2;
	
	public static void main(String[] args) throws VeremMegteltException {
		
		Pojo agi = new Pojo("Agi");
		
		Pojo anita = new Pojo("Anita");
		
		Pojo adel = new Pojo("Adel");
		
		Verem verem = new Verem();
		
		verem.betesz(agi);
		
		verem.betesz(anita);
		
		verem.betesz(adel);
		
		verem.tarolo();

		System.out.println();
		
	}


}