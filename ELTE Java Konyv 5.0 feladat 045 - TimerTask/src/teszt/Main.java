package teszt;

public class Main {

	
	
	public static void main(String[] args) {
	
		final java.util.Timer timer = new java.util.Timer(); 
		
		timer.scheduleAtFixedRate(new java.util.TimerTask() {
			int i = 5;
			public void run() {
				System.out.println(i--);
				if(i<0) timer.cancel();
			}
		},5000,1000);

	}

}
