package GoogleProblems;

import java.util.HashSet;

import Utilities.Robot;
import javafx.util.Pair;


public class LC0489RobotRoomCleaner {
	/**
	 * // This is the robot's control interface.
	 * // You should not implement it, or speculate about its implementation
	 * interface Robot {
	 *     // Returns true if the cell in front is open and robot moves into the cell.
	 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
	 *     public boolean move();
	 *
	 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
	 *     // Each turn will be 90 degrees.
	 *     public void turnLeft();
	 *     public void turnRight();
	 *
	 *     // Clean the current cell.
	 *     public void clean();
	 * }
	 */

	class Solution {
	    HashSet<Pair<Integer, Integer>> coord = new HashSet<Pair<Integer, Integer>>();
	    int[] up = {-1, 0}; int[] right = {0, 1}; int[] down = {1, 0}; int[] left = {0, -1};
	    int[][] directions = {up, right, down, left};
	    
	    public void cleanRoom(Robot robot) {
	        
	        backTrack(robot, new int[] {0, 0}, 0);
	           
	    }
	    
	    
	    
	    
	    public void backTrack(Robot robot, int[] curr, int dir) {
	        
	        coord.add(new Pair(curr[0], curr[1]));
	        robot.clean();
	        
	        
	        for (int i = 0; i < directions.length; i++) {
	            int newDir = (dir + i) % 4;
	            int[] direction = directions[newDir];
	            int[] newCurr = {direction[0] + curr[0], direction[1] + curr[1]};
	            if (!coord.contains(new Pair(newCurr[0], newCurr[1])) && robot.move() ) {
	                backTrack(robot, newCurr, newDir);
	                moveBack(robot);
	            }
	            robot.turnRight();
	        }
	            
	            
	        
	        
	    }
	    
	    
	    
	    public void moveBack(Robot robot) {
	        robot.turnLeft();
	        robot.turnLeft();
	        robot.move();
	        robot.turnLeft();
	        robot.turnLeft();
	    }
	    
	    
	  
	}
}
