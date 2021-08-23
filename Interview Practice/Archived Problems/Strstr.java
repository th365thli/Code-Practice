package OldProblems;

public class Strstr {
	public static int strStr(String haystack, String needle) {
		if (needle.isEmpty()) {
			return -1;
		}
		int potIndex = -1;
		for (int i = 0; i <haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				potIndex = i;
				if (needle.length() <= (haystack.length()-i)) {
					for (int k =0; k <needle.length(); k++) {
						if (haystack.charAt(potIndex) != needle.charAt(k)) {
							potIndex=-1;
							break;
						}
						potIndex++;
					}
					if (potIndex != -1) {
						return i;
					} 
			}
		}
	}
	return -1;
}

public static void main(String[] args) {
	String haystack = "mississippi";
	String needle = "issip";
	System.out.println(strStr(haystack, needle));
}

}
