package GoogleProblems;

public class LC0027RemoveElement {

	public static int removeElement(int[] nums, int val) {
		int window = 0;
		for (int i = nums.length-1; i >= 0; i--) {
			if (nums[i] == val) {
				for (int k = i; k < i+window; k++) {
					nums[k] = nums[k+1];
				}
				nums[i+window] = -1;
			} 
			else {
				window++;
			}
		}


		return window;
	}

	public static int lcSolution1(int[] nums, int val) {

		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;

	}

	public static int lcSolution2(int[] nums, int val) {

		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				// reduce array size by one
				n--;
			} else {
				i++;
			}
		}
		return n;

	}



	public static void main(String[] args) {

		int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
		System.out.println(lcSolution1(nums, 2));


	}

}
