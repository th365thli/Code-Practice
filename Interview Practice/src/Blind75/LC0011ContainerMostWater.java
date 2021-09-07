package Blind75;

public class LC0011ContainerMostWater {
	
	
	/* Start at the ends. If one side is shorter than the other, move that side. 
	 * You move the shortest because you're limited by the shortest. Even if there is 
	 * a longer side in front of the longest, it makes no difference since you're 
	 * shortest limited. The only way to possibly increase area is if you encounter a longer
	 * side than the shortest. 
	 */
	
    public static int maxArea(int[] height) {
        
    	int max = 0;
        int i = 0;
        int j = height.length-1;
        		
        		
        while (i < j) {
        	max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
        	
        	if (height[i] < height[j]) {
        		i++;
        	} else {
        		j--;
        	}
        	
        }
        
        return max;
        
        
        
    }
    
    public static void main(String[] args) {
    	
    	//int[] test = new int[] {1,8,6,2,5,4,8,3,7};
    	int[] test = new int[] {1,2,4,3};
    	
    	System.out.println(maxArea(test));
    	
    	
    	
    }

}
