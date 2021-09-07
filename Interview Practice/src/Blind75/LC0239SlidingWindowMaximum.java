package Blind75;

import java.util.ArrayDeque;
import java.util.Deque;

//https://www.youtube.com/watch?v=DfljaUwZsOk
public class LC0239SlidingWindowMaximum {

	static ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
	static int [] ans;

	public static void clean_deque(int i, int k) {
		// remove indexes of elements not from sliding window
		if (!deq.isEmpty() && deq.getFirst() == i - k)
			deq.removeFirst();

		// remove from deq indexes of all elements 
		// which are smaller than current element nums[i]
		while (!deq.isEmpty() && ans[i] > ans[deq.getLast()])                           deq.removeLast();
	}

	public static  int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (n * k == 0) return new int[0];
		if (k == 1) return nums;

		// init deque and output
		ans = nums;
		int max_idx = 0;
		for (int i = 0; i < k; i++) {
			clean_deque(i, k);
			deq.addLast(i);
			// compute max in nums[:k]
			if (nums[i] > nums[max_idx]) max_idx = i;
		}
		int [] output = new int[n - k + 1];
		output[0] = nums[max_idx];

		// build output
		for (int i  = k; i < n; i++) {
			clean_deque(i, k);
			deq.addLast(i);
			output[i - k + 1] = nums[deq.getFirst()];
		}
		return output;
	}


	public static void main(String[] args) {

		int[] test = {1,3,-1,-3,5,3,6,7};

		System.out.println(maxSlidingWindow(test, 3));



	}

}
