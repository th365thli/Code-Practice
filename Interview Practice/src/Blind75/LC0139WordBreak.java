package Blind75;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC0139WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		return wordBreakRecur(s, new HashSet<>(wordDict), 0);
	}

	private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
		if (start == s.length()) {
			return true;
		}
		for (int end = start + 1; end <= s.length(); end++) {
			if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
				return true;
			}
		}
		return false;
	}
}
