import java.util.ArrayList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class Problem37
{
	public static SortedSet<Integer> generatePrimes(int n)
	{
		boolean[] isPrimeNumber = new boolean[n + 1]; // boolean defaults to
		// false
		SortedSet<Integer> primes = new TreeSet<Integer>();
		for (int i = 2; i < n; i++) 
		{
		  isPrimeNumber[i] = true;
		}
		for (int i = 2; i < n; i++) 
		{
		  if (isPrimeNumber[i]) 
		  {	      
			primes.add(i);
		    // now mark the multiple of i as non-prime number
		    for (int j = 2 * i; j < n; j+= i)
		    {	          
		    	  isPrimeNumber[j] = false;
		    }
		  }		
		}
		return primes;
	}
	
	
	public static int rightTruncate(int number)
	{
		return (number / 10);
	}
	
	public static int leftTruncate(int number)
	{
		int tempNumber = number;
		int multiplier = 0;
		int leftDigit = 0;
		while (tempNumber != 0)
		{
			if (tempNumber / 10 == 0)
			{
				leftDigit = tempNumber;
			}
			tempNumber /= 10;
			multiplier ++;								
		}
		
		return number - (leftDigit * (int)Math.pow(10, multiplier - 1));
		
	}
	
	public static boolean isPrime(int number, Set<Integer> primes)
	{
		return  primes.contains(number);
	}
	
	public static boolean isTruncatablePrime(int number , Set<Integer> primes)
	{
		int tempNumber1 = number;
		int tempNumber2 = number;
		while (tempNumber2 != 0)
		{
			if (!isPrime(tempNumber1, primes))
			{
				return false;
			}
			if (!isPrime(tempNumber2, primes))
			{
				return false;			
			}
			tempNumber1 = leftTruncate(tempNumber1);
			tempNumber2 = rightTruncate(tempNumber2);		
		}				
		return true;
	}
	
	public static void main (String[] args)
	{
		
		int counter = 0;
		int currentNumber = 11;
		int sum = 0;
		SortedSet<Integer> primes = generatePrimes(10000000);
		while (counter < 11)
		{			
			if (isPrime(currentNumber, primes) && isTruncatablePrime(currentNumber, primes))
			{
				counter ++;
				sum += currentNumber;				
			}
				
				
			currentNumber ++;
		}
		System.out.println(sum);
		
	}
	
}
