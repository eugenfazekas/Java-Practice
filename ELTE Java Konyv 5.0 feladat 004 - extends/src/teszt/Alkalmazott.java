package teszt;

public class Alkalmazott {
		
	String nev;
	
	static int szam = 0;
	
	int eletkor;
	
	int nyelvekSzama;
	
	public int potlek() {
		return nyelvekSzama*5000;
	}
	
	private static int kovSzam = 1;
	
	public final int Szam = kovSzam++;
	
	static int nyugdijkorhatar = 60;
	
	static void nyugdijkorhataremel() {
		nyugdijkorhatar++;
	}
	
	int fizetes;

	public Alkalmazott() {
	
	}
	
		
	public Alkalmazott(String nev ,int fizetes) {
		this.nev = nev;
		this.fizetes = fizetes;
	}
	
	public Alkalmazott(String nev) {
		this(nev,40000);
	}
	
	void fiztestEmel(int novekmeny) {
		fizetes += novekmeny; 
		}
	
	void fiztestEmel() {
		fizetes += 5000; 
		}
	
	void fiztestEmel(Alkalmazott masik) {
		if(kevesebbetkeressMint(masik))  {
			fizetes = masik.fizetes;
		}
	}

	boolean tobbetKeresMint(Alkalmazott masik) {
		return fizetes > masik.fizetes;
	}
	
	boolean kevesebbetkeressMint (Alkalmazott masik) {
		return masik.tobbetKeresMint(this);
	}
	static int[] evesSzabadsag = new int[60];
	static {
		for(int i = 0;  i< 30; i++) evesSzabadsag[i] = 15;
		for(int i = 30; i< 40; i++) evesSzabadsag[i] =evesSzabadsag[i-1]+1;
		for(int i = 40; i< 50; i++) evesSzabadsag[i] =evesSzabadsag[i-1]+2;
		for(int i = 50; i< 60; i++) evesSzabadsag[i] =evesSzabadsag[i-1]+1;
	}
	public int evesSzabadsag() {
		return evesSzabadsag[eletkor < 60 ? eletkor:59];
	}

}
