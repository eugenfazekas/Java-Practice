package v28;

public abstract class Ingatlan {

	protected final double alapterulet;
	
	protected double bruttoNegyzetMeterAr;

	public Ingatlan(double alapterulet, double bruttoNegyzetMeterAr) {
		super();
		this.alapterulet = alapterulet;
		this.bruttoNegyzetMeterAr = bruttoNegyzetMeterAr;
	}
	
	public abstract double bruttoAr();
	
	public abstract String ingatlanTipus();

	public void setBruttoNegyzetMeterAr(double bruttoNegyzetMeterAr) {
		this.bruttoNegyzetMeterAr = bruttoNegyzetMeterAr;
	}

	@Override
	public String toString() {
		return "Ez a(z) " + ingatlanTipus() + " " + String.format("%,.2f", bruttoAr()) + "Ft";
	}

}
