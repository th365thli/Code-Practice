package OldProblems;

import java.util.Arrays;

public class GuessHigherLowerNumber {
	
	
	public static int getMoneyAmount(int n) {
		int[][] table = new int[n+1][n+1];
		
        for(int j=2; j<=n; j++){
            for(int i=j-1; i>0; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    int localMax = k + Math.max(table[i][k-1], table[k+1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table[i][j] = i+1==j?i:globalMin;
                print2D(table);
            }
        }
        return table[1][n];
    }

	
	public static void main(String[] args) {
//		int[] row1 = {1,1,1,1,1};
//		int[] row2 = {2,2,2,2,2};
//		int[] row3 = {3,3,3,3,3};
//		int[] row4 = {4,4,4,4,4};
//		int[] row5 = {5,5,5,5,5};
//		
//		int[][] arr = {row1,row2,row3,row4,row5};
//		print2D(arr);

		int test = 10;
		
		System.out.println(getMoneyAmount(test));
		
		
		
	}
	
	public static void print2D(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.print("\n");
		}
		System.out.println("\n");
		
		
	}
	
}
