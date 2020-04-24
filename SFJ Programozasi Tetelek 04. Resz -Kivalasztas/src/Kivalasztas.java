
public class Kivalasztas {

	public static void main(String[] args) {
		 
		int[] tomb = {1,3,5,6,43,8};
		
		int i = 0;
		
		int keresendo = 5;
		
		while(keresendo != tomb[i] && i < tomb.length ) {
			
			i++;
		}
		
		int	eredmeny = i+1 ;
		
		System.out.println(eredmeny);

	}

}
