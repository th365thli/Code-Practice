package GoogleProblems;

import java.util.Stack;

public class LC0394DecodeString {



	public static StringBuilder sb = new StringBuilder();


	public static String decodeStringWithStack(String s) {
		
		StringBuilder nestSb = new StringBuilder();
		StringBuilder nestSb2 = new StringBuilder();

		Stack<Character> stack = new Stack<>();
		//Stack<Character> kstack = new Stack<>();
		Character c = 0;
		double k = 0;
		int digitCount = 0;
		String answer = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ']') {
				stack.push(s.charAt(i));
			} else {
				while(stack.size() > 0) {
					c = stack.pop();
					if (c == '[') {
						break;
					}
					nestSb.append(c);
				}
				while (stack.size() > 0) {
					c = stack.peek();
					if (Character.isDigit(c)) {
						k = k + Math.pow(10, (double) digitCount) * Character.getNumericValue(c);
						digitCount++;
						stack.pop();
					} else {
						break;
					}
				}
				for (int z = 0; z < k; z++) {
					nestSb2.append(nestSb.toString());
				}
				answer = nestSb2.toString();
				for (int z = answer.length()-1; z >= 0; z--) {
					stack.push(answer.charAt(z));
				}
				k = 0;
				digitCount =0;
				nestSb.setLength(0);
				nestSb2.setLength(0);
			}
			
		}
		
		while (stack.size() > 0) {
			sb.append(stack.pop());
		}

		return sb.reverse().toString();
	}







	public static String decodeString(String s) {


		StringBuilder sb = new StringBuilder();

		return nest(s, sb);
		


	}


	public static String nest(String s, StringBuilder sb) {
		if (s.length() == 0) {
			return "";
		}

		//Find parantheses
		int leftP = 0;
		int rightP = 0;
		int k = 1;

		outer:
			for (int i = 0; i < s.length(); i++) {
				if (Character.isDigit(s.charAt(i))) {
					StringBuilder numberBuilder = new StringBuilder();
					numberBuilder.append(s.charAt(i));
					number:
						for (int j = i+1; j< s.length(); j++) {
							if (Character.isDigit(s.charAt(j))) {
								numberBuilder.append(s.charAt(j));
							} else {
								break number;
							}
						}
					k = Integer.parseInt(numberBuilder.toString());
					i = i + numberBuilder.length()-1;
				}
				else if (s.charAt(i) == '[') {
					leftP++;
					for (int j = i+1; j < s.length(); j++) {
						if (s.charAt(j) == '[') {
							leftP++;
						} 
						else if (s.charAt(j) == ']') {
							if (rightP + 1 == leftP) {
								leftP = i;
								rightP = j;
								break outer;
							}  
							rightP++;
						}
					}
				} else {
					sb.append(s.charAt(i));
				}

			}


		if (leftP == 0) {
			return sb.toString();
		}
		StringBuilder newSb = new StringBuilder();
		String newString = nest(s.substring(leftP+1, rightP), newSb);
		for (int i = 0; i < k; i++) {
			sb.append(newString);
		}
		newSb.setLength(0);
		sb.append(nest(s.substring(rightP+1, s.length()), newSb));

		return sb.toString();
	}



	//This was not part of the problem, just an interesting challenge trying to ENCODE rather than decode
	public static String encodeString(String s) {

		int i = 0;
		int k = 0;
		int j = 1;
		String pattern = "";
		String copy = s;

		while (i < s.length()) {
			copy = s.substring(i, s.length());
			while (pattern.length() < copy.length()) {
				pattern = copy.substring(0, j);
				k = findPattern(copy, pattern);
				if (k == 1) {
					j++;
				}
				else {
					break;
				}
			}
			if (k == 1) {
				sb.append(copy.charAt(0));
				i = i+k;
			} else {
				sb.append(k).append("[").append(pattern).append("]");
				i = i+k*pattern.length();
			}
			k = 0;
			j = 1;
			pattern="";
		}    

		return sb.toString();

	}

	public static int findPattern(String s, String pattern) {
		int count = 1;
		while (s.length()/2 >= pattern.length()) {
			for(int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != s.charAt(i+pattern.length())) {
					return count;
				}
			}
			count++;
			s = s.substring(pattern.length(), s.length());
		}
		return count;


	}

	public static void main(String[] args) {

		String test = "3[a]2[bc]";
		System.out.println(decodeStringWithStack(test));


	}





}
