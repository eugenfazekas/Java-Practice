package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskUnit implements Runnable {
	
	private int id;
	
	public TaskUnit(int id) {
		this.id = id;
	}

	public void run() {
		
		System.out.println("Feladat indult. id:" + id);
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException ex) {
		
		System.out.println("" + ex);
		}
	System.out.println("Feladat elkeszult. id: " + id);
	}
}

public class Executor {

	public static void main(String[] args) throws InterruptedException {
	
		ExecutorService executor =  Executors.newFixedThreadPool(2);

		for(int i=1; i<=5;i++) {
			((java.util.concurrent.ExecutorService) executor).submit(new TaskUnit(i));
		
		}
	executor.shutdown();
	System.out.println("Minden munka ki lett osztva");
	
	executor.awaitTermination(10, TimeUnit.SECONDS);
	System.out.println("Keszen van az osszes munka");
	}

}
