package OldProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintPermutationsOfArray {


	public static void printArr(int a[], int n)
	{
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	// Generating permutation using Heap Algorithm
	public static void heapPermutation(int a[], int size, int n)
	{
		// if size becomes 1 then prints the obtained
		// permutation
		if (size == 1) {
			printArr(a, n);
			return;
		}

		for (int i = 0; i < size; i++) {
			heapPermutation(a, size - 1, n);

			// if size is odd, swap 0th i.e (first) and
			// (size-1)th i.e (last) element
			if (size % 2 == 1) {
				int temp = a[0];
				a[0] = a[size - 1];
				a[size - 1] = temp;
			}

			// If size is even, swap ith
			// and (size-1)th i.e last element
			else {
				int temp = a[i];
				a[i] = a[size - 1];
				a[size - 1] = temp;
			}
		}
	}

	// Driver code
	public static void main(String args[])
	{

		int a[] = { 1, 2, 3, 4, 5 };
		heapPermutation(a, 5, 3);
	}
}

// This code has been contributed by Amit Khandelwal.





