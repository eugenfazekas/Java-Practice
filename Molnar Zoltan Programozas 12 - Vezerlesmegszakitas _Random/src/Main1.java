
public class Main1 {

	public static void main(String[] args) {
	
		int szam1 = 13;
		while(true) {
			//System.out.println(szam);
			szam1 +=13;
			if(szam1 > 100) {
				break;
			}
		}
	
		for(int i = 1 ; i <= 10; i++) {
			for(int j = 1; j <= 10; j++ ) {
				if(i == j ) {
					System.out.print("   X");
					continue;
				}
				System.out.format("%4d", i * j);
		}
			System.out.println();
	}
		for (int i = 0 ; ; i++) {
			int negyzetszam = i*i;
			if(negyzetszam > 100) {
				return;
			}
			System.out.println(i+" x "+ i+" = "+ negyzetszam);
		}
		
	
		
	}

}