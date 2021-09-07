package GoogleProblems;

import java.util.HashSet;

public class LC0128LongestConsecutiveSequence {

	
	//Should revisit this one. Not super intuitive for me
	public static int longestConsecutive(int[] nums) {

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}    

		if (set.size() == 1) {
			return 1;
		}

		int count = 0;
		int maxCount = 0;
		for (int i : set) {
			if (!set.contains(i-1)) {
				int curr = i;
				count = 1;

				while(set.contains(curr+1)) {
					count++;
					curr = curr+1;
				}
			}

			maxCount = Math.max(count, maxCount);

		}

		return maxCount;    
	}



	public static void main(String[] args) {
		int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};

		System.out.println(longestConsecutive(nums));

	}
}
