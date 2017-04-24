package Problems;

import java.util.ArrayList;

public class ReverseInteger {
	public static int reverse(int x) {
		if (x < 10 && x > -1) {
			return x;
		}
		boolean isNegative;
		int reverse = 0;
		if (x < 0) {
			isNegative = true;
		} else {
			isNegative = false;
		}
		ArrayList<Integer> digits = new ArrayList<Integer>();
		int tenFactor = 0;
		while (1 > 0){
			int digit = x % 10;
			digits.add(digit);
			x = x/10;
			if (x == 0){
				break;
			}
			tenFactor++;
		}
		for (int i = 0; i < digits.size(); i++){
			reverse = reverse + (int) Math.pow(10,tenFactor)*digits.get(i);
			tenFactor--;
		}

		//if (isNegative) {
		//	return reverse * -1;
	//	} else {
			return reverse;
		//}
	}
	
	public static void main(String[] args) {
		int num = -123;
		System.out.println(reverse(num));
	}
	
}
