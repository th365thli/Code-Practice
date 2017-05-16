package Problems;

public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {
		int n = nums.length;
		if(n < 2) return n;
		int x = 1;
		for(int i = 1; i < n; ++i)  {
			if(nums[i] != nums[i-1]) {
				nums[x] = nums[i];
				x=x+1;
			}
		}
		return x;
	}


	public static void main(String[] args) {
		int[] nums = new int[]{1,1,2};
		removeDuplicates(nums);
	}
}
