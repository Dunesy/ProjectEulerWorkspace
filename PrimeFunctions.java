import java.util.ArrayList;
import java.util.Collections;


public class PrimeFunctions 
{
	public static ArrayList<Integer> generatePrimeNumbers(int N)
	{
		 // initially assume all integers are prime
        boolean[] isPrime = new boolean[N + 1];
        ArrayList<Integer> primeSet = new ArrayList<Integer>(N / 2);
        for (long i = 2; i <= N; i++) {
            isPrime[(int)i] = true;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i <= N; i++) {

            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[i]) {
            	primeSet.add(i);
                for (long j = 2 * i; j <= N; j+= i) {
                    isPrime[(int)j] = false;
                }
            }
        }
        return primeSet;
	}
	
	public static boolean[] generatePrimes(int N)
	{
		boolean[] isPrime = new boolean[N + 1];
        for (long i = 2; i <= N; i++) {
            isPrime[(int)i] = true;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i*i <= N; i++) {

            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (long j = 2 * i; j <= N; j+= i) {
                    isPrime[(int)j] = false;
                }
            }
        }
        return isPrime;
		
	}
	
	public static boolean isPrime(int number, boolean[] primes,
			ArrayList<Integer> primeTestSet) {
		if (number < primes.length)
			return primes[number];
		else {
			if (Collections.binarySearch(primeTestSet, number) == number) {
				return true;
			} else {
				return isPrime(number);
			}
		}
	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;
		if (n < 9)
			return true;
		if (n % 3 == 0)
			return false;
		if (n % 5 == 0)
			return false;

		int[] ar = new int[] { 2, 3 };
		for (int i = 0; i < ar.length; i++) {
			if (Witness(ar[i], n))
				return false;
		}
		return true;
	}

	private static boolean Witness(int a, int n) {
		int t = 0;
		int u = n - 1;
		while ((u & 1) == 0) {
			t++;
			u >>= 1;
		}

		long xi1 = ModularExp(a, u, n);
		long xi2;

		for (int i = 0; i < t; i++) {
			xi2 = xi1 * xi1 % n;
			if ((xi2 == 1) && (xi1 != 1) && (xi1 != (n - 1)))
				return true;
			xi1 = xi2;
		}
		if (xi1 != 1)
			return true;
		return false;
	}

	private static long ModularExp(int a, int b, int n) {
		long d = 1;
		int k = 0;
		while ((b >> k) > 0)
			k++;

		for (int i = k - 1; i >= 0; i--) {
			d = d * d % n;
			if (((b >> i) & 1) > 0)
				d = d * a % n;
		}

		return d;
	}
	
	public static ArrayList<Integer> primeFactorization(int n, ArrayList<Integer> primeSet)
	{
		
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		if (Collections.binarySearch(primeSet, n) >= 0)
		{
			primeFactors.add(n);
			return primeFactors;
		}
		
		int index = 0;
		boolean divided = false;
		while (n != 1 && index < n /2)
		{
			if (n % primeSet.get(index) == 0 && !divided)
			{
				primeFactors.add(primeSet.get(index));
				divided = true;
				n /= primeSet.get(index);
			}
			else if (n % primeSet.get(index) == 0 && divided)
			{
				n /= primeSet.get(index);
			}
			else
			{
				index++;
				divided = false;
			}
		}
		return primeFactors;
	}
	
	public static boolean hasXFactors(int N, int limit, ArrayList<Integer> primeSet)
	{
		int counter = 0;
		if (Collections.binarySearch(primeSet, N) >= 0)
		{
			return false;
		}		
		int index = 0;		
		while (N != 1 && index < N /2)
		{
			if (counter > limit)
				return false;
			if (N % primeSet.get(index) == 0)
			{				
				counter ++;
				N /= primeSet.get(index);
			}									
			else
			{
				index++;				
			}
		}
		return (counter == limit);
		
	
	}
	
}
