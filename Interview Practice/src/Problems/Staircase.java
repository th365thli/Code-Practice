package Problems;

import java.util.Scanner;

public class Staircase {
	
	 static void StairCase(int n) {
	        int stepCount = 1;
	        StringBuilder sb = new StringBuilder();
	        for (int i =1; i<=n; i++) {
	            int spaceCount = n-i;
	            while (spaceCount > 0) {
	                sb.append(" ");
	                spaceCount--;
	            }
	            for (int k =0; k < i; k++) {
	                sb.append("#");
	            }
	            System.out.println(sb.toString());
	            sb = new StringBuilder();
	        }

	    }

	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());
        
        StairCase(_n);
        
    }
}
