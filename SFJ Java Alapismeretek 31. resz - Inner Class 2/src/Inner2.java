interface Message {
	String greet();
	
}

class My_class {
	public void displayMessage(Message m) {
		System.out.println(m.greet() + 
				" Ez egy Pelda");
	}
}

public class Inner2 {

	public static void main(String[] args) {
	
		My_class obj = new My_class();
		
		obj.displayMessage(new Message() {
			public String greet() {
				return "Hello";
			}
		});

	}

}
