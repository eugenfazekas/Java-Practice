package teszt;

public class Main {

	public static void main(String[] args) {
		
	double PI;
	double E;
	double e = Double.MAX_VALUE;
	double f = Double.MIN_VALUE;
	double a= 3.14;
	double b = 2.71;
    double d = Math.max(a, b); System.out.println(d);
    double g = Math.pow(2, 100);
    
    Math.cos(a);
    Math.toDegrees(a);
    Math.toDegrees(a);
    
    System.out.println("ceil(3.14) == "+Math.ceil(3.14));
    System.out.println("floor(3.14) == "+Math.floor(3.14));
    System.out.println("rint(3.14) == "+Math.rint(3.14));
    System.out.println("rint(4.5) == "+Math.rint(4.5));
    System.out.println("pow(2,100) == "+ g);
    System.out.println("round(pow(2,100)) == "+Math.round(g));
    
	}

}
