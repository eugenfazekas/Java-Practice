package teszt;

public class Fonok extends Alkalmazott{
	
	

	public Fonok(String nev, int fizetes) {
		super(nev, fizetes);
	}
	
	public Fonok (String nev) {
		this(nev,100000);
	}

	final int MAXBEOSZT = 20;
	
	Alkalmazott [] beosztottak = new Alkalmazott[MAXBEOSZT];
	
	static int beosztottakSzama = 0;
	
	public void ujBeosztott(Alkalmazott b) {
		beosztottak [beosztottakSzama++] = b;
	}
	
	public int potlek() {
		return super.potlek() + beosztottakSzama*1000;
	}
}
