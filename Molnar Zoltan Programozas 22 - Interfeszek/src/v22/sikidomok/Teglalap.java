package v22.sikidomok;

import v22.pontok.Pont;

public class Teglalap implements Sikidom {

private double aOldal, bOldal;
	
	public Teglalap(Pont a , Pont b, Pont c , Pont d) {
		this.aOldal = a.tavolsag(b);		
		this.bOldal = b.tavolsag(c);
	}
	
	@Override
	public double kerulet() {
		
		return 2* (aOldal +bOldal);
	}

	@Override
	public double terulet() {
		
		return aOldal* bOldal;
	}

}
