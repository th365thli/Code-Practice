package Problems;

public class Zigzag {
    public static String convert(String s, int numRows) {
        if (numRows <=1) {
            return s;
        }
        if (s.length() <= numRows) {
        	return s;
        }
        
        int numColumns = s.length()/2;
        char[][] zigzag = new char[numRows][numColumns];
        int stringIndex = 0;
        boolean isStraightCol = true;
        printArray(zigzag);
        while (stringIndex < s.length()) {
            for (int k =0; k < numColumns; k+=0) {
                if (isStraightCol) {
                    for (int x = 0; x < numRows; x++) {
                    	if (stringIndex >= s.length()) {
                        	break;
                        }
                        zigzag[x][k] = s.charAt(stringIndex);
                        stringIndex++;
                    }
                    isStraightCol = false;
                } else {
                    for (int i = numRows-2; i > 0; i--) {
                    	if (stringIndex >= s.length()) {
                        	break;
                        }
                        k++;
                        zigzag[i][k] = s.charAt(stringIndex);
                        stringIndex++;
                    }
                    k++;
                    isStraightCol = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k< numRows; k++) {
            for (int i = 0; i < numColumns; i++) {
                 if (zigzag[k][i] != Character.MIN_VALUE){
                    sb.append(zigzag[k][i]);
                 }
            }
        }
        return sb.toString();
    }
    
    public static void main(String args[]) {
    	String s = "PAYPALISHIRING";
    	int numRows = 4;
    	System.out.println(convert(s, numRows));
    }
    
    public static String printArray(char[][] array) {
    	StringBuilder sb = new StringBuilder();
    	//number of rows
    	 for (int k = 0; k < array.length; k++) {
    		 //number of columns
             for (int i = 0; i  < array[0].length; i++) {
                     sb.append(array[k][i]);
             }
             sb.append("\n");
         }
    	 
    	 return sb.toString();
    }
}