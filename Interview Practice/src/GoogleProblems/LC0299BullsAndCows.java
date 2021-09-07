package GoogleProblems;

import java.util.HashMap;
import java.util.HashSet;

public class LC0299BullsAndCows {

	public static String getHint(String secret, String guess) {

		int bulls = 0;
		int cows = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		HashSet<Integer> skip = new HashSet<Integer>();

		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				skip.add(i);
				bulls++;
			} else {
				map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
			}
		}

		for (int i = 0; i < guess.length(); i++) {
			if (!skip.contains(i)) {
				if (map.containsKey(guess.charAt(i))) {
					int occ = map.get(guess.charAt(i));
					if (occ == 1) {
						map.remove(guess.charAt(i));
					}
					else if (occ > 1) {
						map.put(guess.charAt(i), occ-1);
					}
					cows++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(bulls).append("A").append(cows).append("B");


		return sb.toString();
		
		//Leetcode's more efficient solution
//		   int bulls = 0;
//		    int cows = 0;
//		    int[] numbers = new int[10];
//		    for (int i = 0; i<secret.length(); i++) {
//		        int s = Character.getNumericValue(secret.charAt(i));
//		        int g = Character.getNumericValue(guess.charAt(i));
//		        if (s == g) bulls++;
//		        else {
//		            if (numbers[s] < 0) cows++;
//		            if (numbers[g] > 0) cows++;
//		            numbers[s] ++;
//		            numbers[g] --;
//		        }
//		    }
//		    return bulls + "A" + cows + "B";

	}


	public static void main(String[] arsgs) {

		String secret = "1807";
		String guess = "7810";

		System.out.println(getHint(secret, guess));


	}

}
