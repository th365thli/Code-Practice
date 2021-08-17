package OldProblems;

import java.util.LinkedList;
import java.util.Queue;

class StringToInt {
	public static int myAtoi(String s) {

		s = s.trim();

		if (s.length()==0) {
			return 0;
		}

		if (s.length()==1) {
			if (Character.isDigit(s.charAt(0))) {
				return (int) Character.getNumericValue(s.charAt(0));
			}
			else {
				return 0;
			}
		}

		boolean negative = false;
		int startIndex = 0;
		int base10 = 0;
		long result = 0;
		int size = 0;
		boolean leadingZero = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		if (s.charAt(0) == '-') {
			negative = true;
			startIndex = 1;
		} 
		else if (s.charAt(0) == '+') {
			startIndex = 1;
		}
		if (Character.isDigit(s.charAt(startIndex))) {
			for (int i = startIndex; i < s.length(); i++) {
				if (Character.isDigit(s.charAt(i))) {
					if (Character.getNumericValue(s.charAt(i)) != 0 ) {
						leadingZero = false;
					} 
					if (!leadingZero) {
						queue.add(Character.getNumericValue(s.charAt(i)));
						base10++;
					}
				} else {
					break;
				}
			}
		}

		if (base10 > 10) {
			if (negative) {
				return -2147483648;
			} else {
				return 2147483647;
			}
		}

		size = base10;
		for (int i = 0; i < size; i++) {
			base10--;
			result = (result + (queue.poll()*((long) Math.pow(10,base10))));
		}

		if (negative) {
			if (result > 2147483647) {
				return -2147483648;
			}
			else { 
				return 0-Math.toIntExact(result);
			}    
		} 

		if (result > 2147483647) {
			return 2147483647;
		}

		return (int) result; 


	}

	public static void main (String[] args) {
		String test = "  000012345678";
		System.out.println(myAtoi(test));
		//System.out.println(Math.pow(2, 31));
	}
}