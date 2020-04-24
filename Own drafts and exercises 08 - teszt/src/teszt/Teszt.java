package teszt;

import java.io.IOException;

enum Napok {Hetfo,Kedd,Szerda,Csutortok, Pentek, Szomabat, Vasarnap};

public class Teszt {

    public static void main(String[] args) throws IOException {
    	
    	String a = new String("teszt");
    	
    	String b = "teszt";
    	
    	String[] szinek = new String [] {"egy","ketto"};
    	
    	for(Napok nap : Napok.values())
    	
    	System.out.println(nap);
    	
    	char h = '\u00f4';
    	
    	String e = "tekn\u00f4c";
    	
    	String g = "tekn\u0150c";
    	
    	boolean c = String.valueOf(a) == String.valueOf(b);
    	
    	boolean d = a.equals(b);
    		
    		System.out.println(c);
    		
    		System.out.println(d);
    		
    		System.out.println(e);
    		
    		System.out.println(g);
    		
    		System.out.println("tekn\u00f4c");
    		
    		int f = Viszlat.viszlatint = 1;
    		
    		System.out.println(f);
    		
    		System.out.println(Viszlat.viszlatintertekvisszaadas());
    		
    		Viszlat.fonok.fizetes = 5 ;
    	}
}

