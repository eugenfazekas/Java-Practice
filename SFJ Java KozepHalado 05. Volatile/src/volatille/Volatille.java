package volatille;

import java.util.Scanner;

class Tasker extends Thread {
	
	private volatile boolean runner = true;
	
	public void run() {
		while(runner) {
			System.out.println("Futok!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	public void kill () {
		this.runner = false;	
		} 
}

public class Volatille {

	public static void main(String[] args) {
		
		Tasker t1 = new Tasker();
		t1.start();
 
		System.out.println("Nyomj Enter-t!");
		Scanner sc = new Scanner(System.in);
		
		sc.hasNextLine();
		t1.kill();
	}

}
