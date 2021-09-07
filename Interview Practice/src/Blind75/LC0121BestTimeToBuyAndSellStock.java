package Blind75;

public class LC0121BestTimeToBuyAndSellStock {


	public static int maxProfit(int prices[]) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			}
			else {
				max = Math.max(max, prices[i] - min);
			}

		}

		return max;


	}

	public static void main(String[] args) {

		int[] prices = {7,1,5,3,6,4};

		System.out.println(maxProfit(prices));


	}

}
