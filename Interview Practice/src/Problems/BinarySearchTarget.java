package Problems;

import java.util.Arrays;

public class BinarySearchTarget {
	public static int[] searchRange(int[] nums, int target) {
		int index1 = -1;
		int index2 = index1;
		if (nums.length == 1) {
			if (nums[0] == target) {
				return new int[]{0,0};
			} else {
				return new int[]{index1, index1};
			}
		}
		int low = 0;
		int high = nums.length-1;
		while (low <= high) {
			int mid = (low + high)/2;
			if (nums[mid] == target) {
			    index1 = mid;
			    index2 = mid;
			    int tempLow = mid;
			    int tempHigh = mid;
			    while (tempLow >= 0 || tempHigh <= nums.length-1) {
			        if (tempLow-1 >= 0 && nums[tempLow-1] == target) {
			            index1 = tempLow-1;
			        }
			        if (tempHigh+1 <= nums.length-1 && nums[tempHigh+1] == target) {
			            index2 = tempHigh+1;
			        } 
			        tempLow--; tempHigh++;
			    }
			    return new int[]{index1, index2};
			}
			if (target < nums[mid] && target >= nums[low]) {
				high = mid-1;
			}
			else if (target > nums[mid] && target <= nums[high]) {
				low = mid+1;
			} else {
				return new int[]{index1, index1};
			}
			
		}

		return new int[]{-1,-1};

	}

	public static void main(String[] args) {
		int[] test = new int[]{3,3,3};
		int target = 3;
		System.out.println(Arrays.toString(searchRange(test, target)));
	}
}
