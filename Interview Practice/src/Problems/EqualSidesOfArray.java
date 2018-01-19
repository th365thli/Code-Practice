package Problems;

public class EqualSidesOfArray {
	public static int findEvenIndex(int[] arr) {

		int endSum=0;
		int frontSum=0;
		for (int i =1; i < arr.length; i++) {
			endSum = endSum + arr[i];
		}

		if (arr.length < 3) {
			return - 1;
		}

		for (int i =1; i < arr.length-1; i++) {
			frontSum = frontSum + arr[i-1];
			endSum = endSum - arr[i];

			if (frontSum == endSum) {
				return i;
			}
		}

		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 4, 3, 5, -5, 6, -6};
		System.out.println("index: " + findEvenIndex(arr));
		//System.out.println("value: " + arr[findEvenIndex(arr)]);
		
	}
}
