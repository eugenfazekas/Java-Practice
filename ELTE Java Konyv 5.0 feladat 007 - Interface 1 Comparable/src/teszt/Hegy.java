package teszt;

public class Hegy implements Comparable <Hegy>{

	String nev;
	
	int magassag;
	
	public Hegy (String n, int m) {
		nev = n; magassag = m;
	}
	
	@Override
	public int compareTo(Hegy h) {
		if(this.magassag > h.magassag)
			return -1;
		return this.magassag < h.magassag ? 1 : 0;
	}

	@Override
	public String toString() {
		return  nev + ":" + magassag;
	}
	
}
