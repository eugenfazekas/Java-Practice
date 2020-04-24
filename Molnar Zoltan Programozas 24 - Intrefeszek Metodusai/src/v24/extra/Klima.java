package v24.extra;

public interface Klima extends Futokepes, HutoKepes {

	double MINIMALIS_MEGENGEDET_HOMERSEKLET = 18.0;
	double MAXIMALIS_MEGENGEDETT_HOMERSEKLET = 28.0;
	
	@Override
	boolean lehetTovabbCsokkenteni(double aktualisHomerseklet, double delta); 
		
	}
	

