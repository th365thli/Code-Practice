package OldProblems;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"

Example 2:

Input: 4
Output: "1211"

 * @author jerryli
 *
 */

public class countAndSay {
	
	public static String countAndSay(int n) {
		if (n==1) {
			return "1";
		}
		
		String prev = countAndSay(n-1);
		int currInt = Character.getNumericValue(prev.charAt(0));
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < prev.length(); i++) {
			if (Character.getNumericValue(prev.charAt(i)) == currInt) {
				count++;
			} else {
				sb.append(count).append(currInt);
				currInt = Character.getNumericValue(prev.charAt(i));
				count = 1;
			}
		}
		sb.append(count).append(prev.charAt(prev.length()-1));
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}

}
