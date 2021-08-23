package OldProblems;

import java.util.Stack;

public class ValidParentheses {
	 public static boolean isValid(String s) {
		 Stack<Character> st = new Stack<Character>();
		 
		 for (int i = 0; i < s.length(); i++) {
			 if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				 st.push(s.charAt(i));
			 }
			 if (s.charAt(i) == ')') {
				 if (!st.isEmpty() && st.peek() == '(') {
					 st.pop();
				 }
				 else {
					 return false;
				 }
			 }
			 if (s.charAt(i) == '}') {
				 if (!st.isEmpty() && st.peek() == '{') {
					 st.pop();
				 }
				 else {
					 return false;
				 }
			 }
			 if (s.charAt(i) == ']') {
				 if (!st.isEmpty() && st.peek() == '[') {
					 st.pop();
				 }
				 else {
					 return false;
				 }
			 }
		 }
		 if (st.isEmpty()) {
			 return true;
		 } else {
			 return false;
		 }
	 }
	 
	 public static void main (String[] args) {
		 String s = "[()[]{()}}";
		 System.out.println(isValid(s));
	 }
}
