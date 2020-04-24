
public class PrimszamokMetodusok {

	static int[] szamok = new int[100];
	
	public static void main(String[] args) {
		
		for(int i = 0; i< szamok.length; i++) {
			szamok[i] = i;
		
			}
	for(int i = 0; i<szamok.length; i++)
		primszamok(szamok[i]);

	}

	public static void primszamok(int x) {
		
		if(x<2) return;
		
		else if(x == 2 || x == 3) 
			System.out.println(x);
			
			
		for(int n = 2 ; n < x-1 ; n++) {
				if(x % n == 0) 
		return;
		}	
		
		for(int n =2; n < x-1 ; n++) {
				if(x % n !=0) {
					System.out.println(x);
					return;
				}
		}
	}
}
