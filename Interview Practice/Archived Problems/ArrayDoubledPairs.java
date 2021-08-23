package OldProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArrayDoubledPairs {


	public static boolean canReorderDoubled(int[] arr) {

		if (arr.length == 1) {
			return false;
		}

		if (arr.length % 2 == 1) {
			return false;
		}

		int zeroCount = 0;
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		//List<Integer> targetList = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				if (map.containsKey(arr[i])) {
					int value = map.get(arr[i]);
					map.put(arr[i], value+1);
				} else {
					map.put(arr[i], 1);
				}
			} else {
				zeroCount++;
			}
		}
		
		
		if (zeroCount % 2 == 1) {
			return false;
		}

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int target = arr[i] * 2;
				if (map.containsKey(target)) {
					int targOcc = map.get(target);
					if (targOcc > 1) {
						map.put(target, targOcc-1);
					} else {
						map.remove(target);
					}
					int keyOcc = map.get(arr[i]);
					if (keyOcc > 1) {
						map.put(arr[i], keyOcc-1);
					} else {
						map.remove(arr[i]);
					}
				}
			}

		}


		if (map.size() == 0) {
			return true;
		}


		return false;
	}



	public static void main(String args[]) {
		int[] test = {-33,0};
		Arrays.sort(test);
		System.out.println(canReorderDoubled(test));
	}

}
