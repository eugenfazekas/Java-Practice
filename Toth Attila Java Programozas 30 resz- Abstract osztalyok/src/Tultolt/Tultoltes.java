 package Tultolt;

public class Tultoltes extends ABSosztaly implements AzInterfesz  {

	int x =5;
	int y = 10;
	
	public static void main(String[] args) {
		
	Tultoltes t = new Tultoltes();
	//System.out.println(t.adossze());
	//System.out.println(AzInterfesz.a);
	//System.out.println(AzInterfesz.szorzas(10,5));
	
	System.out.println(t.AszorB());

	}

	@Override
	public void irdki() {
	
		}

	@Override
	public int adossze() {
		return  this.x + this.y ;
			}

	@Override
	public int vondki() {
			return 0;
	}

	@Override
	public int adossze(int x, int y) {
		return  x +  y;
		
	}

	@Override
	int AszorB() {
				return this.x * this.y;
	}

}
//Console 50