package teszt;

public class Verem {
	


	final static public int MERET= 3;
	
	private Object tarolo[] = new Object [MERET];
	
	private int mutato = 0;
	
	public void betesz(Pojo o) throws VeremMegteltException {
	
		if (mutato<tarolo.length) tarolo[mutato++] = o;
		
		else throw new VeremMegteltException(o);
		assert mutato < 5;
	
	}
	
	void tarolo () {
		for (int i = 0 ; i< tarolo.length; i++)
			if(tarolo[i] != null)
				System.out.println(tarolo[i].toString());
	}
}


