package Problems;

public class MergeSort {
	public static void merge(int[] array, int[] helper, int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		 int helperLeft = low;
		 int helperRight = middle+1;
		 int current = low;
		 
		 while (helperLeft <= middle && helperRight <= high) {
			 if (helper[helperLeft] <= helper[helperRight]) {
				 array[current] = helper[helperLeft];
				 helperLeft++;
			 } else {
				 array[current] = helper[helperRight];
				 helperRight++;
			 }
			 current++;
		 }
		 
		 int remaining = middle - helperLeft;
		 for (int i = 0; i <= remaining; i++) {
			 array[current + i] = helper[helperLeft + i];
		 }
		
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[]{3,6,4};
		int[] helper = new int[5];
		merge(nums, helper, 0, 1, 2);
	}
	

}
