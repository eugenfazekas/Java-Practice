
public class Szetvalogatas {

	public static void main(String[] args) {
		
		int[] tomb1 = {1,2,3,4,5,6,7,8,9,10};
		
		int[] tomb2 = new int [10] ;
		
		int[] tomb3 = new int [10];
		
		for(int i = 0 ; i < tomb1.length ; i++) {
					if(tomb1[i] < 5) 
				tomb2[i] = tomb1[i];
					if(tomb2[i] < 5 && tomb2[i] > 0)
					System.out.print(tomb2[i]+" " );
				}
		System.out.println();
		
			for(int i = 0 ; i < tomb1.length ; i++) {
				if(tomb1[i] >= 5) 
				tomb3[i] = tomb1[i];
				if(tomb3[i] >= 5)
				System.out.print(tomb3[i]+ " ");
			}
			
	// 1 2 3 4
	}// 5 6 7 8 9 10
			}
			
		
		
	