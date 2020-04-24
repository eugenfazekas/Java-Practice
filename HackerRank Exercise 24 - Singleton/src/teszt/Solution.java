package teszt;

public class Solution {

	public static void main(String[] args) {
		
		Singleton one = Singleton.getSingleInstance();
		

	}

}

class Singleton {
	
	private static Singleton single_instance = null;
	
	private Singleton() {
		
	}

	public String str;
	
	public static Singleton getSingleInstance () {
		
		
		single_instance = new Singleton();
		
		return single_instance;
		
	}
	
}

