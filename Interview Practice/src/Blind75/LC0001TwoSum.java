package Blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC0001TwoSum {


	//The "Trick" is to use a HashMap. Instead of iterating twice through the array,
	//we can leverage the fact a hashmap lookup is roughly O(1) of time. So in the loop,
	//given the current integer, check if the hashmap contains target - currentInteger. 
	//If it does, insert the result. If it doesn't, add to the map {currentInteger: index}
	public static int[] twoSum(int[] nums, int target) {

		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {

				//The problem asks for indices hence why we're
				//inserting i instead of nums[i]
				result[0] = i;
				result[1] = map.get(target-nums[i]);
				return result;
			}


			map.put(nums[i], i);
		}



		return null;
	}

	public static void main(String args[]) {
		int[] test = {2,7,11,15};
		System.out.println(Arrays.toString(twoSum(test, 9)));


	}

}
