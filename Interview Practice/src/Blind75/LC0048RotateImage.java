package Blind75;

import Utilities.Util;

public class LC0048RotateImage {

	public static void rotate(int[][] matrix) {


		int temp1; int temp2; int temp3; 
		
		/*
		 * Technically going all the way to the length will work
		 * but there's no need to. The outer loop determines "square" level
		 * we are iterating through. There length/2 number of outer + inner
		 * squares. If it's odd then there will only be 1 element in the last 
		 * square so no need to rotate
		 */
		for (int i = 0; i < matrix.length/2; i++) {
			/*We set the bound at length - i - 1 because the last element is the start of 
			 *the next "side" Otherwise we'd over swapping. 
			 */
			for (int k = i; k < matrix[0].length - i -1; k++) {
				
				//left to top
				temp1 = matrix[i][k];
				matrix[i][k] = matrix[matrix.length-k-1][i];
				
				//top to right
				temp2 = matrix[k][matrix.length-i-1];
				matrix[k][matrix.length-i-1] = temp1;
				
				//right to bottom
				temp3 = matrix[matrix.length-i-1][matrix.length-k-1];
				matrix[matrix.length-i-1][matrix.length-k-1] = temp2;
				
				//bottom to left
				matrix[matrix.length-k-1][i] = temp3;
				
				Util.print2D(matrix);
			
			}
		}
		
	
	}
	
	public static void main(String[] args) {
		
		int[] row1 = {5, 1, 4, 9, 7};
		int[] row2 = {2, 4, 7, 8, 8};
		int[] row3 = {6, 3, 1, 6, 7};
		int[] row4 = {2, 9, 0, 1, 5};
		int[] row5 = {4, 3, 9, 7, 9};
		
		int[][] matrix = {row1, row2, row3, row4, row5};
		
		Util.print2D(matrix);
		rotate(matrix);
	}

}
