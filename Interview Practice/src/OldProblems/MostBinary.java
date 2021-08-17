package OldProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MostBinary {

	/*
	 * Complete the function below.
	 */

	public static int[] rearrange(int[] elements) {
		Arrays.sort(elements);
		HashMap<Integer,ArrayList<Integer>> mapOfOnes = new HashMap<Integer,ArrayList<Integer>>();
		HashSet<Integer> foundNumbers = new HashSet<Integer>();
		for (int i =0; i <elements.length; i++) {
			String binary = Integer.toBinaryString(elements[i]);
			int count = 0;
			for (int k = 0; k<binary.length(); k++) {
				if (binary.charAt(k) == '1') {
					count++;
				}
			}
			if (!foundNumbers.contains(count)) {
				if (mapOfOnes.get(count) == null) {
					ArrayList<Integer> listBin = new ArrayList<Integer>();
					listBin.add(elements[i]);
					mapOfOnes.put(count, listBin);
				} else {
					mapOfOnes.get(count).add(elements[i]);
				}
			}
		}

		Set<Integer> keySet =  mapOfOnes.keySet();
		List<Integer> sortedList = new ArrayList<Integer>(keySet);
		Collections.sort(sortedList);
		ArrayList<Integer> finalList = new ArrayList<Integer>();
		for(Integer i : sortedList) {
			ArrayList<Integer> subList = mapOfOnes.get(i);
			for (int k = 0; k < subList.size(); k++) {
				finalList.add(subList.get(k));
			}
		}

		int[] finalArray = new int[finalList.size()];
		for (int i = 0; i<finalList.size(); i++) {
			finalArray[i] = finalList.get(i);
		}
		return finalArray;
	}

	public static void main(String[] args) {
		int[] test = new int[]{5, 5, 3, 7, 10 ,14};
		//System.out.println(Arrays.deepToString(rearrange(test)));
	}

}
