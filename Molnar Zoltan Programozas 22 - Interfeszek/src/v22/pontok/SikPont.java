package v22.pontok;

public class SikPont implements Pont {

	private int x;
	private int y;
	
	public SikPont(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public double tavolsag(Pont masikPont) {
		if(masikPont instanceof SikPont) {
			SikPont masikSikPont = (SikPont) masikPont;
			return Math.sqrt(Math.pow(x- masikSikPont.x,2) + Math.pow(y - masikSikPont.y,2));
			
			
		}
		throw new IllegalArgumentException("Nem lehet tavolsagot szamitani egy SikPont "+
		"es egy " + masikPont.getClass().getSimpleName()+ "kozot");
	}

}
