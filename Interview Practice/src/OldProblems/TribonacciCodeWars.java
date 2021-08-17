package OldProblems;

import java.util.Arrays;

public class TribonacciCodeWars {

	public static double[] tribonacci(double[] s, int n) {
		
		double[] answer = new double[n];
		if (n==0) {
			return new double[0];
		}
		
		if (n<4) {
			for (int i =0; i < n; i++) {
				answer[i] = s[i];
			}
			
			return answer;
		}
		
		
		
		for (int i =0; i < 3; i++) {
			answer[i] = s[i];
		}
		
		for (int i = 3; i < n; i++) {
			answer[i] = answer[i-1] + answer[i-2] + answer[i-3];
		}

		return answer;


	}

	public static void main(String[] args) {
		double[] input = new double[]{1,1,1,3,5,9,17,31,57,105};
		double[] answer = tribonacci(new double[] {15,12,17}, 31);
		
		//System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(answer));
		
	
		
	}




}
