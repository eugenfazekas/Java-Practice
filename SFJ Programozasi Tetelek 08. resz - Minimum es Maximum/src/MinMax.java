
public class MinMax {

	public static void main(String[] args) {
	
		int[] tomb = {1,2,3,4,5,6,7,8,9,10};
	 
		int min = tomb[0];

		int max = 0 ;
		
		for(int i = 0; i < tomb.length; i++ )
			if(tomb[i] <  min)
			min = tomb[i];
		System.out.println(min);
		
		for(int i = 0; i < tomb.length; i++ )
			if(tomb[i] >  max)
			max = tomb[i];
		System.out.println(max);
		
	}// 1

}// 10
