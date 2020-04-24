package v33;

public class Dolgozo implements Comparable<Dolgozo> {

	private String nev;
	
	private int eletkor;

	public Dolgozo(String nev, int eletkor) {
		super();
		this.nev = nev;
		this.eletkor = eletkor;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public int getEletkor() {
		return eletkor;
	}

	public void setEletkor(int eletkor) {
		this.eletkor = eletkor;
	}

	@Override
	public String toString() {
		return "Dolgozo [nev=" + nev + ", eletkor=" + eletkor + "]";
	}

	@Override
	public int compareTo(Dolgozo arg0) {
		// TODO Auto-generated method stub
		return nev.compareTo(nev);
	}

	
	
	
	
}
