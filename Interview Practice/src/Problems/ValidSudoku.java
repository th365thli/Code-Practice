package Problems;

import java.util.HashSet;

public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		HashSet<Character> countedRow = new HashSet<Character>();
		HashSet<Character> countedCol = new HashSet<Character>();
		HashSet<Character> countedBox = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			for (int k = 0; k<9; k++) {
				if (!countedRow.contains(board[i][k])) {
					if (board[i][k] != '.') {
						countedRow.add(board[i][k]);
					}
				} else {
					return false;
				}
				if (!countedCol.contains(board[k][i])) {
					if (board[k][i] != '.') {
						countedCol.add(board[k][i]);
					}
				} else {
					return false;
				}
				if (!countedBox.contains(board[(k/3)+((i/3)*3)][(k%3)+(i%3)*(3)])) {
					if (board[(k/3)+((i/3)*3)][(k%3)+(i%3)*(3)] != '.') {
						countedBox.add(board[(k/3)+((i/3)*3)][(k%3)+(i%3)*(3)]);
					}
				} else {
					return false;
				}
			}
			countedRow.clear();
			countedCol.clear();
			countedBox.clear();
		}



		return true; 
	}

	public static void main(String[] args) {
		char[][] board = new char[][]{{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','3','.','.'},{'.','.','.','1','8','.','.','.','.'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','.','1','.','9','7','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','3','6','.','1','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','2','.'}};

			printBoard(board);

			System.out.println("\n" + isValidSudoku(board));

	}

	public static void printBoard(char[][] board) {
		for (int i = 0; i < 9; i++) {
			System.out.print("\n");
			for (int k = 0; k<9; k++) {
				System.out.print(board[i][k]);
			}
		}
	}
}
