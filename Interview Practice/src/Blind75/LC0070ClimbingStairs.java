package Blind75;

public class LC0070ClimbingStairs {
	class Solution {
	    public int climbStairs(int n) {
	        
	        if (n == 1) {
	            return 1;
	        }
	        
	        int[] dp = new int[n+1];
	        
	        return climb(n, dp);
	        
	        
	        
	    }
	    
	    
	    public int climb(int n, int[] dp) {
	        
	        if (dp[n] != 0) {
	            return dp[n];
	        }
	        
	        if (n == 2) {
	            dp[n] = 2;
	            return 2;
	        }
	        if (n == 3) {
	            dp[n] = 3;
	            return 3;
	        }
	        
	        dp[n] = climb(n-1, dp) + climb(n-2, dp);
	        
	        return dp[n];
	        
	        
	    }
	}
}
