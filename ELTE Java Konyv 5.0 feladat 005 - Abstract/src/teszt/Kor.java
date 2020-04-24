package teszt;

public class Kor extends Sikidom{

	private double r;
	
	public Kor(double r) {
		this.r = r;
	}
	
	public double r() {
		return r;
	}
	
	@Override
	protected double keruletszamit() {
		
		return 2*Math.PI*r;
	}

	@Override
	protected double teruletszamit() {
		
		return r*r*Math.PI;
	}

	

}
