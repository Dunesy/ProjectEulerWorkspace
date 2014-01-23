
public class Problem50
{
	public static boolean[] primes = Problem49.generatePrimes(1000000);
	
	public static void main (String [] args)
	{
		int longestSequence = 0;
		int primeNumber = 0;
		int index = 0;
		//Dynamic Programming paradigm....
		int[] consecutivePrimeSums = new int[1000000];
		int[] counts = new int[1000000];
		for (int i = 0 ; i <  consecutivePrimeSums.length ; i++)
		{
			for (int j = i ; j < consecutivePrimeSums.length; j++)
			{
				if (consecutivePrimeSums[i] >= 10000000)
					break;
				
				if (primes[j]) 
				{
					consecutivePrimeSums[i] += j;
					counts[i]++;
				}
				
				if (consecutivePrimeSums[i] < 1000000 && primes[consecutivePrimeSums[i]])
				{
					if (counts[i] > longestSequence)
					{
						primeNumber = consecutivePrimeSums[i];
						longestSequence = counts[i];
						index = i;
					}
				}
				
			}
		}
		
		System.out.println(longestSequence);
		System.out.println(primeNumber);
		System.out.println(index);
		
	}
	
	
}
