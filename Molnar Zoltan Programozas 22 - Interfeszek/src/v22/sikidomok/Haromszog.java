package v22.sikidomok;

import v22.pontok.Pont;

public class Haromszog  implements Sikidom{

	private double aOldal, bOldal,cOldal;
	
	public Haromszog(Pont a , Pont b, Pont c) {
		this.aOldal = b.tavolsag(c);
		this.bOldal = a.tavolsag(c);		
		this.cOldal = a.tavolsag(b);
	}
	
	
	@Override
	public double kerulet() {
		
		return aOldal + bOldal+ cOldal;
	}

	@Override
	public double terulet() {
		
		double cosGamma = (aOldal*aOldal + bOldal *bOldal -cOldal*cOldal)
				/(2 * aOldal *cOldal);
		double gamma = Math.acos(cosGamma);
		double magassag = bOldal * Math.sin(gamma);
		return aOldal * magassag/2;
	}

}
