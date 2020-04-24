import java.util.ArrayList;

public class ElsoProject {

	public static void main(String[] args) {
		
				
		ArrayList<Animal> cats = new ArrayList<Animal>();
		Cat sziamiau = new Cat ("Sziamiau");
		Cat morzsi = new Cat();
	
		cats.add(sziamiau);
		cats.add(morzsi);
		if(!cats.isEmpty())
			System.out.println(cats.get(0).getName());
		
Object o1 = new Object();
Object o2 = new Object();
Object o3 = new Object();

System.out.println(o1.hashCode()+ " " + o2.hashCode()+" " + o3.hashCode());

System.out.println(sziamiau.getClass());

if(cats.get(1) instanceof Cat) {

	Cat cat =  (Cat) cats.get(1);
	
	cat.purr();
	
	
}
cats.get(1).setName("Cica"); 

System.out.println(cats.get(1).toString());


	}

}
