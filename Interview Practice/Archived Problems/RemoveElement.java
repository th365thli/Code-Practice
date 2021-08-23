package OldProblems;

public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
		int x = 0;
		for(int i = 0; i<nums.length; i++) {
			if (nums[i] != val) {
				nums[x]=nums[i];
				x++;
			}
		}
		return x;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2,3,2,3};
		System.out.println(removeElement(nums, 3));
	}
}
