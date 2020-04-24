package teszt;

public class TeherAuto implements Comparable {

	private double hasznosTeher;

	public TeherAuto(double suly) {
		hasznosTeher = suly;
	}
	
	public int compareTo(TeherAuto t) {
		double kul = hasznosTeher -t.hasznosTeher;
		return kul< 0. ? -1 : kul == 0. ? 0 : 1;
	}

	@Override
	public int compareTo(Object other) {
		return compareTo((TeherAuto) other);
	}
	
}
