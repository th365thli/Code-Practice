package Blind75;

import java.util.HashSet;

public class LC0947MostStonesRemoved {


//	public static int removeStonesDisjointSet(int[][] stones) {
//
//		int[] union = new int[stones.length];
//		Arrays.fill(union, -1);
//
//		for(int i = 0; i < stones.length; i++) {
//			for(int k = i+1 ; k < stones.length; k++) {
//				if (stones[i][0] == stones[k][0] || stones[i][1] == stones[k][1]) {
//					if (union[k] != -1) {
//						union[i] = k;
//					} else {
//						int root = traverseUnion(union, k);
//						union[root] = i;
//					}
//				}
//			}
//		}
//
//		int numOfIslands = 0;
//		for (int i = 0; i < union.length; i++) {
//			if (union[i] == -1) {
//				numOfIslands++;
//			}
//		}
//
//		return stones.length - numOfIslands;
//
//	}
//
//	public static int traverseUnion(int[] union, int point) {
//		if (union[point] == -1) {
//			return point;
//		} 
//		return traverseUnion(union, union[point]);
//
//	}







	public static int removeStones(int[][] stones) {

		HashSet<int[]> visited = new HashSet<int[]>();

		int temp = 0;
		for (int i = 0; i < stones.length; i++) {
			temp = temp + helper(stones, stones[i], visited);
		} 

		return stones.length - temp; 


	}


	public static int helper(int[][] stones, int[] stone, HashSet<int[]> visited) {

		if (!visited.contains(stone)) {
			visited.add(stone);
			for (int i = 0; i < stones.length; i++) {
				if (stones[i][0] == stone[0] || stones[i][1] == stone[1]) {
					helper(stones, stones[i], visited);
				}
			}
			return 1;
		} 

		return 0;


	}




	public static void main(String... args) {
		int[] s1 = {0, 1}; int[] s2 = {1, 0}; int[] s3 = {1, 1}; //int[] s4 = {2, 0}; int[] s5 = {2, 2}; //int[] s6 = {2, 2};
		int[][] stones = {s1, s2, s3};//, s4, s5};

		System.out.println(removeStones(stones));
	}

}
