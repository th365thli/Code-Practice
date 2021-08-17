package OldProblems;

public class PascalCodeWars {
	public static int[][] pascal(int depth) {
		if (depth == 0) {
			return null;
		} else if (depth == 1) {
			return new int[][] {new int[] {1}};
		} else if (depth == 2) {
			return new int[][] {new int[] {1}, new int[] {1,1}};
		}
		
		
		int[][] triangle = new int[depth][];

		for (int i = 0; i < depth; i++) {
			triangle[i] = new int[i+1];
			triangle[i][0] = 1; triangle[i][triangle[i].length-1] = 1;
		}

		for (int i = 2; i < depth; i++) {
			for (int j = 1; j< triangle[i].length-1; j++) {
				triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
			}
		}

		
		
		return triangle;

	}
	
	public static void main(String[] args) {
		System.out.println(pascal(10));
	
		
	}
}
