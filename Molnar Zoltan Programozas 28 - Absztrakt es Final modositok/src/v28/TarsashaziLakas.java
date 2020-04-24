package v28;

public class TarsashaziLakas extends Ingatlan {

	public TarsashaziLakas(double alapterulet, double bruttoNegyzetMeterAr) {
		super(alapterulet, bruttoNegyzetMeterAr);
		
	}

	@Override
	public double bruttoAr() {
		
		return alapterulet * bruttoNegyzetMeterAr;
	}

	@Override
	public String ingatlanTipus() {
		
		return "tarsashazi lakas";
	}

}
