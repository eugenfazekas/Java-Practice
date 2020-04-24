package teszt;

public class Main {

	public static void main(String[] args) {
		
	int i = 4;
	
	System.out.println("i: "+ i);
	
	System.out.println((new StringBuilder()).append("i: ").append(i).toString());
	
	StringBuilder sb1 = new StringBuilder();
	StringBuilder sb2 = new StringBuilder(9);
	String s1 = "alma";
	StringBuilder sb3 = new StringBuilder(s1);
	
	int hossz = sb3.length(); //4
	int kapacitas = sb3.capacity(); System.out.println(kapacitas);//20 4+16(alma + alap 16)
	
	sb1.ensureCapacity(20); // 2*alap + 2 =34>20 tehat 34 lesz.
	sb3.ensureCapacity(50);  // 2 * 20(sb3.capacity) + 2 = 42 < 50 tehat 50 lesz.
	
	double d =3.54;
	int ii = 100;
	sb2.append(d).append(ii); sb2.insert(4, 'x'); System.out.println(sb2);
	
	char[] karaktertomb = {'m','e','g','g','y'};
	sb2.append(karaktertomb,1,3); System.out.println(sb2);
	
	char regi = sb2.charAt(5); 
	sb2.setCharAt(5,'a');
	char uj = sb2.charAt(5); System.out.println(sb2 ); System.out.println("Sb capacity: "+sb2.capacity());
	sb2.trimToSize(); System.out.println("Sb capacity after trim: "+sb2.capacity());
	
	sb2.setLength(5); System.out.println(sb2);
	}

}
