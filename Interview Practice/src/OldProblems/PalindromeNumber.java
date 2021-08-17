package OldProblems;

public class PalindromeNumber {
	public static boolean isPalindrome (int x) {
		if (x >=0 && x < 10) {
			return true;
		}
		Integer intx = (Integer) x;
		String s = intx.toString();
		
		char[] charArray = s.toCharArray();
		for (int i = 0; i<charArray.length/2;i++) {
			char temp = charArray[i];
			charArray[i] = charArray[charArray.length-i-1];
			charArray[charArray.length-i-1] = temp;
		}
		String reverseS = new String(charArray);
		
		if (s.equals(reverseS)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isPalindromeOpt(int x) {
		 if (x<0 || (x!=0 && x%10==0)) return false;
		    int rev = 0;
		    while (x>rev){
		    	rev = rev*10 + x%10;  //construct reverse by adding the mod of x and multiplying the previous number
		    	x = x/10;
		    }
		    return (x==rev || x==rev/10);
	}
	
	public static void main(String[] args) {
		int x = 112343211;
		System.out.println(isPalindrome(x));
	}
}
