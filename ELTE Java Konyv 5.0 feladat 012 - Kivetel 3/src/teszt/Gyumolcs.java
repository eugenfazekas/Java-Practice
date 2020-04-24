package teszt;

public class Gyumolcs extends MyException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 void gyumolcs() {
		try {
		alma();
		}catch(MyException e) {
			System.out.println(e);
		}
	}

	private void alma() throws MyException {
	
		korte();
	}

	private void korte() throws MyException {
		naracs();
		
	}

	private void naracs() throws MyException {

		int szam = 0/0;
	}
	
}
