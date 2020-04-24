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

	Szemely(int e, int i, String n) { // A konstruktor neve mindig az osztaly neve
	eletkor = e;
	iq = i;
	neme =n;
	}
}