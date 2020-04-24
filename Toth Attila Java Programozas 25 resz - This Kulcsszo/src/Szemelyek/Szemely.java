package Szemelyek;

public class Szemely {
	int eletkor;
	int magassag;
	int testsuly;
	int iq;
	
	String neme;
	String hajszin;
	String szemszin;
	
	boolean hazas;

	Szemely(int eletkor, int iq, String neme) { // A konstruktor neve mindig az osztaly neve
	this.eletkor = eletkor;
	this.iq = iq;
	this.neme =neme;
}
}