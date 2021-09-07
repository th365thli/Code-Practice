package Utilities;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMap {
	
	LinkedHashMap<Integer, Integer> cache;
	
	public LRUCacheLinkedHashMap (int capacity) {
		
		cache = new LinkedHashMap<Integer, Integer>(capacity, .75f, true) {
			  @Override
			    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
			        return this.size() > capacity; //must override it if used in a fixed cache
			    }
		};
		

		
	}
	
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    public void set(int key, int value) {
        cache.put(key, value);
    }
	
	

}
