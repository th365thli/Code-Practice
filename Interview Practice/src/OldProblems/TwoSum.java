package OldProblems;

import java.util.Arrays;

public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
        
		 for (int i = 0; i < nums.length; i++) {
	            for (int j = i+1; j < nums.length; j++) {
	                if (nums[i] + nums[j] == target) {
	                    return new int[] {i, j};
	                }
	            }
	        }
	        
	        
	        
	        return null;
    }
	
	public static void main(String args[]) {
		int[] test = {-3,4,3,90};
		System.out.println(Arrays.toString(twoSum(test, 0)));
		
		
	}

}
