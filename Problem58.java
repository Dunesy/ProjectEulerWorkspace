
public class Problem58
{
	
	public static boolean[]  generatePrimes(int N)
	{
		  
	        // initially assume all integers are prime
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
	
	public static boolean isPrime (long primeValue)
	{
		long divisor = 2;
		long n = (long)Math.sqrt(primeValue);
		while (divisor <  n)
		{	
			if (primeValue % divisor == 0)			
				return false;
			divisor++;
		}		
		return true;
	}
	
	
	public static void main (String [] args)
	{
	
		
			
		long T1 = 0;
		long T2 = 0; 
		long T3 = 0;
		long T4 = 0;
		
		double diagonalCount = 12;
		double primeCount = 8;
		int n = 4;
		do 
		{
			T1 = 4 * n * n - 2 *n + 1;
			T2 = T1 + 2 * n;
			T3 = T2 + 2 * n;
								
			
			if (isPrime(T1))
				primeCount++;
			
			if (isPrime(T2))
				primeCount++;
			
			if (isPrime(T3))
				primeCount++;
						
			
			diagonalCount += 4;
			n++;
					
			
			//System.out.println(T1 + " " + T2 + " " + T3 + " " + T4);
		}while ((double)(primeCount / diagonalCount) > 0.1);
		
		System.out.println(2 * n - 1);
		
	}
	

}
