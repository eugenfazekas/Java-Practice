package teszt;

public class Main {

	public static void main(String[] args) {
		
	boolean b8 = "cdebabbaaabbfgh".matches("cde[ab]*fgh"); System.out.println(b8); //true
	boolean b9 = "cdebabbdaabbfgh".matches("cde[ab]*fgh"); System.out.println(b9); //false
	
	String s15 = "Ez egy Sztring";
	System.out.println("s15.length() == " + s15.length());
	
	String s16 = "KicSi vAgY nAgy";
	String kicsi = s16.toLowerCase();
	String nagy = s16.toUpperCase();
	
	String s17 = "arasz";
	String s18 = s17.replace('a', 'e'); //eresz
	
	String s19 = "     a  b  c   ";
	String s20 = s19.trim(); System.out.println(s20);
	
	String s21 = "012345678";
	String s22 = s21.substring(3); // 345678
	String s23 = s21.substring(3,7);
	
	String s24= "egy";
	String s25= "ketto";
	String ss26=s24.concat(s25); //egyketto
	
	}

}
