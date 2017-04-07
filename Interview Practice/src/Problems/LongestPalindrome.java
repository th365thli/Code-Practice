package Problems;

public class LongestPalindrome {
	public static String longestPalindromeExpandCenter(String s) {

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

	public static String longestPalindromeDP(String s) {
		String reverse = reverseString(s);
		char[] rArray = reverse.toCharArray();
		char[] sArray = s.toCharArray();
		int sindex= -1;
		int mostCount = 0;
		int[][] dp = new int[s.length()][s.length()];
		String longestP = "";

		for (int i = 0; i < dp[0].length; i++) {
			for (int k = 0; k < dp[0].length; k ++) {
				if (rArray[i] == sArray[k]) {
					if (i==0 || k == 0) {
						dp[i][k] = 1;
					} else {
						dp[i][k] = dp[i-1][k-1] + 1;
					}
					if (dp[i][k] > mostCount) {
						sindex = k;
						mostCount = dp[i][k];
						String substring = s.substring(sindex - (mostCount - 1), sindex+1);
						if (checkPalindrome(substring)) {
							longestP = substring;
						}
					}
				}
			}
		}
		return longestP;
	}

	public static boolean checkPalindrome(String s) {
		char[] sArray = s.toCharArray();
		for (int i = 0; i < sArray.length/2; i++) {
			if (sArray[i] != sArray[sArray.length-i-1]) {
				return false;
			}
		}
		return true;
	}

	public static String reverseString(String s) {
		char[] sArray = s.toCharArray();
		for (int i = 0; i < s.length()/2; i++) {
			char temp = s.charAt(s.length()-i-1);
			sArray[sArray.length-i-1] = s.charAt(i);
			sArray[i] = temp;
		}
		return new String(sArray);
	}

	public static void main(String[] args) {
		String s = "banana";
		System.out.println(longestPalindromeDP(s));
	}
}