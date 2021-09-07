package Blind75;

public class LC0153MinRotatedSortedArray {
	
	 
    public static int findMin(int[] nums) {
        
        return helper(0, nums.length-1, nums); 
            
            
    }
    
    public static int helper(int start, int end, int[] nums) {
        
        if (start >= end) {
            return nums[start];
        }
        
        
        if (nums[start] < nums[end]) {
            return nums[start];
        } 
        
        int pivot = (start+end)/2;
        
        int left = helper(start, pivot, nums);
        int right = helper(pivot+1, end, nums);
        
        
        return Math.min(left, right);
        
    }
    
    
    public static void main(String[] args) {
    	
    	int[] test = {3,1,2};
    	
    	System.out.println(findMin(test));
    	
    }
    
	
	

}
