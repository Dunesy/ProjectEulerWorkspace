import java.awt.List;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

class PrimeFactor
{
	public int primeNumber;
	public int order;
	
	PrimeFactor(int p, int o)
	{
		primeNumber = p;
		order = o;
	}

}


public class Problem29
{
	
	private static int [] generatePrimes(int max) {
	    boolean[] isComposite = new boolean[max + 1];
	    for (int i = 2; i * i <= max; i++) {
	        if (!isComposite [i]) {
	            for (int j = i; i * j <= max; j++) {
	                isComposite [i*j] = true;
	            }
	        }
	    }
	    int numPrimes = 0;
	    for (int i = 2; i <= max; i++) {
	        if (!isComposite [i]) numPrimes++;
	    }
	    int [] primes = new int [numPrimes];
	    int index = 0;
	    for (int i = 2; i <= max; i++) {
	        if (!isComposite [i]) primes [index++] = i;
	    }
	    return primes;
	}
	
	public static ArrayList<PrimeFactor> primeFactors(int number) {
	    int n = number;
	    ArrayList<PrimeFactor> factors = new ArrayList<PrimeFactor>();
	    for (int i = 2; i <= n; i++) {
	    	boolean factorAdded = false;
	    	while (n % i == 0) {	        
	    		if (!factorAdded)
	    		{
	    			factors.add(new PrimeFactor(i, 1));
	    			factorAdded = true;
	    		}
	    		else
	    		{
	    			factors.get(factors.size() -1).order++;
	    		}
	    	
	        n /= i;
	      }
	    }
	    return factors;
	  }
		
	private static int[] primes = null;
	
	private static boolean isPrime(int testNumber) 
	{
	    int i = 0;
	    while (primes[i] <= testNumber) {
	        if (primes[i] == testNumber) {
	            return true;
	        }
	        i++;
	    }
	    return false;
	}
	
	public static void main (String[] args)
	{		
		
		SortedSet numbers = new TreeSet();
		for (int i = 2 ; i <= 100; i++)
		{
			for (int j = 2 ; j <= 100 ; j++)
			{
				double result = Math.pow(i, j);
				numbers.add(result);
			}
		}
		System.out.println(numbers.size());
								
	}
		
	
}
