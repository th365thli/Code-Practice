package Problems;

/**
 * Given a sorted array consisting of only integers where every 
 * element appears twice except for one element which appears once.
 * Find this single element that appears only once.
 * @author Jerry
 *
 */
public class SingleDuplicate {
	public static int singleNonDuplicate(int[] nums) {
		int low = 0;
		int high = nums.length-1;

		while (low < high) {
			if (nums[low] == nums[low+1]) {
				low = low+2;
			} else {
				return nums[low];
			}
			if (nums[high] == nums[high-1]) {
				high = high-2;
			} else {
				return nums[high];
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{3,3,7,7,10,11,11};
		System.out.println(singleNonDuplicate(nums));
	}
}
