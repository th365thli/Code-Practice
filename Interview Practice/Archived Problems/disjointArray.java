package OldProblems;

import java.util.Arrays;

/*
 * Given an array nums, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
 */
public class disjointArray {
	
	public static int partitionDisjoint(int[] nums) {
		
		int[] array1;
		int[] array2;
		int flag1;
		int flag2;
	
		for (int i = 1; i < nums.length; i++ ) {	
			 array1 = Arrays.copyOfRange(nums, 0, i);
			 array2 = Arrays.copyOfRange(nums, i, nums.length);
			 flag1 = array1[0];
			 flag2 = array2[0];
			 for (int k = 0; k < array1.length; k++) {
				 if (array1[k] > flag1) {
					 flag1 = array1[k]; 
				 }
			 }
			 for (int j = 0; j < array2.length; j++) {
				 if (array2[j] < flag2) {
					 flag2 = array2[j];
				 }
			 }
			 if (flag1 <= flag2) {
				 return i;
			 }
			 
		}
        
		return -1;
        
    }
	
	public static void main(String args[]) {
		int[] test = {1,1,1,0,6,12};
		System.out.println(partitionDisjoint(test));
		
		
	}
	
	
	

}
