import java.util.ArrayList;


public class Problem27 {
	
	private static int[] primes;
	
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
	
	public static ArrayList<Integer> primeFactors(int number) {
	    int n = number;
	    ArrayList<Integer> factors = new ArrayList<Integer>();
	    for (int i = 2; i <= n; i++) {
	      while (n % i == 0) {
	        factors.add(i);
	        n /= i;
	      }
	    }
	    return factors;
	  }
	
	
	private static boolean isPrime(int testNumber) {
	    int i = 0;
	    while (primes[i] <= testNumber) {
	        if (primes[i] == testNumber) {
	            return true;
	        }
	        i++;
	    }
	    return false;
	}
	
	public static void main (String args[])
	{
		int[] bValues = generatePrimes(1000);
		primes = generatePrimes(87400);
		int aMax = 0, bMax = 0, nMax = 0;
		for (int a = -999 ; a < 1000 ; a++)
		{
			for (int b : bValues)
			{
				int n = 0;
				while (isPrime(Math.abs(n * n + a * n + b)))
				{
					n++;
				}
				
				if (n > nMax) {
					aMax = a;
					bMax = b;
					nMax = n;					
				}
				

				while (isPrime(Math.abs(n * n + a * n - b)))
				{
					n++;
				}
				
				if (n > nMax) {
					aMax = a;
					bMax = b;
					nMax = n;					
				}

				
			}			
		}
		
		System.out.println(aMax);
		System.out.println(bMax);
		System.out.println(nMax);
		System.out.println(aMax * bMax);
		
	}
	
	

}
