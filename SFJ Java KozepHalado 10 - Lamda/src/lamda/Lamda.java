package lamda;

public class Lamda {

	public static void main(String[] args) {
		
		Growl growling1 = new Dog();
		
		Program prog1 = new Program();
		
		prog1.doSomething(growling1);
		

		
		//With Lamda expression
		
		Growl growling2 = () -> System.out.println("Lamda");     //Itt mar megadjuk az Interfacenek a fuggvenyet vagy metodusat is.
		
		Program prog2 = new Program();
		
		prog2.doSomething(growling2);

	}

}
