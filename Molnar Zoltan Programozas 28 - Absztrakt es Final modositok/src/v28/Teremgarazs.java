package v28;

public class Teremgarazs extends Garazs {

	public Teremgarazs(double hosszusag, double szelesseg, double bruttoAr) {
		super(hosszusag, szelesseg, bruttoAr);
		
	}

	@Override
	public String ingatlanTipus() {
		
		return "teremgarazs";
	}

}
