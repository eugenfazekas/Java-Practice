package teszt;

import java.util.Observable;

public class Szamlalo implements java.util.Observer {

	int valtozasok;
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		valtozasok++;
	}

	public int valtozasokSzama() {
		return valtozasok;
	}
	
}
