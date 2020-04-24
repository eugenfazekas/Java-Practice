package v24.extra;

public class Main {

	public static void main(String[] args) {
		MindentudoKlima klima = new MindentudoKlima(24);
		
		
		
		klima.bekapcsol();
		
		klima.csokentsHomersekletet(2);
		
		klima.lehetTovabbCsokkenteni(21, 19);
		
		klima.noveljHomersekletet(3.1);

		System.out.println(klima.toString());
	}

}
