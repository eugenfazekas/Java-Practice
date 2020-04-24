package teszt;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		
		System.out.println("Hello  ez itt  a "+ Thread.currentThread().getName() + " Thread ");
		
	}

	
	
}
