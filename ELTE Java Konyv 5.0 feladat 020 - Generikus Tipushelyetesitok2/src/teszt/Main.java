package teszt;

public class Main {

	public static void main(String[] args) {
		
		//Gen <A> g = max(new Gen<Integer>(1), new Gen<Double>(2.0));
		Gen <?> f = max(new Gen<Integer>(10), new Gen<Double>(2.0));
		Gen <?> h = max(new Gen<Integer>(10), new Gen<Double>(2.0));
		Gen<Integer> e = new Gen <Integer>(8);
		
		System.out.println(f.a.toString());
		System.out.println(e.a.toString());
		
		System.out.println(h.toString().length());
		System.out.println(h.toString());
	}

	static Gen <? extends Number> max(Gen <? extends Number>ga,Gen <? extends Number> gb) {
	Number o1 = ga.a ; 
	Number o2 = gb.a ;
	if(o1.doubleValue() > o2.doubleValue())
		return ga; 
	
		return gb;
		
	}
	
}
