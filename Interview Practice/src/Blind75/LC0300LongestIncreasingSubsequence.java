package Blind75;

public class LC0300LongestIncreasingSubsequence {
	
	   public static int lengthOfLIS(int[] nums) {
		   
		   
		        
		        int[] dp = new int[nums.length];
		        
		        int max = 0;
		        for (int i = nums.length-1; i >= 0; i--) {
		        	int tempMax = 0;
		            for (int j = i+1; j < nums.length; j++) {
		                if (nums[j] > nums[i]) {
		                   tempMax = Math.max(2, dp[j] + 1);
		                   dp[i] = Math.max(dp[i], tempMax);
		                }
		            }
		            max = Math.max(dp[i], max);
		        }
		        
		        
		        return max;
		        
//	        
//	        int[] dp = new int[nums.length];
//	        int localMax = 0;
//	        for (int i = nums.length-2; i >= 0; i--) {
//	           for (int k = i+1; k < nums.length; k++) {
//	               if (nums[k] > nums[i]) {
//	                  localMax = Math.max(localMax, dp[i] + dp[k] + 1);
//	               }
//	           }
//	           dp[i] = localMax;
//	           localMax = 0;
//	        
//	        }
//	        
//	        int max = 0;
//	        for (int i = 0; i < dp.length; i++) {
//	            max = Math.max(dp[i], max);
//	        }
//	        
//	        return max + 1;
	    }
	   
	   
	   public static void main(String[] args) {
		   
		   int[] test = {10,9,2,5,3,7,101,18};
		   
		   System.out.println(lengthOfLIS(test));
		   
		   
	   }
	   
}
