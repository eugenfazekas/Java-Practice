
public class  Cat extends Animal {

	public Cat() {
	
	}
	
	public Cat(String name) {
		
		this.setName(name);
	}
	
	public Cat(String name , int weight) {
		
	this.setName(name);
	this.setWeight(weight);
	
	}
	
	public void makeSound() {
		System.out.println("MEOW");
	}
	
	public void purr() {
		System.out.println("Dorombolok");
	}
}
