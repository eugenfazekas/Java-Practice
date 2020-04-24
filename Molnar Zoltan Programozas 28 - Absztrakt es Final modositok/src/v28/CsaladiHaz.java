package v28;

public class CsaladiHaz extends Ingatlan {

	private double telekTerulet;
	
	public CsaladiHaz(double telekTerulet , double hazterulet, double bruttoNegyzetMeterAr) {
		super(hazterulet, bruttoNegyzetMeterAr);
		this.telekTerulet = telekTerulet;
		
	}

	@Override
	public double bruttoAr() {
		
		return alapterulet * bruttoNegyzetMeterAr + telekTerulet* bruttoNegyzetMeterAr *0.2;
	}

	@Override
	public String ingatlanTipus() {
		
		return "csaladi haz";
	}

}
