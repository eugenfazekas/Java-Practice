package Szemelyek;

public class Alkalmazott extends Szemely {

	Alkalmazott(int eletkor, int iq, String neme) {
		super(eletkor, iq, neme);
	
	}
	int id;
	int tapasztalat;
	
	String beosztas;
	String vegzetseg;
	
	boolean jomunkaero;
    boolean angol;
    boolean nemet;
   
    void irdki() {
		//System.out.println("Szemely Osztaly");
    super.irdki();
}
}