package Problems;

/*
 * This is a retarded question, i thought it was the longest common prefix of any two strings, but it's just all, so trivial
 */
public class LongestCommonPrefix {
	public static String Solution (String[] strs) {
		if(strs == null || strs.length == 0)    return "";
		String pre = strs[0];
		int i = 1;
		while(i < strs.length){
			while(strs[i].indexOf(pre) != 0)
				pre = pre.substring(0,pre.length()-1);
			i++;
		}
		return pre;
	}

	public static void main(String[] args) {
		String[] strs= new String[]{"abcd", "xyz", "abde"};
		System.out.println(Solution(strs));
	}
}
