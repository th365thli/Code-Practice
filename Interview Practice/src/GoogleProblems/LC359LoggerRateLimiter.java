package GoogleProblems;

import java.util.HashMap;

//HashMap is nice, but how can we decrease space usage?
//https://leetcode.com/problems/logger-rate-limiter/discuss/391558/Review-of-four-different-solutions%3A-HashMap-Two-Sets-Queue-with-Set-Radix-buckets-(Java-centric)
public class LC359LoggerRateLimiter {

	class Logger {

		HashMap<String, Integer> map;

		/** Initialize your data structure here. */
		public Logger() {
			map = new HashMap<String, Integer>();
		}

		/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
		public boolean shouldPrintMessage(int timestamp, String message) {
			if (!map.containsKey(message)) {
				map.put(message, timestamp);
				return true;
			} else if (timestamp - map.get(message) >= 10) {
				map.put(message, timestamp);
				return true;

			}
			return false;
		}
	}

	/**
	 * Your Logger object will be instantiated and called as such:
	 * Logger obj = new Logger();
	 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
	 */

}
