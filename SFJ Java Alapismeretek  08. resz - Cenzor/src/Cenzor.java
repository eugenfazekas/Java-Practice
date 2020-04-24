
public class Cenzor {

	public static void main(String[] args) {
		
String result = cenzor("A kutya nagyon aranyos kutya","kutya","macska");

System.out.println(result);
		
	}
	static String cenzor(String text, String tochange, String toword) {
	
		if(text.contains(tochange)) {
		
		text = text.replaceAll(tochange, toword); }; // lehet csak ennyi is

		return text;
	
}
}
