package teszt;

public class Main {

	public static void main(String[] args)  {
	
		Alkalmazott bela = new Alkalmazott();  Alkalmazott.szam = 1;
	
		bela.nev= "Kovacs Bela";
		
		bela.fizetes = 50000;
		
		bela.fiztestEmel(8000);
		
		Alkalmazott anna = new Alkalmazott();
		
		anna.nev = "Szentkiralyi Anna";
		
		anna.fizetes = 40000;
		
		Alkalmazott viky = new Alkalmazott();
		
		Alkalmazott adrien = new Alkalmazott("Adrienn");
		
		adrien.eletkor=59;
		
		System.out.println("Szabadsag:" + adrien.evesSzabadsag());
		
		System.out.println(bela.fizetes);
		
		System.out.println(anna.tobbetKeresMint(bela));
		
		System.out.println(anna.kevesebbetkeressMint(bela));
		
		anna.fiztestEmel(bela);
		
		System.out.println(anna.fizetes);
		
		final Alkalmazott A = new Alkalmazott();
		
		A.fizetes = 35000;
		
		Alkalmazott a,b;
		
		a= new Alkalmazott();
		
		b = a;
		
		a.fizetes = 48000;
		
		System.out.println("b fizetese " + b.fizetes);
		
		System.out.println(viky.Szam);
		
		Alkalmazott.nyugdijkorhataremel();
		
		System.out.println(Alkalmazott.nyugdijkorhatar);
		
		System.out.println(adrien.fizetes);
		
		System.out.println(Fonok.beosztottakSzama);
	}

}
