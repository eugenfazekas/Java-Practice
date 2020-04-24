package teszt;

public class Main2 {

	public static void main(String[] args) {
	
		MyThread2 work = new MyThread2();
		
		Thread a = new Thread(work); Thread b = new Thread(work);
		
		a.start(); b.start();

	}

}
