package teszt;

public class Verem {
	


	final static public int MERET= 3;
	
	private Object tarolo[] = new Object [MERET];
	
	private int mutato = 0;
	
	public void betesz(Pojo o) throws VeremMegteltException {
	try {
		if (mutato<tarolo.length) tarolo[mutato++] = o;
		
		else throw new VeremMegteltException(o);
	}catch(VeremMegteltException e) {
		System.out.println("Az " + e.miVolt() + " obiektum ne fert a verembe");
	}catch(Exception e) {
		System.out.println("A KOvetkezo hiba tortent " +e);
	}finally {
		System.out.println("A betesz metodus lefutot!");
	}
	
	}
	
	void tarolo () {
		for (int i = 0 ; i< tarolo.length; i++)
			if(tarolo[i] != null)
				System.out.println(tarolo[i].toString());
	}
}


