package Problems;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> sumSet = new ArrayList<List<Integer>>();
		for (int i = 0; i<nums.length-2; i++) {
			//this if statement ensures no duplicate sums
			if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
				int low = i+1;
				int high = nums.length-1;

				//two sum sweep, starting from both ends of the array
				while (low < high) {
					if (nums[low] + nums[high] == nums[i]*-1) {
						sumSet.add(Arrays.asList(nums[i], nums[low], nums[high]));
						//by checking if low is less than high you ensure it won't be array out of bounds
						while (low < high && nums[low+1] == nums[low]) 
							low++;
						while (low < high && nums[high-1] == nums[high])
							high--;
						low++; high--;
					//if the sum isn't found you determine which part of the array to increment
					} else {
						if (nums[low] + nums[high] < nums[i]*-1)
							low++;
						else
							high--;
					}

				}
			}
		}
		return sumSet;
	}

	public static List<List<Integer>> threeSumBruteForce(int[] nums) {
		//Always sort you dipshit
		Arrays.sort(nums);
		List<List<Integer>> sumSet = new ArrayList<List<Integer>>();
		HashSet<Integer> sumsFound = new HashSet<Integer>();
		HashSet<Integer> firstFound = new HashSet<Integer>();
		HashSet<Integer> secondFound = new HashSet<Integer>();
		HashMap<Integer, HashSet<Integer>> foundLists = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			if (!sumsFound.contains(nums[i])) {
				firstFound.clear();
				for (int k = i+1; k < nums.length; k++) {
					if (!firstFound.contains(nums[k])) {
						secondFound.clear();
						for (int j = k+1; j < nums.length; j++) {
							if (-1*nums[i] == nums[k] + nums[j] && !secondFound.contains(nums[j])) {
								List<Integer> set = new ArrayList<Integer>();
								set.add(nums[i]);
								set.add(nums[k]);
								set.add(nums[j]);
								sumsFound.add(nums[i]);
								sumSet.add(set);
								secondFound.add(nums[j]);
							}
						}
					}
					firstFound.add(nums[k]);
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
