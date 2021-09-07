package InterviewQuestions;

public class IntToString {
	static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	static String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


	public static String numberToWords(int nums) {

		if (nums == 0) {
			return "Zero";
		}

		return helper(nums);


	}


	public static String helper(int nums) {

		String number = "";
		//billion
		if (nums < 10) {
			number = ones[nums]; 
		}
		else if (nums < 20) {
			number = teens[nums % 10]; 
		}
		else if (nums < 100) {
			number = tens[nums/10] + " " + helper(nums % 10);
		}
		else if (nums < 1000) {
			number = helper(nums/100) + " Hundred " + helper(nums % 100); 
		}
		else if (nums < 10000) {
			number = helper(nums/1000) + " Thousand " + helper(nums % 1000);
		}
		else if (nums < 100000) {
			number = helper(nums/1000) + " Thousand " + helper(nums % 1000); 
		} 
		else if (nums < 1000000) {
			number = helper(nums/1000) + " Thousand " + helper(nums % 1000); 
		}
		else if (nums < 10000000) {
			number = helper(nums/1000000) + " Million " + helper(nums % 1000000); 
		}
		else if (nums < 100000000) {
			number = helper(nums/1000000) + " Million " + helper(nums % 1000000); 
		}
		else if (nums < 1000000000) {
			number = helper(nums/1000000) + " Million " + helper(nums % 1000000); 
		}
		else {
			number = helper(nums/1000000000) + " Billion " + helper(nums % 1000000000);
		}


		return number.trim();




	}

	public static void main(String[] args) {
		System.out.println(numberToWords(21112));



	}
}
