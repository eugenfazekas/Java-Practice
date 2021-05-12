
public abstract class Game {

	abstract void initiliaze();
	abstract void startPlay();
	abstract void endPlay();
	
	public final void play() {		
		initiliaze();
		startPlay();
		endPlay();		
	}
	
}
