public abstract class AbstractSecurityBuilder<O> implements SecurityBuilder<O>  {

	private O object;
	
	@Override
	public final O build()  {
	
		return object;
	}
}
