import java.util.ArrayList;


public class Problem46 {
	
	//Generate Prime Numbers 
	public static ArrayList<Integer> primeset = new ArrayList<Integer>();
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
	            	primeset.add(i);
	                for (int j = 2 * i; j <= N; j+=i) {
	                    isPrime[j] = false;
	                }
	            }
	        }
	        return isPrime;
	}
	
	
	public static boolean isPrime(int N , boolean[] primes)
	{
		return primes[N];
	}
	public static void main (String [] args)
	{
		
		boolean[] primes = generatePrimes(100000);
		boolean Goldbach = false;
		for (int i = 33; i < 100000; i+=2)
		{
			if (i == 137)
			{
				System.out.println(i);
			}
			Goldbach = false;
			for (int j = 2 ; j < primeset.size(); j++)
			{
				if (primes[j])
				{
					int number = i - j;
					if (number < 0 )
						break;
					
					int k = 0;
					while (k * k * 2 < number)
					{
						k++;						
					}
					
					if (k * k * 2== number)
					{
						Goldbach = true;
						break;	
					}
					
				}
			}
			if (!Goldbach)
			{				
				System.out.println(i);
				break;
			}
			
		}
	}
	
	
}
