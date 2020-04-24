package teszt;

public class Main {

	public static void main(String[] args) {
		teszt(new Gen<Integer>(),
			  new Gen<Integer>(),
			  new Burkolo(),
			  new Gen<Integer>());

	}
	static void teszt(Object o1, Object o2,Object o3,Object o4) {
		Burkolo w = null;
		Gen<Integer> gi =null;
		Gen g = null;
		Gen<?>gq = null;
		
		//if(o1 instanceof Gen<Integer>) gi = (Gen<Integer>) o1;
		if(o2 instanceof Gen)		   g= (Gen) o2;
		if(o3 instanceof Burkolo)	   w = (Burkolo) o3;
		if(o4 instanceof Gen<?>)	   gq =(Gen<?>) o4;
	}
	
}
