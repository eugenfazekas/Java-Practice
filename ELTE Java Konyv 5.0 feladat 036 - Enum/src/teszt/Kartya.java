package teszt;

public class Kartya {

	public enum Szin {MAKK,TOK,PIROS,ZOLD};
	public enum Ertek {HET,NYOLC,KILNEC,TIZ,ALSO,FELSO,KIRALY,ASZ}
	
	private final Szin szin ;
	private final Ertek ertek ;
	
	public Kartya(Szin szin, Ertek ertek) {
		this.szin = szin;
		this.ertek = ertek;
	}

	public Szin getSzin() {
		return szin;
	}

	public Ertek getErtek() {
		return ertek;
	}

	@Override
	public String toString() {
		return  szin + " " + ertek ;
	}
	
	
}
