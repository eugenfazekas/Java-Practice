
public class Animal {

	private static int numberOfAnimals;
	
	static {
		numberOfAnimals =0;
		
	}
	
	private String name;
	
	private double weight;
	
	private boolean domesticated;
	
	public Animal() {
		numberOfAnimals++;
		
	}
	
	public static int getNumberOfAnimalsz() {
		return numberOfAnimals;
	}
	
	public final void doValamit() {
		Animal.getNumberOfAnimalsz();
	}
}
