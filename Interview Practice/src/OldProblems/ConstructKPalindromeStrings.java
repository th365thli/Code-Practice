package OldProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ConstructKPalindromeStrings {
	
	/*
	 * Essentially, you're counting unique characters.
	 * If the number of unique characters is greater than
	 * the number of palindromes you need to construct, the
	 * test fails. With palindromes, you're always looking for
	 * pairs. Each palindrom can at most have one unique
	 * string. 
	 */
	public static boolean canConstruct(String s, int k) {
		
		if (k > s.length()) {
			return false;
		}
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
        	if (!map.containsKey(charArray[i])) {
        		map.put(charArray[i], 1);
        	} else {
        		int value = map.get(charArray[i]);
        		map.put(charArray[i], value+1);
        	}
        }
        
        int oddCount = 0;
        for (Character c : map.keySet()) {
        	if (map.get(c) % 2 != 0) {
        		oddCount++;
        	}
        }
        
        if (oddCount <= k ) {
        	return true;
        }
        return false;
        
    }
	
	public static void main(String[] args) {
		
		System.out.println(canConstruct("annabelle", 2));
		
	}
}
