package teszt;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		String s = "public static void main";
		StringTokenizer st = new StringTokenizer(s);
		while(st.hasMoreTokens()) System.out.print(st.nextToken() + ", ");

	}

}
