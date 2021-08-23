package Utilities;

public class Util {
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
