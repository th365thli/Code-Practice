package Problems;

public class DivideTwoInts {
    public static int divide(int dividend, int divisor) {
    	
    	if (dividend == Integer.MIN_VALUE) {
    		dividend = Integer.MAX_VALUE;
    	} else {
    		dividend = Math.abs(dividend);
    	}
    	if (divisor ==  Integer.MIN_VALUE) {
    		divisor = Integer.MAX_VALUE;
    	} else {
    		divisor = Math.abs(divisor);
    	}
    	
    	boolean isPositive = false;
        if (dividend*-1 < 0 && divisor * -1 < 0 || dividend * -1 > 0 && divisor * -1 > 0) {
            isPositive = true;
        }
        
        
        int count = 0;
        int previousSum = divisor;
        while (previousSum <= dividend) {
            if (Integer.MAX_VALUE-previousSum < divisor) {
                return Integer.MAX_VALUE;
            }
            previousSum = previousSum + divisor;
            count++;
        }
        
        if (isPositive) {
            return count;
        } else {
            return count * -1;
        }
    }
    
    public static void main(String[] args) {
    	System.out.println(divide(-2147483648,
    			-1));
    }
}
