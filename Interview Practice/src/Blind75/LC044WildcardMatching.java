package Blind75;

/**
 * Incomplete
 * @author Jerry
 *
 */
public class LC044WildcardMatching {
	
	private static boolean[][] dp;
	
	public static boolean isMatch(String s, String p) {
		
		dp = new boolean[s.length()][p.length()];


		return helper(s, p, 0 , 0);

	}

	public static boolean helper(String s, String p, int si, int pi) {
		
		
		//If empty space and p = *
		if (si >= s.length() && pi == p.length()-1 && p.charAt(pi) == '*') {
			dp[s.length()-1][pi] = true;
			return true;
		}
		
		//If either overflow no match
		if (si >= s.length() || pi >= p.length()) {
			return false;
		}
		
		//Get DP value
		if (dp[si][pi]) {
			return true;
		}
		
		//If strings are equal return true;
		if (s.substring(si, s.length()).equals(p.substring(pi, p.length()))) {
			dp[si][pi] = true;
			return true;
		}
		
		//If wildcard is last character return true;
		if (pi == p.length()-1 && p.charAt(pi) == '*') {
			dp[si][pi] = true;
			return true;
			
		}

		//If characters are equal or p == ? increment both pointers
		if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
			return helper(s, p, si+1, pi+1);
		}
		
		//If wildcard is found increment one or the other
		if (p.charAt(pi) == '*') {
			return helper(s, p, si+1, pi) || helper(s, p, si, pi+1);
		}

		return false;

	}




	public static void main(String[] args) {

		String s = "acdcb";
		String p = "a*c?b";

		System.out.println(isMatch(s, p));


	}

}
