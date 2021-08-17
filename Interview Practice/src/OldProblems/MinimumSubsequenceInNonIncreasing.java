package OldProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceInNonIncreasing {

	public static List<Integer> minSubsequence(int[] nums) {

		if (nums.length == 1) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[0]);
			return list;
		}

		int[] sorted = new int[nums.length];
		for (int i = 0; i < sorted.length; i++) {
			sorted[i] = nums[i];
		}

		Arrays.sort(sorted);


		int sum = sorted[0];
		List<Integer> answer = new ArrayList<Integer>();
		int maxpos = sorted.length-1;
		int maxsum = sorted[maxpos];
		answer.add(sorted[maxpos]);
		int minpos = 0;
		while(minpos < maxpos) {
			if (sum >= maxsum ) {
				maxpos--;
				maxsum = maxsum+sorted[maxpos];
				answer.add(sorted[maxpos]);
			} else {
				minpos++;
				sum = sum + sorted[minpos];    
			}
		}



		return answer;


	}
	
	
	public static void main(String args[]) {
		int[] test = {4,4,6,7,7};
		
		System.out.println(minSubsequence(test));
		
	}

}
