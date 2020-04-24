package teszt;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	static final Comparator<Object> hosszusagiSorrend = new Comparator<Object>() {

		@Override
		public int compare(Object o1, Object o2) {
			String s1 = (String) o1;
			String s2 = (String) o2;
			return  s1.length() - s2.length();
		}
		
	};
	
	public static void main(String[] args) {
	
		List<String> parameterek = Arrays.asList(args);
		Collections.sort(parameterek);
		System.out.println("Lexigrafikus sorrend: ");
		System.out.println(parameterek);
		Collections.sort(parameterek,hosszusagiSorrend);
		System.out.println("Hosszusagi sorrend: ");
		System.out.println(parameterek);
	}

}
