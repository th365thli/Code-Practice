package Blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC0347TopKFrequent {

	public static int[] topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> map.get(b) - map.get(a));


		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		for (Integer i : map.keySet()) {
			queue.offer(i);
		}


		int[] freq = new int[k];    
		while (k > 0) {
			freq[freq.length-k] = queue.poll();
			k--;
		}


		return freq;

	}




	public static void main(String[] args) {

		int[] test = {1,3,2,2,3};
		System.out.println(Arrays.toString(topKFrequent(test, 2)));


	}

}
