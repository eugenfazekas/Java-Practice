package teszt;

public class VeremMegteltException extends VeremException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Object utolso;
	
	public VeremMegteltException (Object o) {
	
	utolso = o;
	
	}
	
	public Object miVolt() {
		return utolso;
	}
	
}
