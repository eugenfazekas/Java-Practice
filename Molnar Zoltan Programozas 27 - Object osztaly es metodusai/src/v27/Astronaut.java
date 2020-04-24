package v27;

public class Astronaut implements Cloneable{

	private String name;

	public Astronaut(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Astronaut) {
			Astronaut other = (Astronaut)obj;
			return name.equals(other.name);
		}
		return false;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
}
