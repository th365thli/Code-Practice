package Blind75;

public class LC0322CoinChange {

	private static int[] dp;



	public static int coinChange(int[] coins, int amount) {
		dp = new int[amount+1];


		for (int i = 1; i < amount+1; i++) {
			int min = Integer.MAX_VALUE;
			for (int k = 0; k < coins.length; k++) {
				if (i - coins[k] >= 0) {
					if (dp[i-coins[k]] != Integer.MAX_VALUE) {
						min = Math.min(1 + dp[i-coins[k]], min);
					}
				}
			}
			dp[i] = min;
		}    

		if (dp[amount] == Integer.MAX_VALUE) {
			return -1;
		}
		return dp[amount];

	}


	//	  public static int coinChange(int[] coins, int amount) {
	//		  	dp = new int[amount+1];
	//		  	return helper (coins, amount);
	//	        
	//	    }
	//	  
		  public static int helper(int[] coins, int amount) {
			  
			  	if (amount < 0) {
			  		return -1;
			  	}
			  	else if (amount == 0) {
		      		return 0;
		      	}
			  	else if (dp[amount] != 0) {
			  		return dp[amount];
			  	}
		    
		      	int min = Integer.MAX_VALUE;
		        for (int i = 0; i < coins.length; i++) {
		        	int temp = helper(coins, amount - coins[i]);
		        	if (temp > -1) {
		        		temp++;
		        		min = Math.min(min, temp);
		        	}
		        }
		        
		        if (min == Integer.MAX_VALUE) {
		        	return dp[amount] = -1;
		        }
		        return dp[amount] = min;
			  
			  
		  }
	//	  
	//	  
	public static void main(String... args) {
		
		System.out.println(17/10);
		
		int[] test = {1, 2, 5};

		System.out.println(coinChange(test, 11));
	}
}
