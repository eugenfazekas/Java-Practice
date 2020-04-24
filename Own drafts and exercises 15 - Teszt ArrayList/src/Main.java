import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
ArrayList<Animal> cats = new ArrayList<Animal>();

Cat sziamiau = new Cat("Sziamiau");

Dog morzsa = new Dog();

cats.add(morzsa);

cats.add(sziamiau);

if(!cats.isEmpty())
	
	System.out.println(cats.get(0).getName());

	Cat cat = (Cat) cats.get(0); //Animal Array castolas macskava
	
	
	Cat cat2 = (Cat) cats.get(1); //Animal Array castolas macskava
	
	System.out.println(cat.getName());
	
	
	
	
	}

}
