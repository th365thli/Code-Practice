package GoogleProblems;

public class LC0329LongestIncreasingPathinMatrix {

	public static int[][] dp;

	public static int longestIncreasingPath(int[][] matrix) {

		int maxPath = 0;
		int currPath = 0;
		dp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (dp[i][j] == 0) {
					currPath =  move(matrix, i, j);
					if (currPath > maxPath) {
						maxPath = currPath;
					}
				}
			}
		}
		
		return maxPath;

	}


	public static int move(int[][] matrix, int i, int j) {

		if (dp[i][j] != 0) {
			return dp[i][j];
		}

		int left = 1; int right = 1; int up = 1; int down = 1;
		if (i > 0 && matrix[i-1][j] > matrix[i][j]) {
			up = up + move(matrix, i-1, j);
		}
		if (i < matrix.length-1 && matrix[i+1][j] > matrix[i][j]) {
			down = down + move(matrix, i+1, j);
		}
		if (j > 0 && matrix[i][j-1] > matrix[i][j]) {
			left = left + move(matrix, i, j-1);
		}
		if (j < matrix[0].length-1 && matrix[i][j+1] > matrix[i][j]) {
			right = right + move(matrix, i, j+1);
		}

		int max = Math.max(Math.max(left, right), Math.max(up, down));
		dp[i][j] = max;
		return dp[i][j];

	}
	
	
	public static void main(String[] args) {
		int[] row1 = {2,3,4};
		int[] row2 = {1,8,6};
		int[] row3 = {1,9,1};
		
		int[][] matrix = {row1, row2, row3};
		
		System.out.println(longestIncreasingPath(matrix));
		
	}

}
