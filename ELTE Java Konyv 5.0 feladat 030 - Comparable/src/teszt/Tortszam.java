package teszt;

public class Tortszam implements Comparable<Tortszam>{

	private long szamlalo,nevezo;

	public Tortszam(long szamlalo, long nevezo) {
		this.szamlalo = szamlalo;
		this.nevezo = nevezo;
	}
	
	public boolean equals(Object obj) {
		return (obj != null)&&(obj instanceof Tortszam)&&(szamlalo * ((Tortszam)obj).nevezo == ((Tortszam)obj).szamlalo*nevezo);
	}
	
	private void  egyszerusit() {
		
	}
	
	public int hashCode() {
		egyszerusit();
		return (int)nevezo;
	}

	@Override
	public int compareTo(Tortszam t) {
	
		return (int)(szamlalo * t.nevezo - t.szamlalo *nevezo);
	}

	@Override
	public String toString() {
		return  szamlalo + "/" + nevezo +" ";
	}
	
}
