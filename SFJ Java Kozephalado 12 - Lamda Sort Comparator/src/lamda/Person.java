package lamda;

import java.util.Comparator;

public class Person {

	private int age;
	private String name;
	
	Person() {
		
	}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	public static Comparator<Person> NameComparator = new Comparator<Person> (){
		@Override
		public int compare(Person p1,Person p2) {
			String PersonName1 = p1.getName();
			String PersonName2 = p2.getName();
			
			return PersonName2.compareTo(PersonName1);
		}

};

public static Comparator<Person> AgeComparator = new Comparator<Person> (){
	@Override
	public int compare(Person p1,Person p2) {
		int PersonAge1 = p1.getAge();
		int PersonAge2 = p2.getAge();
		
		return Integer.compare(PersonAge1, PersonAge2);
	}

};

}
