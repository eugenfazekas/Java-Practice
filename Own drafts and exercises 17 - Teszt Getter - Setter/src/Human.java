
public class Human {

	private String nev = "Anna";
	
	private int age;

	
	 String getName() {
		 
		return this.nev;
		 
	 }
	 
	void SetName(String nev) {
		 
		this.nev = nev;
		
	}
	
	int getAge() {
		return this.age;
		
	}
	
	void setAge(int age) {
		
		this.age = age;
	}
 void kiiras () {
		
		System.out.println("Az en nevem " + getName());
		
	}
}

	
