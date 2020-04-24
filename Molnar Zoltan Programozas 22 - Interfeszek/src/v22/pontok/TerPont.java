package v22.pontok;

public class TerPont implements Pont{

	private int x;
	private int y;
	private int z;
	
	public TerPont(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public double tavolsag(Pont masikPont) {
		if(masikPont instanceof TerPont) {
			TerPont masikTerPont = (TerPont) masikPont;
			return Math.sqrt(Math.pow(x- masikTerPont.x,2) + Math.pow(y - masikTerPont.y,2)+
					 Math.pow(z - masikTerPont.z,2));
			
			
		}
		throw new IllegalArgumentException("Nem lehet tavolsagot szamitani egy SikPont "+
		"es egy " + masikPont.getClass().getSimpleName()+ "kozot");
	}
}
