
public class Metszet {

	public static void main(String[] args) {
		
		int[] tomb1 = {1,2,3,4,5,6,7,8,9,10,};
		
		int[] tomb2 = {0,2,13,15,17,8,20,10,};
		
		int[] tomb3 = new int [100] ;
		
		for(int i = 0 ; i < tomb1.length ; i++) {
			
			for(int n = 0 ; n < tomb2.length; n++) {
				
				if(tomb1[i] == tomb2[n]) {
					tomb3[i] = tomb1[i];
					System.out.println(tomb3[i]);
				}
			}
		}

	}

} // 2 8 10
