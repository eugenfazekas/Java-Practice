package v24.extra;

public class Huto implements HutoKepes {

	private double homerseklet;
	
	public Huto(double kezdetiHomerseklet) {
		this.homerseklet = kezdetiHomerseklet;
	}
	
	@Override
	public void csokentsHomersekletet(double delta) {
		if(lehetTovabbCsokkenteni(homerseklet,delta)) {
			homerseklet =homerseklet-delta;
		}
		
	}

	@Override
	public String toString() {
		return "A huto belsejeben" + homerseklet + "C van";
	}

}
