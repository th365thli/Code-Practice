package GoogleProblems;

import java.util.ArrayList;
import java.util.List;

public class LC1253Reconstruct2RowBinaryMatrix {

	public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

		//if colsum[i] = 2, you know matrix[0][i] and matrix[1][i] have to be ones
		//if colsum[i] = 0, you know matrix[0][i] and matrix[1][i] have to be zeros
		//Loop through colsum to find the 2s and 0s and assign those first.
		//Can change this to one pass. If it's colsum[i] = 1, and upper is greater than lower, you know
		//that you should set upper first. If lower is greater than upper, you know you should set lower
		//first. Or another way to put it, if  (upper - topSum) is greater than (lower - bottomSum), 
		// set upper first. 
		List<List<Integer>> answer = new ArrayList<List<Integer>>();

		
		int[] topRow = new int[colsum.length];
		int[] bottomRow = new int[colsum.length];

		for (int i = 0; i < colsum.length; i++) {
			if (colsum[i] == 2) {
				topRow[i] = 1;
				bottomRow[i] = 1;
				upper--;
				lower--;
			}
			else if (colsum[i] == 0) {
				topRow[i] = 0;
				bottomRow[i] = 0;
			}
			else {
				if (upper >= lower) {
					topRow[i] = 1;
					upper--;
				} else {
					bottomRow[i] = 1;
					lower--;
				}
			}
		}   
		
		if (upper != 0 || lower != 0) {
			return answer;
		}
		

//		for (int i = 0; i < colsum.length; i++) {
//			if (colsum[i] == 1) {
//				if (topSum < upper) {
//					topRow[i] = 1;
//					topSum++;
//				} else if (bottomSum < lower) {
//					bottomRow[i] = 1;
//					bottomSum++;
//				} else {
//					return answer;
//				}
//			}
//
//		}
//		
//		if (topSum != upper || bottomSum != lower) {
//			return answer;
//		}
		
		
		

		List<Integer> top = new ArrayList<Integer>();
		List<Integer> bottom = new ArrayList<Integer>();
		for (int i = 0; i < colsum.length; i++) {
			top.add(topRow[i]);
			bottom.add(bottomRow[i]);
		}

		
		answer.add(top);
		answer.add(bottom);
		return answer;
	}
	
	public static void main (String[] args) {
		
		
		 int[]colsum = {2,1,2,0,1,0,1,2,0,1};
		 
		 System.out.println(reconstructMatrix(5, 5, colsum));
		
		
	}
	
	

}
