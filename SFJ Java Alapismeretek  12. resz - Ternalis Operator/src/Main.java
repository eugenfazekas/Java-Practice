
public class Main {

	public static void main(String[] args) {
	
		human first = new human ();
		
		first.setname("IStvan");
		first.setAge(18);
		
		System.out.println(first.getname() == null? "Ures" : "Nem ures " + first.getname());
System.out.println(first.getAge());
	}

}
