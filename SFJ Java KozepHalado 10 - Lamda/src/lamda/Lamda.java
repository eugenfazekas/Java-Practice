package lamda;

public class Lamda {

	public static void main(String[] args) {

		Program prog = new Program();
		
		Growl growling = () -> System.out.println("Grrrrrr");
		
		prog.doSomething(growling);
	}

}
