
public class Main {

	public static void main(String[] args) {
	
		byte egy = 5;
		
		short ketto = egy;
		
		int harom = ketto;
		
		long negy = harom;
		
		float ot = negy;
		
		double hat = ot;
		
		int x = (int) 123L; //castolas long-bol
		
		
		double a = 1;
		
		float b = 2;
		
		System.out.printf("a %f\nb %f\n",a,b);
		
		long nagyszam = 125;     // A 125 jelen esetben egy int , ha a jol oldali szamot azt szeretnenk h Long legyen akkor;
		
		long nagyszam1 = 125L;   // most mar a szamumnk Long!

		System.out.print("Ez egy teszteredmeny: ");
		
		System.out.println(egy);
	}

}
