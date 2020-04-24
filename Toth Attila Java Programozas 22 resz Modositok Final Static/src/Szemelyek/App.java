package Szemelyek;

public class App {

	public static void main(String[] args) {
		Szemely Monika = new Szemely();
		Monika.eletkor = 25;
		Monika.iq = 105;
		Monika.neme = "No"; 
		Monika.hazas = false;
		
		Alkalmazott Eniko = new Alkalmazott();
		Eniko.eletkor = 18;
		Eniko.neme = "No";
		Eniko.tapasztalat = 1;
		Eniko.nemet = false;
		
	
		System.out.println(Alkalmazott.pi);

		Eniko.testsuly = 50;
		Eniko.test();
	}

}
