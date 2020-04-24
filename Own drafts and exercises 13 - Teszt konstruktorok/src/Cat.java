
public class Cat extends Animal{

	
	public Cat () {
	}
 
	public Cat(String name) {
		
		this.setName(name);
	
		
	}
	
	public Cat(String name, int weight) {
		
		this.setName(name);
		this.setWeight(weight);
	}
	
	public Cat (int age,String name,int weight) {
		
		this.setName(name);
		this.setAge(age);
		this.setWeight(weight);
	}
	}

