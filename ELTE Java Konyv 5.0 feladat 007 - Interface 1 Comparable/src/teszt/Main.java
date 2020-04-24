package teszt;

public class Main {

	public static void main(String[] args) {
	
		Hegy[] is = new Hegy[] {new Hegy("Irott-ko",882),new Hegy("Kekes",1014),new Hegy("Janos-Hegy",527),new Hegy("Istalos-Ko",958)};
		Rendez.rendez(is);
		for(int i = 0; i < is.length; ++i)
			System.out.println(is[i]);

	}

}
