package coin;

public class CoinCombinations {

	public static void main(String[] args) {
		 int [] coins = {1,2};
		 int totalamount = 4 ;
		 
		System.out.println(calculateCombo(coins,totalamount,0));
	}
	
	public static int calculateCombo (int[] coins,int amount, int currentIndex) {
	
		if (amount == 0) {
			System.out.println("Ez egy Combo" );return 1;
		}
		
		if (amount < 0) {
			System.out.println("Ez a negativ amountbol jott ki "+ amount );return 0;
		}
		
		int combos = 0;
		for(int i = currentIndex; i < coins.length; i++) {
			
			if(amount > -5 && coins[i] > -5) {
				System.out.print( "Ez az aktualis Index " + i + " : Ez az aktualis amount  : " + amount  ); System.out.print("  Ez a coin amit  levonunk: " + coins[i]+ "  Ez az amount - coins: "); System.out.println(amount  - coins[i]);
			}
			
//			if(amount > -5 && coins[i] > -5 && currentIndex == 2) {
//				System.out.print("Index 2 : Ez az aktualis amount  : " + amount  ); System.out.print("  Ez a coin amit  levonunk: " + coins[i]+ "  Ez az amount - coins: "); System.out.println(amount  - coins[i]);
//			}
				//			if(currentIndex == 0) {
//			System.out.print("Index 0:" + amount + "-"); System.out.println(coins[i]+" ");
//			}
//			if(&& currentIndex == 1) {
//				System.out.print("Index 1:" + amount + "-"); System.out.println(coins[i]+" ");
//				}
//			if(currentIndex == 2) {
//				System.out.print("Index 2:" + amount + "-"); System.out.println(coins[i]+" ");
//				}
			combos += calculateCombo(coins, amount  - coins[i], i);
			
			}
		System.out.println("Ez az osszesitet Combo " + combos);
			return combos;
			
	}
}
