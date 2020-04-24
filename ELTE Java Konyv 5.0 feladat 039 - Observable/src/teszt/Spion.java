package teszt;

import java.util.Observable;

public class Spion implements java.util.Observer{

	@Override
	public void update(Observable o, Object obj) {
		
		System.out.println("Ne bantsatok szegenyt! Te meg' "+obj+" ' , menj vissza!");
	}

}
