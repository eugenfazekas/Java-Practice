
public class Megszamolas {

	public static void main(String[] args) {
		
		int[] tomb = {3,4,5,7,2,1,10};
		
		int szamlalo = 0;
		
		for(int i = 0 ; i < tomb.length; i++)
			if(tomb[i] > 6 )
				szamlalo++;
		
		System.out.println(szamlalo);

	}

}
