package GoogleProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC1048LongestStringChain {

	public static HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
	public static  HashMap<String, Integer> longestPaths = new HashMap<String, Integer>();
	public static int longest = 0;

	public static int longestStrChain(String[] words) {

		Arrays.sort(words, (a,b) -> a.length() - b.length());


		for (int i = 0; i < words.length; i++) {
			for (int k = i+1; k < words.length; k++) {
				if (words[k].length() == words[i].length() + 1) {
					if (isPredecessor(words[i], words[k])) {
						if (map.get(words[i]) == null) {
							map.put(words[i], new HashSet<String>());
						}

						map.get(words[i]).add(words[k]);


					}
				}
				else if (words[k].length() > words[i].length() + 1) {
					break;
				}
			}
		}


		for (int i = 0; i < words.length; i++) {
			longest = Math.max(findLongestChain(words[i]), longest);
		}


		return longest;

	}


	public static int findLongestChain(String word) {

		if (longestPaths.containsKey(word)) {
			return longestPaths.get(word);
		}

		int track = 1;
		int localLong = 1;
		if (map.get(word) != null) {
			for (String successors : map.get(word)) {
				localLong = Math.max(track + findLongestChain(successors), localLong);
			}
		}

		longestPaths.put(word, localLong);
		return localLong;



	}



	public static boolean isPredecessor(String shortWord, String longWord) {


		int sCount = 0;
		int lCount = 0;

		while (lCount < longWord.length() && sCount < shortWord.length()) {
			if (shortWord.charAt(sCount) != longWord.charAt(lCount)) {
				lCount++;
			} else {
				sCount++;
				lCount++;    
			}

		}

		if (lCount > sCount + 1) {
			return false;
		}


		return true;        

	}






	public static void main(String[] args) {

		String[] test = {"abcd","dbqca"};

		System.out.println(longestStrChain(test));

	}


}
