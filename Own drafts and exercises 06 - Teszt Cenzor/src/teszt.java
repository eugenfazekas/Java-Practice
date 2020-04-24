
public class teszt {

	public static void main(String[] args) {
		
		String result = cenzor("A kutya szep kutya","kutya","macska");

		System.out.println(result);
	}

	static String cenzor(String text, String tochange, String toword) {
		
		
		
		text = text.replaceAll(tochange, toword);
		
	return text;
	}
}
	

 