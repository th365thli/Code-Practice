package GoogleProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC1293ShortestPathinGridWithObstacle {

	static int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};


	/*
	 * The "trick" to this problem is that you're really searching k + 1 grids.
	 * For example, if k = 2, then you're searching paths with 0 obstacles, 1 obstacle, and 2 obstacles.
	 * So it's really k number of BFS keeping track of the path. Keeping track of the path was also
	 * tricky for me as well. 
	 * 
	 * Essentially if you're keeping track of the number of steps (or the level) of a BFS, you can do it a couple ways:
	 * In the code below, we use an extra for loop to only iterate through the current set of "neighbors" in the queue. 
	 * For example, our first "neighbor" is {0,0}. So the loop size is 1. Then the neighbors of {0,0} are {1,0} and {0,1}. 
	 * So the loop size is 2. Then the neighbors of {1,0} and {0,1} are ..... 
	 * Each time you finish a loop cycle you finished a "level" of BFS so you can increment the steps.
	 * 
	 * The second way is to use nulls. You add null after each level, then check for it. So if you encounter a null
	 * You increment the level and add another null:
	 * Queue = {a, null}
	 * poll a, add, a.n1 and a.n2 to queue -> Queue = {null, a.n1, a.n2}
	 * poll null, see that it's null, increment level, add another null -> Queue = {a.n1, a.n2. null}
	 * poll a.n1, add it's neighbors -> Queue = {a.n2, null. a.n1.x1, a.n1.x2...}
	 * 
	 * The adding of nulls ensures each level is separated by a null. 
	 * 
	 */
	public static int shortestPathMySolution(int[][] grid, int k) {

		boolean[][][] visited = new boolean[k+1][grid.length][grid[0].length];
		int[] source = {0, 0, 0};
		LinkedList<int[]> queue = new LinkedList<int[]>();
		//Add source node to queue
		queue.offer(source);
		int y = 0; int x =0; int obCount = 0;
		int[] coord = new int[3];
		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			//Why do we use two loops here? Isn't looping through the queue once enough?
			//This loop represents the neighbors of the previous node; We check this first set of neighbors if we reached the destination
			//Once we checked all the neighboring nodes, we then increment steps, and then check the neighbors of 
			//the previous neighbors. 
			//In this case, the first and only "neighbor" is the source, so the the loop only iterates once for the "neighbor"
			//In short, we need this inner for-loop to track steps. One set of neighbors is one step away. 
			for (int i = 0; i < size; i++) {
				// Get node from queue
				coord = queue.poll();
				y = coord[1]; x = coord[2]; obCount = coord[0];
				// if destination has been reached, return steps;
				if (y == grid.length-1 && x == grid[0].length-1) {
					return step;
				}
				// if we haven't visited this node yet:
				if (!visited[obCount][y][x]) {
					//calculate obstacle count
					obCount = obCount + grid[y][x];

					//if we haven't exceeded the obstacles we've seen yet,
					//Visit neighbors
					if (obCount <= k) {
						visited[obCount][y][x] = true;
						if (y > 0) {
							int[] up = {obCount, y-1, x};
							queue.offer(up);
						} 
						if (y < grid.length-1) {
							int[] down = {obCount, y+1, x};
							queue.offer(down);
						}
						if (x > 0) {
							int[] left = {obCount, y, x-1};
							queue.offer(left);
						}
						if (x < grid[0].length-1) {
							int[] right = {obCount, y, x+1};
							queue.offer(right);
						}
						//Don't want to increment step here, otherwise we increment every time we 
						//add neighbors which is really any time we encounter a node that's not visited
						//and not the desintation (a lot). We only increment step AFTER we check the neighbors,
						//NOT when we add them. 
						//step++;
					}
					
				}
				
			}
			//And why do we increment step after the for loop is done?
			//Because the for loop represents neighbors one step away. We need
			//the for loop to help track steps. Once the for loops is exited, that means you
			//know you tracked nodes one step away. 
			step++;
		}
		return -1;
	}





	public static int shortestPathLCSolution2(int[][] grid, int k) {

		int step = 0;
		int m = grid.length;
		int n = grid[0].length;
		int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int[][] seen = new int[m][n]; // min obstacles elimination from (0,0) to (x, y)
		for (int i = 0; i < m; i++) {
			Arrays.fill(seen[i], Integer.MAX_VALUE);
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0, 0, 0});
		seen[0][0] = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				if (cur[0] == m - 1 && cur[1] == n - 1) {
					return step;
				}
				for (int[] dir : DIRS) {
					int x = dir[0] + cur[0];
					int y = dir[1] + cur[1];
					if (x < 0 || x >= m || y < 0 || y >= n) {
						continue;
					}
					int o = grid[x][y] + cur[2];
					if (o >= seen[x][y] || o > k) {
						continue;
					}
					seen[x][y] = o;
					q.offer(new int[]{x, y, o});
				}
			}
			++step;
		}
		return -1;  
	}


	public static int shortestPathLCSolution1(int[][] grid, int k) {
		int n = grid.length;
		int m = grid[0].length;
		Queue<int[]> q = new LinkedList();
		boolean[][][] visited = new boolean[n][m][k+1];
		//The z axis for k is genius, it allows to track multiple paths to the same position. 
		visited[0][0][0] = true;
		q.offer(new int[]{0,0,0});
		int res = 0;
		while(!q.isEmpty()){
			int size = q.size();
			for(int i=0; i<size; i++){
				int[] info = q.poll();
				int r = info[0], c = info[1], curK = info[2];
				if(r==n-1 && c==m-1){
					return res;
				}
				for(int[] dir : dirs){
					int nextR = dir[0] + r;
					int nextC = dir[1] + c;
					int nextK = curK;
					if(nextR>=0 && nextR<n && nextC>=0 && nextC<m){
						if(grid[nextR][nextC]==1){
							nextK++;
						}
						if(nextK<=k && !visited[nextR][nextC][nextK]){
							visited[nextR][nextC][nextK] = true;
							q.offer(new int[]{nextR, nextC, nextK});
						}
					}
				}                
			}
			res++;
		}
		return -1;
	}


	public static void main(String[] args) {

		int[] row1 = {0,1,1,1,1};
		int[] row2 = {0,1,0,0,0};
		int[] row3 = {0,0,0,1,0};
		int[] row4 = {1,1,1,1,1};
		int[] row5 = {1,1,1,1,0};

		int[][] grid = {row1, row2, row3, row4, row5};
		print2D(grid);

		System.out.println(shortestPathMySolution(grid, 2));



	}

	public static void print2D(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.print("\n");
		}
		System.out.println("\n");


	}


}
