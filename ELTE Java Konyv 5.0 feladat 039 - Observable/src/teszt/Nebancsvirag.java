package teszt;

public class Nebancsvirag extends  java.util.Observable {

	public void valtozik(Object o) {
		setChanged();
		notifyObservers(o);
	}
	
	public static void main(String[] args) {
		
		Nebancsvirag n = new Nebancsvirag();
		Szamlalo s = new Szamlalo();
		Spion fioka = new Spion();
		n.addObserver(s);
		n.addObserver(fioka);
		n.valtozik(new Integer(100));
		n.valtozik("piszka,motoszka");
		n.valtozik("teszt");
		System.out.println("A Nebancsviragot " + s.valtozasokSzama() + " -szor valtoztattak");

	}

}
