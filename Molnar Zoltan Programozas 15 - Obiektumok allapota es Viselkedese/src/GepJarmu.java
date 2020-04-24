
public class GepJarmu {
	
	boolean motorMukodik = false;
	double sebesseg;
	String tipus;
	
	public GepJarmu(String adottipus) {
		tipus = adottipus;
		sebesseg = 0.0;
	}

	public double sebesseg() {
		return sebesseg;
	}
	
	public String tipus() {
		return tipus;
	}
	
	public void indits() {
		motorMukodik = true;
	}
	
	public void allj() {
		motorMukodik = false;
	}
	
	public void gyorsits(double novekmeny) {
		if(motorMukodik) {
			sebesseg += novekmeny;
		}
	}
	
	public void gyorsits() {
		gyorsits(10.0);
	}
	
	public void lassits (double csokkenes) {
		if(motorMukodik) {
			sebesseg = Math.max(sebesseg - csokkenes, 0.0);
		}
	}
	
	public void lassits() {
		lassits(10.0);
	}
	
	public String allapot() {
		String szoveg = "Ez egy " + tipus + " tipusu jarmu";
		
		if(motorMukodik&& sebesseg>0) {
			szoveg = szoveg + " amely "+ sebesseg +" km/h sebesseg mozog.";
		}
		return szoveg;
	}
	
}
