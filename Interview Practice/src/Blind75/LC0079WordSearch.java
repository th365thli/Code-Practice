package Blind75;

import Utilities.Util;

class LC0079WordSearch {
    
    public static boolean[][] visited;
    
    public static boolean exist(char[][] board, String word) {
        
        visited = new boolean[board.length][board[0].length];
        
        boolean found = false;
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                if (board[i][k] == word.charAt(0)) {
                    found = search(board, word, 0, i, k);
                    if (found) { return true; }
                }
                visited = new boolean[board.length][board[0].length];
            }
        }
        
        return found;
    }
    
    
    
    public static boolean search(char[][] board, String word, int count, int i, int j) {
    
        
        visited[i][j] = true;
        if (board[i][j] == word.charAt(count)) {
            count++;
        } else {
        	return false;
        }
        if (count == word.length()) {
            return true;
        }
        
        boolean up = false; boolean right = false; boolean down = false; boolean left = false;
        
        if (i > 0 && !visited[i-1][j]) {
            up = search(board, word, count, i-1, j);
        }
        if (i < board.length-1 && !visited[i+1][j]) {
            down = search(board, word, count, i+1, j);
        }
        if ( j < board[i].length-1 && !visited[i][j+1]) {
            right = search(board, word, count, i, j+1);
        }
         if (j > 0 && !visited[i][j-1]) {
            left = search(board, word, count, i, j-1);
        }
        
        
        return (up || right || down || left);
        
    }
    
    public static void main(String... args) {
    	
    	char[] row1 = {'A', 'B', 'C', 'E'};
    	char[] row2 = {'S', 'F', 'C', 'S'};
    	char[] row3 = {'A', 'D', 'E', 'E'};
    	
    	char[][]board = {row1, row2, row3};
    	
    	Util.print2D(board);
    	
    	System.out.println(exist(board, "ABCB"));
    	
    	
    	
    }
    
    
    
}