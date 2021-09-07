package Blind75;

public class LC0198HouseRobber {

	private int[] dp;


	public int rob(int[] nums) {

		int n = nums.length -1;
		dp = new int[nums.length + 1];
		dp[n] = nums[n];

		int profit = 0;

		for (int i = n-1; i >= 0; i--) {

			profit = Math.max(dp[i+1], dp[i+2] + nums[i]);
			dp[i] = profit;

		}

		return dp[0];        

	}

	/* Recursive solution with memoization
    public int rob(int[] nums) {

        dp = new int[100];

        return rob(0, nums);



    }


    public int rob(int start, int[] nums) {


        if (start >= nums.length) {
            return 0;
        }

        if (dp[start] != 0) {
            return dp[start];
        }


        int ans = Math.max(nums[start] + rob(start+2, nums), rob(start+1, nums));
        dp[start] = ans;
        return ans;




    }
	 */


}