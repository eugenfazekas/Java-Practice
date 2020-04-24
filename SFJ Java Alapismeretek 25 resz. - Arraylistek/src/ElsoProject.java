import java.util.ArrayList;

public class ElsoProject {

	public static void main(String[] args) {
		
				
     ArrayList<Animal> animal = new ArrayList<Animal>();
     Cat sziamiau = new Cat("Sziamiau");
     Dog morzsa = new Dog();
     
     animal.add(sziamiau);

     
     Cat cat2 = (Cat) animal.get(0);
     
     cat2.purr();
     
     if(!animal.isEmpty()) {
    	 System.out.println(animal.get(0).getName());
     }


	}

}
