package GoogleProblems;

import Utilities.Util;

//Check leetcode for version that doesn't use global variables
public class LC0695MaxAreaOfIsland {
	
	  public  int maxAreaOfIsland(int[][] grid) {
	        
	        boolean[][] visited = new boolean[grid.length][grid[0].length];
	        int maxSize = 0;
	        
	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[0].length; j++) {
	            	if (i == 3 && j == 8) {
	            		System.out.println("test");
	            	}
	                if (grid[i][j] == 1) {
	                    maxSize = Math.max(maxSize, findIsland(grid, i, j, 1, visited));
	                }
	            }
	        }
	        
	        
	        
	        return maxSize;
	    }
	    
	    
	    
	    public  int findIsland(int[][] grid, int i, int j, int count, boolean[][] visited) {
	        
	       if (visited[i][j] == false) {
	           visited[i][j] = true;
	           
	           	
	            if (i > 0 && grid[i-1][j] == 1) {
	                count = count + findIsland(grid, i-1, j, 1, visited);
	            }
	        
	            if (i < grid.length-1 && grid[i+1][j] == 1) {
	                count = count + findIsland(grid, i+1, j, 1, visited);
	            }
	            if (j > 0 && grid[i][j-1] == 1) {
	                count = count + findIsland(grid, i, j-1, 1, visited);
	            }
	        
	            if (j < grid[0].length-1 && grid[i][j+1] ==1) {
	                count = count +findIsland(grid, i, j+1, 1, visited);
	            
	            }
	           
	           return count;
	        
	       }
	        
	        return 0;
	        
	    }
	    
	    public static void main(String[] args) {
	    	
	    	int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
	    	                       {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
	    	                       {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
	    	
	    	Util.print2D(grid);
	    	
	    	//System.out.println(maxAreaOfIsland(grid));
	    	
	    	
	    	
	    	
	    }
	

}
