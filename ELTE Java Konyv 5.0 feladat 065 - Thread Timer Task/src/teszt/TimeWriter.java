package teszt;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimerTask;

public class TimeWriter extends TimerTask {

	@Override
	public void run() {
		System.out.println(DateFormat.getTimeInstance().format(new Date()));
		
	}
}
