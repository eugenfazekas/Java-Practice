
public class Main {

	public static void main(String[] args) {
		
		char first = 'a';
		
		int second =2;
		
		String third = "" + second;
		
		double d = 3.5;
		
		third = String.valueOf(d);
		
		Character c = 'c';
		
		test(second);
		System.out.println(third);
		
		Integer it = 2;
		
		String something = it.toString();
		
		System.out.println(something);
	}
public static void test(Integer c) {
	System.out.println(c);
}
}
