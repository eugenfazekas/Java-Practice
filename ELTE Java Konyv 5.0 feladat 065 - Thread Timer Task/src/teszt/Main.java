package teszt;

import java.text.DateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	public static void main(String[] args) {
		
		Timer timer =new Timer();
		
		//timer.scheduleAtFixedRate(new TimeWriter(),0 , 1000);
		timer.schedule(new TimeWriter(), 2000);
		
		try {
			Thread.sleep(15000);
			timer.cancel();
		}catch(InterruptedException e) {
			
		}

	
	}

	

}
