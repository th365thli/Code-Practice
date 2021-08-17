package Algorithms;

import java.util.Arrays;

public class QuickSort {
	
	public static void quickSort(int[] array, int low, int high) {
		
		if (low >= high) {
			return;
		}
		
		int pivot = array[low];
		int i = low+1;
		int j = high;
		
		//find midpoint and while swapping
		// Why can i = j? Because if i is always less than j, it will
		// incorrectly swap the pivot. Remember, j should always be the 
		// last value lesser than or equal than the pivot. 
		// Consider {1,5}. i = j = 1. arr[i,j] = 5. Pivot = 1; 1 will incorrectly swap with 5
		// if while(i < j). Then j will not be at the last value lesser than or equal than the pivot.
		// We need to be able to go into the while loop such that j will decrement to the pivot
		// so that it can swap with itself. 
		while (i <= j) {
			while(i < array.length && array[i] < pivot) { i++; }
			while(j >= 0 && array[j] > pivot ) { j--; }
			
			
			//Why can i = j?
			//Consider the situation where i = j, but arr[i,j] = pivot
			//This is an infinite loop. i and j never get incremented and the while loop never exits
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;	
				i++;
				j--;
			}
		}
		
		//Switch pivot to midpoint (Why is J the midpoint?)
		//J is the midpoint because it will always be the last value that's smaller than the pivot.
		//This is because 'i' can equal 'j'. It will go into the if condition and swap (doing nothing since
		//it's "swapping" itself. Then it will increment. Thus i end up past the midway point
		int temp = array[j];
		array[j] = pivot;
		array[low] = temp;
		
		
		//Don't need to include j
		quickSort(array, low, j-1);
		quickSort(array, j+1, high);
		
	}
	
	
	public static void main(String[] args) {
		
		int[] test = {6,5,1};
	
		quickSort(test, 0, test.length-1);
		System.out.println(Arrays.toString(test));
		
	}
	
	
	
	
	

}
