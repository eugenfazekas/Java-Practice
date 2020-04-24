package teszt;

public class Main {

	public static void main(String[] args)  {
	
	System.out.println(evesSzabadsag());
	
	}
	
	static int[] evesSzabadsag = new int [60]; 
	
	static {
		for(int i = 0;  i< 30; i++) {evesSzabadsag[i] = 20;
		
																									System.out.print("Idik elem: "+i+" "+evesSzabadsag[i]+" ");
																									}
																									System.out.println();
		
		for(int i = 30; i< 40; i++) {evesSzabadsag[i] =evesSzabadsag[i-1]+1;
																									
																									System.out.print("Idik elem: "+i+" "+evesSzabadsag[i]+" ");
																									}
																									System.out.println();
		
		for(int i = 40; i< 50; i++) {evesSzabadsag[i] =evesSzabadsag[i-1]+2;
		
																									System.out.print("Idik elem: "+i+" "+evesSzabadsag[i]+" ");
																									}
																									System.out.println();
		
		for(int i = 50; i< 60; i++) {evesSzabadsag[i] =evesSzabadsag[i-1]+1;
		
																									System.out.print("Idik elem: "+i+" "+evesSzabadsag[i]+" ");
																									}
																									System.out.println();
																									}
	
	 
	static int eletkor =60;
	
	public static int evesSzabadsag() {
		return evesSzabadsag[eletkor < 60 ? eletkor:59];
	}
}
