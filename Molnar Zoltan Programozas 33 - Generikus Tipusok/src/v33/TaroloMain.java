package v33;

public class TaroloMain {

	public static void main(String[] args) {
		
		Tarolo<Dolgozo> dolgozok = new Tarolo<>();
		Tarolo<Aru> aruk = new Tarolo<>();
		
		dolgozok.hozzaadasAVegere(new Dolgozo("Pista",35));
		dolgozok.hozzaadasAVegere(new Dolgozo("Kati",23));
		dolgozok.hozzaadasAVegere(new Dolgozo("Jeno",28));
		dolgozok.hozzaadasAVegere(new Dolgozo("Eniko",41));
		aruk.hozzaadasAVegere(new Aru("Tojas"));

		//dolgozok.hozzaadasAVegere(new Integer(5));
		System.out.println(dolgozok);
		atlagEletkor(dolgozok);
	}

	private static void atlagEletkor(Tarolo<Dolgozo> dolgozok) {
		double osszEletkor =0;
		for(int i = 0; i< dolgozok.elemekSzama();i++) {
			Dolgozo dolgozo = dolgozok.nedikElem(i);
			osszEletkor += dolgozo.getEletkor();
		}
		System.out.println("Atlag Eletkor: " + osszEletkor/ dolgozok.elemekSzama());
	}
	
}
