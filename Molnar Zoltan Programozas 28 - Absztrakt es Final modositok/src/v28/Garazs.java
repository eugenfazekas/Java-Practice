package v28;

public abstract class Garazs extends Ingatlan{
	
	private final double hosszusag;
	private final double szelesseg;
	

	public Garazs(double hosszusag, double szelesseg, double bruttoAr) {
		super(hosszusag * szelesseg, bruttoAr / (hosszusag *szelesseg));
		this.hosszusag = hosszusag;
		this.szelesseg = szelesseg;
	}


	public double getHosszusag() {
		return hosszusag;
	}


	public double getSzelesseg() {
		return szelesseg;
	}
	
	@Override
	public double bruttoAr() {
		return alapterulet * bruttoNegyzetMeterAr;
	}


	@Override
	public String toString() {
		return "Ez a " + String.format("%.2f x %.2f", hosszusag, szelesseg) 
		+ " meretu garazs " + String.format("%,.2f", bruttoAr()) + " Ft.";
	}
	
}
