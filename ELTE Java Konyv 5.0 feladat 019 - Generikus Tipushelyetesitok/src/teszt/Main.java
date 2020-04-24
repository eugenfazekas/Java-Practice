package teszt;

public class Main {

	public static void main(String[] args) {
		
		//Gen <A> g = max(new Gen<Integer>(1), new Gen<Double>(2.0));
		Gen <?> f = max(new Gen<Integer>(1), new Gen<Double>(2.0));
		Gen <?> h = max(new Gen<Integer>(1), new Gen<Double>(2.0));
		System.out.println(f.toString().length());
		System.out.println(h.toString().length());
		System.out.println(h.toString());
	}

	static Gen <?> max(Gen<?> ga,Gen<?> gb) {
	Object o1 = ga.a ; 
	Object o2 = gb.a ;
	if(o1.toString().length() < o2.toString().length())
		return ga; 
	
		return gb;
		
	}
	
}
