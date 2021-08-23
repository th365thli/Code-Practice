package OldProblems;

public class Divide13CodeWars {
	
	public static long thirt(long n) {
		
		if (n < 100) {
			return n;
		}
		
		int[] cycle = new int[] {1, 10, 9, 12, 3, 4};
        int mod;
        int sum=0;
        int i = 0;
		while (n >= 1) {
        	mod = (int)n % 10;
        	n = n/10;
        	sum = sum + mod * cycle[i];
        	i++;
        	if (i > 5) {
        		i = 0;
        	} 
        }
    
		return thirt(sum);
	
	}
	
	public static void main(String[] args) {
		System.out.println(thirt(8529));
		
		
	}
	
	
}
