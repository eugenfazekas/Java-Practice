package v33;

public class Elem <T>  {

	private T tartalom;
	
	private Elem<T> elozo;
	
	private Elem<T> kovetkezo;
	
	

	public Elem(T tartalom) {
		super();
		this.tartalom = tartalom;
	}

	public T getTartalom() {
		return tartalom;
	} 

	public void setTartalom(T tartalom) {
		this.tartalom = tartalom;
	}

	public Elem<T> getElozo() {
		return elozo;
	}

	public void setElozo(Elem<T> elozo) {
		this.elozo = elozo;
	}

	public Elem<T> getKovetkezo() {
		return kovetkezo;
	}

	public void setKovetkezo(Elem<T> kovetkezo) {
		this.kovetkezo = kovetkezo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tartalom == null) ? 0 : tartalom .hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) { 
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		Elem<T> other = (Elem<T>) obj;
		if (tartalom == null) {
			if (other.tartalom != null) {
				return false;
			}
		} else if (!tartalom .equals(other.elozo)) {
			return false;
		}
		return true;
	}
	
	
}
 