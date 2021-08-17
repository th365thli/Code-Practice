package OldProblems;

import java.util.Arrays;

public class SumArray {
	
	/**
	 * Sum all integers in array
	 * @param numbers
	 * @return
	 */
	static int summation(int[] numbers) {
		int low = 0;
		int high = numbers.length-1;

		int sum = 0;
		while (low <= high) {
			sum = sum + numbers[low];
			low++;
			sum = sum + numbers[high];
			high--;
		}

		return sum;

	}
	
	/**
	 * Only sum unique integers in array
	 * @param numbers
	 * @return
	 */
	static int summationNoDuplicate(int[] numbers) {
		Arrays.sort(numbers);

		int low = 0;
		int high = numbers.length-1;

		int sum = 0;
		while (low <= high) {
			while (numbers[low] == numbers[low+1]) {
				low++;
			} 
			sum = sum + numbers[low];
		
			if (low >= high) {
				break;
			}
			
			while (numbers[high] == numbers[high-1]) {
				high--;
			} 
			sum = sum + numbers[high];
			low++; high--;
		}

		return sum;

	}

	public static void main(String[] args) {
		System.out.println(summationNoDuplicate(new int[]{5,1,2,3,2,2,2,3,4,5,5,5,5}));
	}

}
