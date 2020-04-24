
public class Main {

	public static void main(String[] args) {
	
		int nagyitasAranya = 2;
		int  egyikTeglalapSorszama = 1, masikTeglalapSorszama = 2;
		
		Teglalap egyikTeglalap = new Teglalap(20,50);
		Teglalap masikTeglalap = new Teglalap(egyikTeglalap);
		
		kiirat(egyikTeglalapSorszama,egyikTeglalap);
		kiirat(masikTeglalapSorszama,masikTeglalap);
		System.out.println("Sorszam1: "+ egyikTeglalapSorszama);
		System.out.println("Teglalap1: " + egyikTeglalap.egyikOldal+ "," + egyikTeglalap.masikOldal);
		
		nagyit(egyikTeglalap,nagyitasAranya);
		//nagyit(masikTeglalap,nagyitasAranya );
		System.out.println("Nagyitas utan!  ");
		kiirat(egyikTeglalapSorszama, egyikTeglalap);
		kiirat(masikTeglalapSorszama,masikTeglalap);
		
		
	}
		public static void kiirat(int sorszam, Teglalap teglalap ) {
			
			System.out.println(sorszam + ".) [ "+ teglalap.egyikOldal +  " ," + teglalap.masikOldal + " ]");
			sorszam = 0;
			teglalap = new Teglalap(0,0);
		}
		
		public static void nagyit (Teglalap teglalap,int szorzo) {
			teglalap.egyikOldal = teglalap.egyikOldal * szorzo;
			teglalap.masikOldal = teglalap.masikOldal * szorzo;
		}
}
