
public class HelloVilag {

	public static void main(String[] args) {
	
	String eredmeny2 = censor("A kutya nagyon aranyos kutya", "kutya", "macska");
	 
			System.out.println(eredmeny2);
}

	public static String censor ( String text, String a, String b) {
		String eredmeny = text;
		
		while(eredmeny.contains(a)) {
			
			eredmeny = eredmeny.replace(a,b);
		}
		return eredmeny;
	}
	}



