package OldProblems;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * In this kata, you will write a function that returns the positions and the values of the "peaks" (or local maxima) of a numeric array.

For example, the array arr = [0, 1, 2, 5, 1, 0] has a peak at position 3 with a value of 5 (since arr[3] equals 5).

The output will be returned as a `Map<String,List<integer>> with two key-value pairs: "pos" and "peaks". If there is no peak in the given array, simply return {"pos" => [], "peaks" => []}.

Example: pickPeaks([3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3]) should return {pos: [3, 7], peaks: [6, 3]} (or equivalent in other languages)

All input arrays will be valid integer arrays (although it could still be empty), so you won't need to validate the input.

The first and last elements of the array will not be considered as peaks (in the context of a mathematical function, we don't know what is after and before and therefore, we don't know if it is a peak or not).

Also, beware of plateaus !!! [1, 2, 2, 2, 1] has a peak while [1, 2, 2, 2, 3] does not. In case of a plateau-peak, please only return the position and value of the beginning of the plateau. For example: pickPeaks([1, 2, 2, 2, 1]) returns {pos: [1], peaks: [2]} (or equivalent in other languages)

Have fun!
 * @author Jerry
 *
 */
public class PickPeaks {

	public static Map<String,List<Integer>> getPeaks(int[] arr) {
		
		ArrayList<Integer> pos = new ArrayList<Integer>();
		ArrayList<Integer> peaks = new ArrayList<Integer>();
		int curr = 1;
		int prev = 0;
		int next = curr+1;
		int plateau = -1;
		while (next < arr.length) {
			

		}

		HashMap<String,List<Integer>> maps = new HashMap<String,List<Integer>>();
		maps.put("pos", pos);
		maps.put("peaks", peaks);

		return maps;
	}

	public static void main(String[] args) {
		

		int[] test = new int[] {7, 10, 16, 18, 15, 5, 12, -5, -1, 16, 10, 7, -4, 18, 8, 8, 5, -3, 4, 19, 7, 12, 0, 1, -1, 10};
		getPeaks(test);


	}
}