package teszt;

public class Main {

	public static void main(String[] args) {
		
		Verem <Integer> iv = new Verem <Integer>();
		
		Verem  <Double>dv = new Verem <Double> ();
		
		Verem <Autobusz> av = new Verem <Autobusz>();
		
		try {
			iv.push(5);
			iv.push(6);
			
			dv.push(5.5);
			dv.push(7.7);
			
			av.push(new Autobusz());
			av.push(new Autobusz());
			
			int i = (Integer) iv.pop();
		    System.out.println(i);
		    
			double d = (Double) dv.pop();
		    System.out.println(d);
		    
			Autobusz a = (Autobusz) av.pop();
			System.out.println(a);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		int a = 1;
		
		int b = a++;
		
		//int c = b++;
		
		dv.tomblista();
		
		System.out.println("a:" + a + " b: "+ b+" c: " +" b: "+b);
	}

}
