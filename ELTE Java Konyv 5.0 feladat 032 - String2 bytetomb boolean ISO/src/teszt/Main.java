package teszt;

public class Main {

	public static void main(String[] args) {
		
	String s13 = "zűr";
	
	byte bytetomb2[] = null, bytetomb3[] = null;
	
	try {
		bytetomb2 = s13.getBytes("ISO8859_2");
	}catch(Exception e){
		System.out.println("Ismeretlen kodolas");
	}
	
	try {
		bytetomb3 = s13.getBytes("ISO8859_1");
	}catch(Exception e){
		System.out.println("Ismeretlen kodolas");
	}
	System.out.print("EZ a Bytetomb2: ");
	for(int n: bytetomb2)
	System.out.print(n+",");
	
	System.out.println();
	
	System.out.print("EZ a Bytetomb3: ");
	for(int m: bytetomb3)
	System.out.println(m+",");

	char c = s13.charAt(2);
	
	boolean b1 = "alma".equals("Alma");
	
	boolean b2 = "alma".equalsIgnoreCase("ALMA"); 
	
	System.out.println(b1);System.out.println(b2);
	
	}

}
