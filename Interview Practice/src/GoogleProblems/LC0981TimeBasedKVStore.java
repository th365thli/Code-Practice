package GoogleProblems;

import java.util.HashMap;
import java.util.TreeMap;

public class LC0981TimeBasedKVStore {


	public HashMap<String, TreeMap<Integer, String>> map;


	public LC0981TimeBasedKVStore() {
		map = new HashMap<String, TreeMap<Integer, String>>();
	}


	public void set(String key, String value, int timestamp) {
		TreeMap<Integer, String> timeMap; 
		if (!map.containsKey(key)) {
			timeMap = new TreeMap<Integer, String>();
			timeMap.put(timestamp, value);
		} else {
			timeMap = map.get(key);
			timeMap.put(timestamp, value);
		}
		map.put(key, timeMap);
	}

	public String get(String key, int timestamp) {
		if (map.containsKey(key)) {
			TreeMap<Integer, String> timeMap = map.get(key);
			Integer floor = timeMap.floorKey(timestamp);
			if (floor != null) {
				return timeMap.get(floor);
			}
			
		}
		
		return "";

	}
	
	
	public static void main(String[] args) {
		LC0981TimeBasedKVStore time = new LC0981TimeBasedKVStore();
		time.set("love", "high", 10);
		time.set("love", "low", 20);
		System.out.println(time.get("love", 5));
		System.out.println(time.get("love", 15));
		System.out.println(time.get("love", 20));
		System.out.println(time.get("love", 25));
	}
	
}
