package Problems;

import java.util.ArrayList;
import java.util.List;

public class AppendParantheses {
	public static List<String> generateParenthesis(int n) {
		ArrayList<String> combos = new ArrayList<String>();
		appendParantheses("(", n-1, n, combos);

		return combos;

	}

	public static void appendParantheses(String s, int openCount, int closeCount, List<String> combos) {

		if (closeCount == 0 && openCount == 0) {
			combos.add(s);
			return;
		}


		if (openCount == 0) {
			s = s+")";
			appendParantheses(s, 0, closeCount-1, combos);
			return;
		}

		if (closeCount-1 >= openCount){
			appendParantheses(s+")", openCount, closeCount-1, combos);
		}

		appendParantheses(s + "(", openCount-1, closeCount, combos);

	}
	
	public static void main(String[] args) {
		List<String> combos = generateParenthesis(3);
		
		for (String s : combos) {
			System.out.println(s);
		}
	}
	
}
