
public class Main {

	public static void main(String[] args) {
		
		Human elso = new Human();
		
		Human masodik = new Human();
		
		elso.SetName("Adrien");
		
		masodik.getName();
		
		System.out.println(elso.getName());
		
		System.out.println(masodik.getName());
		
		elso.kiiras();
	
		
		
		System.out.println(elso.getName() == null ? "Ezt Csinald" : "Azt csinald" );
	
	}

	
}
