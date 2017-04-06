package Problems;

public class LongestPalindrome {
	public static String longestPalindrome(String s) {

		if (s.length() == 1) {
			return s;
		}

		String longestP = "";
		for (int i = 0; i < s.length()-1; i++) {
			int len1 = expand(s, i, i); //odd length so left and right starts the same
			int len2 = expand(s, i, i+1); //even length so left and right are adjacent
			int len = Math.max(len1, len2);
			int end = i + len/2;
			int begin = i - (len-1)/2;
			String subString = s.substring(begin, end+1);
			if (subString.length() > longestP.length()) {
				longestP = subString;
			}
		}
		return longestP;
	}

	public static int expand(String s, int l, int r) {
		while(l >= 0 && r < s.length()) {
			if (s.charAt(l) == s.charAt(r)) {
				r++;
				l--;
			}
			else {
				break;
			}
		}
		return r-l-1;
	}

	public static void main(String[] args) {
		String s = "abad";
		System.out.println(longestPalindrome(s));
	}
}