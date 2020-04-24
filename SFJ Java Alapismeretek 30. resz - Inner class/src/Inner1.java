class Outer_Demo {
	
	private int num = 1;
	
	private class Inner_Demo {
		
		private int num2 = 2;
		
		public void print() {
			System.out.println("Ez egy belso osztaly " + num);
		}
	}


void display_Inner () {
	
	Inner_Demo inner = new Inner_Demo();
	inner.print();
}
}
public class Inner1 {

	public static void main(String[] args) {
		
		Outer_Demo outer = new Outer_Demo();
		
		outer.display_Inner();

	}

}
