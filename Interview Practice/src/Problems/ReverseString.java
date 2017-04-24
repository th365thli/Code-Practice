package Problems;

public class ReverseString {

	public static void main(String[] args) {
		String s = "12345";
		
		String reverse = reverse(s);
		
		System.out.println(s.substring(0, 1));
		
		

	}

	public static String reverse(String s) {
		char[] reverseArray = s.toCharArray();
		for (int i = 0; i < reverseArray.length/2; i++) {
			char temp = reverseArray[i];
			reverseArray[i] = reverseArray[reverseArray.length - i -1];
			reverseArray[reverseArray.length -i -1] = temp;
		}

		return new String(reverseArray);
	}

}
