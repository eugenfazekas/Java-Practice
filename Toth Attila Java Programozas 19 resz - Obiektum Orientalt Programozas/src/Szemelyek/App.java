package Szemelyek; // 2 class

public class App {

	public static void main(String[] args) {
		
		Szemely Monika = new Szemely();
		Monika.eletkor = 25;
		Monika.iq = 105;
		Monika.neme = "No"; 
		Monika.hazas = false;
		
		Szemely Erika = new Szemely();
		Erika.eletkor = 30;
		Erika.iq = 107;
		Erika.hazas = true;
		
		System.out.println(Erika.hazas);
		System.out.println(Monika.hazas);
					
}

}
