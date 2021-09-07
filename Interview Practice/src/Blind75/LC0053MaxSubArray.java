package Blind75;

public class LC0053MaxSubArray {

	public int maxSubArray(int[] nums) {

		if (nums.length ==1) {
			return nums[0];
		}


		int currMax = nums[0];
		int globalMax = nums[0];

		for (int i = 1; i < nums.length; i++ ) {
			currMax = Math.max(nums[i], currMax+nums[i]);
			globalMax = Math.max(currMax, globalMax);

		}

		return globalMax;


	}

}
