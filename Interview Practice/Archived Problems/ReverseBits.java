package OldProblems;

public class ReverseBits {
	  public static int[] DataReverse(int[] data) {
	      int offset = data.length-8; 
	      int[] reversedArray = new int[data.length];
	      for (int i = 0; i < data.length; i++) {
	        if ((i > 0) && (i % 8 == 0)) {
	          offset = offset - 8;
	        }
	        data[i] = reversedArray[offset + (i%8)];
	      }
	    
	      
	      return reversedArray;
	      
	  }
	}