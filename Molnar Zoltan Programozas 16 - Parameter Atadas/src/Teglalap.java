
public class Teglalap {

	int egyikOldal,masikOldal;
	
	public Teglalap(int a ,int b) {
		egyikOldal = a;
		masikOldal = b;
		
	}
	public Teglalap(Teglalap masik) {
		egyikOldal = masik.egyikOldal;
		masikOldal = masik.masikOldal;
	}
	
	public int kerulet() {
		return 2* (egyikOldal + masikOldal);
	}
	
	public int terulet() {
		return egyikOldal * masikOldal;
	}
}
