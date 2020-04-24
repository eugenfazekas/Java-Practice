package lamda;

import java.util.ArrayList;

public class Lamda {

	public static void main(String[] args) {
	
		ArrayList<Person> people  = new ArrayList <>();
		
		people.add(new Person (21,"Gyula"));
		people.add(new Person (30,"Kornel"));
		people.add(new Person (28,"Moni"));
		people.add(new Person (29,"Vili"));
		
		//Nevszerinti sorbaalitas
		people.sort(Person.NameComparator);
		//Kor szerinti sorbalaitas
		people.sort((Person p1, Person p2) -> p2.getAge() - p1.getAge());
		
		for(int i=0; i<people.size(); i++)
		System.out.println(people.get(i));
		
		//System.out.println("");
		
		//for(String eugen : people)
			//System.out.println(eugen);
		
		//System.out.println("");
		
		people.forEach(eugen -> System.out.println(eugen.getAge()));
		
		//System.out.println("");
		
		//System.out.println(people);
	}

}
