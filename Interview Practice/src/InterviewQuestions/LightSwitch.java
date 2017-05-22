package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * You have a three by three light switch board:
 * |0|0|0|
 * |0|0|0|
 * |0|0|0|
 * You press one button and it flips all the switches adjacent (not diagonal)
 * So if I press <0,0> the board will look like this:
 * |1|1|0|
 * |1|0|0|
 * |0|0|0|
 * 
 * You are given a target board. Assume you start with an empty all "off" board.
 * Find the minimum amount of steps to reach the target board. 
 * 
 * @author jerryli
 *
 */
public class LightSwitch {
	public static HashSet<boolean[][]> previousStates = new HashSet<boolean[][]>();

	public static void main(String[] args) {
		boolean[][] targetBoard = new boolean[][] {{false,false,false},
												   {false,true,false},
			{false,false,false}};

			boolean[][] board = new boolean[][] {{false,false,false},
				{false,false,false},
				{false,false,false}};

				
		performFlip(board, new int[]{0,0});

	}
	
	/**
	 * Recursive method. If board = target board return the steps
	 * Iterate through each position and find the minimum number of steps 
	 * from that position to the target board. 
	 * @param board
	 * @param targetBoard
	 * @param steps
	 * @return
	 */
	public static ArrayList<boolean[][]> play(boolean[][] board, boolean[][] targetBoard, ArrayList<boolean[][]> steps) {
		/*If the board = target board return steps, since it contains
		 *all the steps required to reach this point
		 */
		if (Arrays.deepEquals(board, targetBoard)) {
			return steps;
		}
		
		int minLength = Integer.MAX_VALUE;
		ArrayList<boolean[][]> minSteps = new ArrayList<boolean[][]>();
		for (int i = 0; i<board[0].length; i++) {
			for (int j = 0; j<board[0].length; j++) {
				/* flip the board*/
				performFlip(board, new int[]{i,j});
				/*if we have not encountered this state yet proceed*/
				if (!previousStates.contains(board)) {
					previousStates.add(board);
					/*add this first step*/
					steps.add(board);
					/*then add all the other steps to reach target*/
					steps.addAll(play(board, targetBoard, steps));
					/*if the list of steps is the least amount, sit it to minimum*/
					if (steps.size() < minLength) {
						minSteps = steps;
					}
				}
			}
		}
		
		return minSteps;
		
	}
	
	public static void performFlip(boolean[][] board, int[] coor) {
		
		int i = coor[0]; int j = coor[1];
		board[i][j] = !board[i][j];
		if (i-1 >= 0) {
			board[i-1][j] = !board[i-1][j];
		} 
		if (i+1 < board[0].length) {
			board[i+1][j] = !board[i+1][j];
		}
		
		if (j-1 >= 0) {
			board[i][j-1] = !board[i][j-1];
		} 
		if (j+1 < board[0].length) {
			board[i][j+1] = !board[i][j+1];
		}
			
		
	}





}
