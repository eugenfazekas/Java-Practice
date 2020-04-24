package v27;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {

		Object object = new Object();
		printWithNumber(1, object);
		
		Astronaut armstrong = new Astronaut("Neil Armstrong");
		Astronaut aldrin = new Astronaut("Edwin Aldrin");
		Astronaut collins = new Astronaut("Michael Collins");
		Astronaut noname = new Astronaut("John Doe");
		
		printWithNumber(2,armstrong.equals(aldrin));
		
		Astronaut anotherArmstrong = new Astronaut("Neil Armstrong");
		printWithNumber(3,armstrong.equals(anotherArmstrong));
		printWithNumber(4,armstrong == anotherArmstrong);
		
		Spaceship apollo11 = new Spaceship("Nasa",3);
		printWithNumber(5, armstrong.equals(apollo11)); 
		
		printWithNumber(6, noname.hashCode());
		printWithNumber(7, apollo11.hashCode());
		
		printWithNumber(8, "FB ->" + "FB".hashCode());
		printWithNumber(9, "Ea ->" + "Ea".hashCode());
		
		printWithNumber(10, aldrin);
		printWithNumber(11, apollo11);
		
		apollo11.enter(armstrong);
		printWithNumber(12, apollo11);
		
		apollo11.enter(aldrin);
		printWithNumber(13, apollo11);
		
		apollo11.enter(aldrin);
		printWithNumber(14, apollo11);
		
		apollo11.enter(collins);
		printWithNumber(15, apollo11);
		
		apollo11.enter(noname);
		apollo11.exit(noname);
		apollo11.exit(armstrong);
		printWithNumber(16, apollo11);
		
		Spaceship clone = (Spaceship) apollo11.clone();
		printWithNumber(17, clone);
		
		apollo11.swap(0, 1);
		printWithNumber(18, apollo11);
		printWithNumber(19, clone);
	}
	
	public static void printWithNumber(int i, Object o) {
		System.out.println(i+ ".) "+o);
	}

}
