
public class Stack {

	public static void main(String[] args) {
	
		int i = 2;
		
		Object obj = new Object();
		
		Stack mem = new Stack(); // ha peldanyositunk , nincs szukseg staticra,
		
		mem.proba(obj);
		
		

	}

	private void proba(Object param) {
		String str = param.toString();
		System.out.println(str);
	}
}
