package OldProblems;

import java.util.Arrays;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3) {
			return target;
		}
		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2];
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i<nums.length-2; i++) {
			int low = i+1;
			int high = nums.length-1;
			while (low < high) {
				if (nums[low] + nums[high] + nums[i] == target) {
					return target;
				}
				
				if (nums[low]+nums[high]+nums[i] > target) {
					if (Math.abs(target-(nums[low] + nums[high] + nums[i])) < diff) {
						diff = Math.abs(target-(nums[low] + nums[high] + nums[i]));
						closest = nums[low] + nums[high] + nums[i];
					}
					high--;
				} else {
					if (Math.abs(target-(nums[low] + nums[high] + nums[i])) < diff) {
						diff = Math.abs(target-(nums[low] + nums[high] + nums[i]));
						closest = nums[low] + nums[high] + nums[i];
					}
					low++;
				}
			}
		}
		return closest;
	}
	
	public static void main(String[] args) {
		int[] test = new int[]{1,1,1,0};
		System.out.println(threeSumClosest(test, -100));
	}
	
}
