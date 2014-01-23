import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;


public class Problem49
{

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
	        for (int i = 2; i <= N; i++) {

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
	
	public static ArrayList<Integer> generatePrimePermutations(ArrayList<Integer> numbers)
	{
		ArrayList<String> permutations = Problem43.generatePandigitals(numbers);
		ArrayList<Integer> numberPermutations = new ArrayList<Integer>();
		
		for (int j = 0 ; j < permutations.size(); j++)
		{
			numberPermutations.add(Integer.parseInt(permutations.get(j)));
		}
		// Count Primes
		ArrayList<Integer> primeSet = new ArrayList<Integer>();
		
		for (int j = 0 ; j < numberPermutations.size(); j++)
		{
			if (primes[numberPermutations.get(j)] && !primeSet.contains(numberPermutations.get(j)))
				primeSet.add(numberPermutations.get(j));
		}
		
		return primeSet;
	}
	
	public static boolean isPrimeSequence(ArrayList<Integer> set)
	{
		if (set.size() != 4 || set.contains(0))
		{
			return false;
		}
		
		ArrayList<Integer> primeSet = generatePrimePermutations(set);
	
		if (primeSet.size() < 3)
		{
			return false;
		}
		
		Collections.sort(primeSet);
		int currentDifference = 0;
		int counter = 0;
		for (int j = 0 ; j < primeSet.size(); j++)
		{
			for (int k = 0 ; k < primeSet.size(); k++)
			{
				for (int z = 0 ; z < primeSet.size(); z++)
				{
					if (j < k && k < z)
					{
						if (primeSet.get(k) - primeSet.get(j) == primeSet.get(z) - primeSet.get(k))
						{
							System.out.println(primeSet.get(j) +  "" + primeSet.get(k) + "" + primeSet.get(z));
							return true;
						}
					}
				}
			}
		}
		
		return false;
		
	}
	
	public static void main (String[] args)
	{
		primes = generatePrimes(10000);
		
		for (int i = 1000; i < 10000; i++)
		{
			if (i == 2969)
			{
				System.out.println("Debug");
			}
			int temp = i ;
			ArrayList<Integer> set = new ArrayList<Integer>();
			while (temp != 0)
			{
				set.add(temp % 10);
				temp /= 10;
			}
				
			
			
			if (isPrimeSequence(set));
			
			
		}
		
		System.out.println("I got here");
		
	}
	
}
