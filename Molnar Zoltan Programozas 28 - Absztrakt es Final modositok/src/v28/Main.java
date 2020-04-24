package v28;

public class Main {

	public static void main(String[] args) {
		
		Ingatlan tarsashaz = new TarsashaziLakas(50.0,450_000);
		Ingatlan csaladiHaz = new CsaladiHaz(1500,85,310_000);
		Ingatlan teremgarazs = new Teremgarazs(8,6,1_250_000);
		
		Ingatlan[] nyilvantartas = new Ingatlan [] {tarsashaz,csaladiHaz,teremgarazs};
		
		for(int i = 0 ; i < nyilvantartas.length; i++) {
			System.out.println(nyilvantartas[i]);
		}
		
	}

}
