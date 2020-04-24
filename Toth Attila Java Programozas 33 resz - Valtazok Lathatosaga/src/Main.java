
public class Main {

	public int szam = 10; 
	
	public static void main(String[] args) {
		{
		float api = 3.14f;	//// api csak itt latszik
		System.out.println(api);
		}
		
		System.out.println(muvelet());
		
		for(int i = 0; i < 5; i++) {  // i csak ezzen a helyen
			System.out.println(i);
		}
	}
public static int muvelet() {
	int a =5;
	int b= 10;  // es b csak itt latszik
	return a+b;
	
}
	}


