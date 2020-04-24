package stringbuffer;

public class Test {

	public static void main(String[] args) {
		
		String a  = "a";
		 String b  = "b";

		 String s = "prefix" + a + "middle"+ b + "end";

		 StringBuffer tmp = new StringBuffer();
		 
		 tmp.append("Karakter");
		 
		 System.out.println(tmp.insert( 8 , " Krisz"));
		 
	}

}
