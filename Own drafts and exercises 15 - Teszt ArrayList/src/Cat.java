
public class  Cat extends Animal {

	public Cat() {
		super(); ///Orokli a fentebik osztalyt
	}
	
	public Cat(String name) {
		
		this.setName(name);
	}
	
	public Cat(String name , int weight) {
		
	this.setName(name);
	this.setWeight(weight);
	
	}
}
