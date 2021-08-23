package GoogleProblems;

import java.util.Arrays;

/*
 * Minimum Difference Between Largest and Smallest Value in Three Moves
 */
public class LC1509MinDiff3Moves {

	//Dumbass sliding window problem. 
	public int minDifference(int[] nums) {

		if (nums.length <= 3) {
			return 0;
		}


		Arrays.sort(nums);
		int min = nums[nums.length-1] - nums[3];
		min = Math.min(min, nums[nums.length-2] - nums[2]);
		min = Math.min(min, nums[nums.length-3] - nums[1]);
		min = Math.min(min, nums[nums.length-4] - nums[0]);

		return min;

	}

}
