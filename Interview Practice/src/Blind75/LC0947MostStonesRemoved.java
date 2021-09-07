package Blind75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

public class LC0947MostStonesRemoved {
	
	public static int removeStones(int[][] stones) {

		HashMap<Pair<Integer, Integer>, Set<Pair<Integer, Integer>>> graph = new HashMap<Pair<Integer, Integer>, Set<Pair<Integer, Integer>>>();
		HashSet<Pair<Integer, Integer>> allStones = new HashSet<Pair<Integer, Integer>>();

		//Build relationship graph
		for (int i = 0; i < stones.length; i++) {
			//for each stone
			Pair<Integer, Integer> stone = new Pair<Integer,Integer>(stones[i][0], stones[i][1]);
	
			for (int k = i+1; k < stones.length; k++) {
				//for every other stone
				if (stones[k][0] == stone.getKey() || stones[k][1] == stone.getValue()) {
					allStones.add(stone);
					Pair<Integer, Integer>  relatedStone = new Pair<Integer, Integer>(stones[k][0], stones[k][1]);
					allStones.add(relatedStone);
					//if stone is removable, add to graph
					if (graph.containsKey(stone)) {
						graph.get(stone).add(relatedStone);
					} else {
						Set<Pair<Integer,Integer>> relate = new HashSet<Pair<Integer,Integer>>();
						relate.add(relatedStone);
						graph.put(stone, relate);
					}
					if (graph.containsKey(relatedStone)) {
						graph.get(relatedStone).add(stone);
					} else {
						Set<Pair<Integer,Integer>> relate = new HashSet<Pair<Integer,Integer>>();
						relate.add(stone);
						graph.put(relatedStone, relate);
					}
				}
			}

		}
		
		return findRemovableStones(graph, allStones, 0);

	

	}


	public static int findRemovableStones(HashMap<Pair<Integer, Integer>, Set<Pair<Integer, Integer>>> graph, 
			HashSet<Pair<Integer, Integer>> allStones, int count) {
		
		int temp = count;
		for (Pair<Integer, Integer> stone : allStones) {
			for(Pair<Integer, Integer> relatedStone : graph.get(stone) ) {
				if (allStones.contains(relatedStone)) {
					HashSet<Pair<Integer, Integer>> newAllStones = (HashSet<Pair<Integer, Integer>>) allStones.clone();
					newAllStones.remove(stone);
					count = Math.max(count, findRemovableStones(graph, newAllStones, temp+1));
				}
			}
			
		}
		
		
		return count;
	

	}

	public static void main(String... args) {
		int[] s1 = {0, 0}; int[] s2 = {0, 2}; int[] s3 = {1, 1}; int[] s4 = {2, 0}; int[] s5 = {2, 2}; //int[] s6 = {2, 2};
		int[][] stones = {s1, s2, s3, s4, s5};

		System.out.println(removeStones(stones));
	}

}
