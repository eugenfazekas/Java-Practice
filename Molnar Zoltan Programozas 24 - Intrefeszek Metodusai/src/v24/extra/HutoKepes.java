package v24.extra;

public interface HutoKepes {

	double ABSZOLUT_NULLA_CELSIUSBAN = -273.15;
	
	void csokentsHomersekletet(double delta);
	
	default boolean lehetTovabbCsokkenteni(double aktualisHomerseklet, double delta) {
		return aktualisHomerseklet -delta > ABSZOLUT_NULLA_CELSIUSBAN;
	}
	
	static double fahreinheitCelsiusba(double fahrenheit) {
		return(fahrenheit -32)/1.8;
	}
	
}
