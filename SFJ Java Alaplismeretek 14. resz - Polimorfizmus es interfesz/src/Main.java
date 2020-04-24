
public class Main {

	public static void main(String[] args) {
	 
		Cat macska = new Cat();
		
		Cat macska2 = new Cat();
				
		macska.setName("Tom");
		
		macska.setWeight(4);
		
		macska.cuddle();
		
		macska2.setName("Jerry");
		
		macska2.setWeight(4);
		
		System.out.println(macska.getName());
		System.out.println(macska.getWeight());
		System.out.println(macska2.getWeight());
		System.out.println(macska2.getName());
		
	}

}
