

public class Main2 {

	public static void main(String[] args) {
		
		vege:
			for(int tizesek  =1 ; ; tizesek++) {
				for(int egyesek = 0 ;egyesek <= 9; egyesek++ ) {
					int szam  = tizesek * 10 +egyesek;
					int szamjegyekOszege = tizesek + egyesek;
						if(szamjegyekOszege %2 == 0 || szamjegyekOszege %3 == 0) {
							continue;
						}
						if(szam>99) {
							break vege;
						}
					System.out.print(szam + " ");
				}
				System.out.println();
			}

	}

}
