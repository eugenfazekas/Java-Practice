package mincoin;

public class CoinCombinations {

	public static void main(String[] args) {
		 int [] coins = {1,2};
		 int totalamount = 4;
		 		 System.out.println(calculateMinCombo(coins,totalamount,0));
	}
	
	public static int calculateMinCombo (int[] coins,int amount, int currentIndex) {
	
		if (amount == 0) {
			return 0;
		}
		
		int result = Integer.MAX_VALUE;
		
		for (int i = currentIndex; i < coins.length; i++) {
			if(coins[i] <= amount) {
			
				int subResult = calculateMinCombo(coins,amount - coins[i],i);
				System.out.print("Index: "+i+ " Az osszeg: " + amount +", - Az erme: " + coins[i]+ ", Az osszeg - az erme = "); System.out.print(amount - coins[i]);System.out.println(" Ez a subresult= " + subResult);
				if(subResult != Integer.MAX_VALUE && subResult + 1 < result)
					
					result = subResult + 1; System.out.println("Ez a result: "+ result);
  			}
		}  // System.out.println("Ez a result: "+result);
			return result; 
	}

}
