package GoogleProblems;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;


/*
 * Sort cars by closest to destination. 
 * Then for each car, calculate the time it'll take to reach the destination. 
 * Need to calculate if any car can catch up to previous cars. Meaning we need
 * to keep track of the longest time while iterating down the cars closest to 
 * the destination. If the time is less than the current longest time, that
 * car will catch up to the fleet and we increment fleet count. If not, then
 * it will be a new car fleet and we set current longest time to it's time. 
 */
public class LC0853CarFleet {

	public static int carFleet(int target, int[] pos, int[] speed) {
		Map<Integer, Double> m = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < pos.length; ++i)
			m.put(pos[i], (double)(target - pos[i]) / speed[i]);
		int res = 0; double cur = 0;
		for (double time : m.values()) {
			if (time > cur) {
				cur = time;
				res++;
			}
		}
		return res;
	}


	public static void main(String[] args) {
		int target = 12;
		int[] position = {10,8,0,5,3};
		int[] speed = {2,4,1,1,3};
		System.out.println(carFleet(target, position, speed));

	}




}
