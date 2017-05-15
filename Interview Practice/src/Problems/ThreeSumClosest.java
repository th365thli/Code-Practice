package Problems;

import java.util.Arrays;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] nums, int target) {
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
				while(low<high && nums[low] == nums[low+1]) {
					low++;
				}
				while (low<high && nums[high] == nums[high-1]) {
					high--;
				}
				if (nums[low]+nums[high]+nums[i] > target) {
					high--;
				} else {
					low++;
				}
				if (low >= high) {
					if (target-(nums[low] + nums[high] + nums[i]) < diff) {
						diff = target-(nums[low] + nums[high] + nums[i]);
						closest = nums[low] + nums[high] + nums[i];
					}
				}
			}
		}
		return closest;
	}
	
	public static void main(String[] args) {
		int[] test = new int[]{-1,1,2,-4};
		System.out.println(threeSumClosest(test, 1));
	}
	
}
