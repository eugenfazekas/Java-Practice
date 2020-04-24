package teszt;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Tortszam egy = new Tortszam(1,2);
		
		Tortszam ketto = new Tortszam(3,4);
		
		System.out.println(egy.equals(ketto));
		
		System.out.println(egy.compareTo(ketto));

		Tortszam []t = {new Tortszam(2,3),new Tortszam(-1,3),new Tortszam(4,5),new Tortszam(4,6)};
		
		System.out.println("t== " +t[0].toString()+t[1].toString()+t[2].toString()+t[3].toString());
		
		Arrays.sort(t);
		
		System.out.println("t== " +t[0].toString()+t[1].toString()+t[2].toString()+t[3].toString());
		
		Integer ii2 = Integer.getInteger("JAVA_RENDSZER2");
		
		System.out.println(ii2);
		
	
	}

}
