package Tultolt;
// Method overriding -metodus feluliras
public interface AzInterfesz {

	int a = 5; // muszaj konstans erteket adni neki
	int b = 10;
	void irdki();  // nem fejtunk ki methodust Az interfeszbe
	
	int adossze();
	int adossze(int x , int y);
	
	int vondki();
	static int szorzas(int x, int y) {
		return x*y;
		
	}
}
