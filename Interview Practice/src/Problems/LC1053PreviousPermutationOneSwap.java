package Problems;

import java.util.Arrays;

public class LC1053PreviousPermutationOneSwap {

	public static int[] prevPermOpt1(int[] arr) {
		
		int tranPoint = arr.length-1;
		for (int i = arr.length-2; i >= 0; i--) {
			if (arr[i] > arr[i+1]) {
				tranPoint = i;
				break;
			}
		}
		
		int validMaxPoint = tranPoint+1;
		for (int i = tranPoint+1; i < arr.length; i++) {
			if (arr[i] < arr[tranPoint] && arr[i] > arr[validMaxPoint]) {
				validMaxPoint = i; 
			}
		}
		
		int temp = arr[tranPoint];
		arr[tranPoint] = arr[validMaxPoint];
		arr[validMaxPoint] = temp;
		

		
		return arr;
	}

	
	public static void main(String[] args) {
		
		int[] test = {1,9,4,6,7};
		
		System.out.println(Arrays.toString(prevPermOpt1(test)));
		
		
		
		
	}



}
