package multithreading;

class Tasker1 extends Thread {
	
	public void run() {	
		
		for(int i=0; i<5; i++) {
			System.out.println("Extends " + i);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Tasker2 implements Runnable{

		@Override
		public void run() {
			for(int i=0; i<5; i++) {
				System.out.println("Implements " + i);
				
				try {
					Thread.sleep(750);
				} catch (InterruptedException e) {
			}
		}
	}
}
public class MultiThreading {
		
			public static void main(String[] args) {
			
		Tasker1 run1 = new Tasker1();
		run1.start();
		
		Thread t1 = new Thread(new Tasker2());
		
		t1.start();
	}
}

