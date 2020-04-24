
public class Main {

	public static void main(String[] args) {
	
	GepJarmu trabant = new GepJarmu("Trabant");
	GepJarmu lada  = new GepJarmu("Lada");
	
	System.out.println(trabant.allapot());
	System.out.println(lada.allapot());
	
	trabant.gyorsits();
	lada.indits();
	lada.gyorsits(15.0);
	
	System.out.println(trabant.allapot());
	System.out.println(lada.allapot());
	
	trabant.indits();
	trabant.gyorsits(20.0);
	
	System.out.println(trabant.allapot());
	trabant.lassits(100);
	System.out.println(trabant.allapot());
	
	}

}
