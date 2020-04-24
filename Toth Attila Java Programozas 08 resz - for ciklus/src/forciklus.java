
public class forciklus {

	public static void main(String[] args) {
	
		for(int i = 0 ; i < 7; i++) {
				 if( i < 5 )
					 System.out.println("Dietas Kaja");
				 else
					 System.out.println("Szalonna meg sok sor");

	}
		/*
		Dietas Kaja
		Dietas Kaja
		Dietas Kaja
		Dietas Kaja
		Dietas Kaja
		Szalonna meg sok sor
		Szalonna meg sok sor
			 */
	for(int i =0; i < 5; i++) {
		System.out.println("kulso" + i);
		
		for(int y =0 ; y < 2 ; y++) {
			System.out.println("belso" + y );
		}
			
	}
}
	/*
	kulso0
belso0
belso1
kulso1
belso0
belso1
kulso2
belso0
belso1
kulso3
belso0
belso1
kulso4
belso0
belso1
	 */
	
	
}