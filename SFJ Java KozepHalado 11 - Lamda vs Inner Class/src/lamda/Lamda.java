package lamda;

public class Lamda {
	
	public void letsDoThis(int a , Growl g) {
		g.growling(a);
	}
	
	public void observe() {
		letsDoThis(2,a -> {
			System.out.println("A Erteke:" +a);
			System.out.println(this);
		});
	}

	public static void main(String[] args) {

		Lamda lamda = new Lamda();
		lamda.letsDoThis(1, new Growl() {
			
			@Override
			public void growling(int b) {
				System.out.println("A Erteke:" + b);
				System.out.println(this);
			}
			
			@Override
			public String toString() {
				return "Belso referencia";
			}
		});
		
		lamda.observe();
	}
		@Override
		public String toString() {
			return "Kulso referencia";
		
		//		
//		//Anonim Osztaly
//		Thread t1 = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println("FUTOOOK");
//				}
//	});
//
//		Thread t2 = new Thread(()-> System.out.println("FutiFuti"));
//		
//		t1.start();
//		t2.start();
		
}

}
