package Problems;

import java.util.Arrays;

public class LC389FindtheDifference {

	 public char findTheDifference(String s, String t) {
	        
	        char[] sArr = s.toCharArray();
	        char[] tArr = t.toCharArray();
	        
	        Arrays.sort(sArr);
	        Arrays.sort(tArr);
	        
	        for (int i = 0; i < sArr.length; i++) {
	            if (sArr[i] != tArr[i]) {
	                return tArr[i];
	            }
	        }
	        
	        return tArr[tArr.length-1];
	        
	        
	        
	        
	        
	    }
	
	
}
