package Problems;

import java.util.Arrays;

public class LC1806MinimumNumberofOperationsPermutations {

	public static int reinitializePermutation(int n) {

		int res = 0, i = 1;
		while (res == 0 || i > 1) {
			if (i < n / 2)
				i *= 2;
			else
				i = (i - n / 2) * 2 + 1;
			res++;
		}
		return res;

		//	        int[] arr = new int[n];
		//	        int[] perm = new int[n];
		//	        int[] target = new int[n];
		//	        
		//	        for (int i = 0 ; i < n; i++) {
		//	            perm[i] = i;
		//	            target[i] = i;
		//	        }
		//	        
		//	        
		//	      return permute(n, arr, perm, target, 0);


	}


	public static int permute(int n, int[] arr, int[] perm, int[] target, int sum) {

		sum++;

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				arr[i] = perm[i/2];
			}
			else {
				arr[i] = perm[n/2+(i-1)/2];
			}
		}

		if (Arrays.equals(arr, target)) {
			return sum;
		}


		return permute(n, new int[n], arr, target, sum);


	}

	public static void main(String[] args) {

		System.out.println(reinitializePermutation(6));




	}


}
