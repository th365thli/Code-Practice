package Problems;

public class FindMissingLetter {
	
	 public static char findMissingLetter(char[] array)
	  {
	    
	    for (int i = 1; i < array.length; i++) {
	      if ((int) array[i] > (int) array[i-1]+1) {
	        return (char) ((int) array[i] - 1); 
	      }
	    
	    }
	  
	  
	    return ' ';
	  }
	
	public static void main(String[] args) {
		char[] test = new char[] { 'a','b','c','d', 'e', 'g' };
		
		System.out.println(findMissingLetter(test));
		
		
		
		
	}

}
