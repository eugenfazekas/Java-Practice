package teszt;

public class Kartya {
	
	

	public enum Szin {MAKK,TOK,PIROS,ZOLD};
	
	public enum Ertek {
		HET(7),NYOLC(8),KILNEC(9),TIZ(10),ALSO(2),FELSO(3),KIRALY(4),ASZ(11);
		private final int  pontszam;

		public int getPontszam() {
			return pontszam;
		}

		private Ertek(int pontszam) {
			this.pontszam = pontszam;
		}
		
		}
	
	
	
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
