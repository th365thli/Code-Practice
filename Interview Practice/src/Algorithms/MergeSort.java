package Algorithms;

import java.util.Arrays;

public class MergeSort {

	public static void sort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			int mid = low + (high - low)/2;
			sort(array, helper, low, mid);
			sort(array, helper, mid+1, high);
			merge(array, helper, low, mid, high);

		}
	}



	public static void merge(int[] array, int[] helper, int low, int mid, int high) {
		//The array will always be partitioned in two halves. Each half will always be sorted (why is this?)
		
		//Copy into helper array
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
	
		int helpLeft = low;
		int helpRight = mid+1;
		int current = low;

		
		//Using the helper array, iterate through both sorted halves and copy the smallest 
		//number into the actual array. 
		while (helpLeft <= mid && helpRight <= high) {
			if (helper[helpLeft] <= helper[helpRight]) {
				array[current] = helper[helpLeft];
				helpLeft++;
			} else {
				array[current] = helper[helpRight];
				helpRight++;
			}

			current++;

		}
		
		//Copy the rest of the left side of the helper array. 
		//There will never be a situation where you need to copy the rest of the right half.
		//Consider situation 1: {20,30,40 || 10, 15, 19}
		//	In this situation, all of the right side will be copied first, leaving the left
		//Situation 2: {10,20,30 || 40, 50, 60}
		//	The left side will be copied first since all of them are smaller than the right. The right
		//	is already sorted, so no need to do anything
		//Situation 3: {30, 40, 50 || 10, 20, 70 }}
		//	Everything is copied except for 70 of the right half. But it's already in the right position so 
		//	nothing needs to happen.
		//In short, if there are remaining items in the right, that means those remaining items were the largest 
		//in the array, and since the right half is already sorted, they don't need to be copied over. 
		while(helpLeft <= mid) {
			array[current] = helper[helpLeft];
			helpLeft++;
			current++;
		}


	}


	public static void main(String[] args) {
		int[] test = {3,2,9,6,5,1,0};
		int[] helper = new int[test.length];
		sort(test, helper, 0, test.length-1);
		
		System.out.println(Arrays.toString(test));
		
	}






}






