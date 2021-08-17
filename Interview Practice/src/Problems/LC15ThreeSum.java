package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * Sort the list. Then for each index starting at the beginning, you do TwoSum calculation for the rest of the array
 * -1,-1,0,1,2,4. Start at nums[0] = -1. Then find two numbers in the rest of the array that equals 0-nums[0]
 */
public class LC15ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> sumSet = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length-2; i++) {
			//check if previous number is the same. If so, let the
			//loop increment until they are different. 
			int lo = i+1; 
			int hi = nums.length-1;
			if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
				while (lo < hi) {
					if (nums[lo] + nums[hi] == nums[i]*-1) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[lo]); list.add(nums[hi]); list.add(nums[i]); 
						sumSet.add(list);
						//while loops to make sure you don't add duplicate set
						while (lo < hi && nums[lo] == nums[lo+1]) lo++;
						while (lo < hi && nums[hi] == nums[hi-1]) hi--;
						lo++; hi--;
					}
					else if (nums[lo] + nums[hi] < nums[i]*-1) {
						lo++;
					} else {
						hi--;
					}

				}

			}
		}
		return sumSet;
	}


	public static void main(String[] args) {
		int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
	}

}
