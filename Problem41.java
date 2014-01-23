import java.math.BigInteger;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;


public class Problem41
{
	public static ArrayList<Integer> pandigitalSet = new ArrayList<Integer>(); 
	public static boolean[] primes;
	
	public static boolean[] generatePrimes(int N)
	{
		 
	        // initially assume all integers are prime
	        boolean[] isPrime = new boolean[N + 1];
	        for (int i = 2; i <= N; i++) 
	        {
	            isPrime[i] = true;
	        }

	        // mark non-primes <= N using Sieve of Eratosthenes
	        for (int i = 2; i * i <= N; i++) {

	            // if i is prime, then mark multiples of i as nonprime
	            // suffices to consider mutiples i, i+1, ..., N/i
	            if (isPrime[i]) {
	                for (int j = 2 * i; j <= N; j+=i) {
	                    isPrime[j] = false;
	                }
	            }
	        }
	        return isPrime;
	}
	
	public static void main (String[] args)
	{
		
		long startTime = System.currentTimeMillis();
		generatePandigitals(9);
		primes = generatePrimes(987654321);
		int largestNumber = 0;
		for (int i = pandigitalSet.size() - 1 ; i >= 0 ; i--)
		{
			if (isPrime(pandigitalSet.get(i)))
			{
				largestNumber = Math.max(pandigitalSet.get(i), largestNumber);
			}
		}
		
		System.out.println(largestNumber);
		System.out.println(System.currentTimeMillis() - startTime);
	}
	
	public static boolean isPrime(int number)
	{
		return (primes[number]);
	}
	
	
	public static void generatePandigitals(int n)
	{
		ArrayList<Integer> pandigits = new ArrayList<Integer>();
		for (int i = n ; i >= 1; i--)
		{
			pandigits.add(i);
		}
		
		generatePandigitalHelper("", pandigits);
		
		pandigits.remove(0);
		
		generatePandigitalHelper("", pandigits);
		
		pandigits.remove(0);
		generatePandigitalHelper("", pandigits);
		
	}
	
	
	public static void generatePandigitalHelper(String currentNumber, ArrayList<Integer> pandigits)
	{
		
		if (pandigits.size() == 1)
		{
			//System.out.println(currentNumber + pandigits.get(0));
			pandigitalSet.add(Integer.parseInt(currentNumber + pandigits.get(0)));
			return;
		}	
		int counter = 0;
		while (counter < pandigits.size())
		{
			ArrayList<Integer> pandigitCopy = (ArrayList<Integer>) pandigits.clone();
			generatePandigitalHelper(currentNumber + pandigitCopy.remove(counter), pandigitCopy);
			counter++;
		}
	}
	
}
	
	
