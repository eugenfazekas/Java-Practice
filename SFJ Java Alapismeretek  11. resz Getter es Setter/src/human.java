
public class human {

	private String name = "Gyula";
	
	private int age;
	
	
	 void writename() {
		
		System.out.println("Az en nevem " + this.name);
	}
	
	 	String getname() {
		
		return this.name;
		
	}
	void setname(String input) {
		
		this.name = input;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}	
		
	
}
