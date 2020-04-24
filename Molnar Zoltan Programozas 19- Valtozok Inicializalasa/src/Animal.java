
public class Animal {

	private static int numberOfAnimals;
	
	static {
		numberOfAnimals =0;
		
	}
	
	private String name;
	
	private double weight;
	
	private static boolean domesticated = false;
	
	{
		name = "Bela";
	}
	
	{
		weight = 1000;
	}
	
	public Animal() {
		this("No Name", domesticated);
	}
	
	public Animal(String myName , boolean domestic) {
		name= myName;
		domesticated= domestic;
		
	}
	
		
	public static int getNumberOfAnimalsz() {
		return numberOfAnimals;
	}
	
	public final void doValamit() {
		Animal.getNumberOfAnimalsz();
	}
}
