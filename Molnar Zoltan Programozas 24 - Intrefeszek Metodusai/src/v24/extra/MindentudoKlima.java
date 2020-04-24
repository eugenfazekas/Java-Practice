package v24.extra;

public class MindentudoKlima implements Klima {
	
	private static final double MINIMALIS_HOMERSEKLET = 18.0;
	
	private double eszleltHomerseklet;
	private double celHomerseklet;
	
	public MindentudoKlima(double celHomerseklet) {
		this.celHomerseklet = celHomerseklet;
		this.eszleltHomerseklet = mertHomerseklet();
	}

	@Override
	public void noveljHomersekletet(Double delta) {
		celHomerseklet = celHomerseklet + delta;
		bekapcsol();
		
	}

	@Override
	public void csokentsHomersekletet(double delta) { 
		if(lehetTovabbCsokkenteni(celHomerseklet,delta)) {
			celHomerseklet = celHomerseklet - delta;
			bekapcsol();
		}
		
	}

	@Override
	public boolean lehetTovabbCsokkenteni(double aktualisHomerseklet, double delta) {
		return aktualisHomerseklet -delta >= MINIMALIS_HOMERSEKLET;
		 
	}
	
	public void bekapcsol() {
		if(celHomerseklet!= eszleltHomerseklet) {
			
		}
			
	}

	@Override
	public String toString() {
		return "A MindentudoKlima " + celHomerseklet + "C-ra van bealitva";
	}
	
	private double mertHomerseklet() {
		return 24.0;
	}
}
