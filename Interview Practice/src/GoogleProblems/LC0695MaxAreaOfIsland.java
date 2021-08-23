package GoogleProblems;

import Utilities.Util;

//Check leetcode for version that doesn't use global variables
public class LC0695MaxAreaOfIsland {
	
	  public  int count = 0;
	  public  int maxCount;
	  public  int[][] grid;
	  public  boolean[][] visited;
	
	  public  int maxAreaOfIsland(int[][] grid) {
	        
	        visited = new boolean[grid.length][grid[0].length];
	        this.grid = grid;
	        
	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[0].length; j++) {
	                if (grid[i][j] == 1) {
	                	findIsland(i, j);
	                    maxCount = Math.max(maxCount, count);
	                    count = 0;
	                }
	            }
	        }
	        
	        
	        
	        return maxCount;
	    }
	    
	    
	    
	    public  void findIsland(int i, int j) {
	        
	       if (grid[i][j]== 1 && visited[i][j] == false) {
	           visited[i][j] = true;
	           count++;
	           	
	            if (i > 0) {
	                findIsland(i-1, j);
	            }
	        
	            if (i < grid.length-1) {
	                findIsland(i+1, j);
	            }
	            if (j > 0 ) {
	                findIsland(i, j-1);
	            }
	        
	            if (j < grid[0].length-1) {
	                findIsland(i, j+1);
	            
	            }
	        
	       }
	        
	        
	    }
	    
	    
	    public static void main(String[] args) {
	    	
	    	int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
	    	                       {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
	    	                       {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
	    	
	    	Util.print2D(grid);
	    	
	    	//System.out.println(maxAreaOfIsland(grid));
	    	
	    	
	    	
	    	
	    }
	

}
