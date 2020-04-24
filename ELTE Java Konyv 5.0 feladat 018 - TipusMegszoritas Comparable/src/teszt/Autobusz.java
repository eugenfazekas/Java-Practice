package teszt;

public class Autobusz implements Comparable {

	private int utasokSzama;
	
	public Autobusz(int usz) {
		utasokSzama = usz;
	}
	

	public int compareTo(Autobusz a) {
		int kul = utasokSzama -a.utasokSzama;
		return kul< 0 ? -1 : kul == 0 ? 0 : 1;
	}

	@Override
	public int compareTo(Object other) {
		return compareTo((Autobusz) other);
	}

}
