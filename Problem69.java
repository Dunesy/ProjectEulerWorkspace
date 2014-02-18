import java.util.ArrayList;
import java.util.Collections;


public class Problem69 
{
	public static int totientFunction(int n, ArrayList<Integer> primeSet)
	{
		ArrayList<Integer> primeFactors = PrimeFunctions.primeFactorization(n, primeSet);
		double result = n;
		for (int prime : primeFactors)
		{
			result *= (1.0 - 1.0/(double)prime);
		}
		return (int)result;
	}
	
	public static int largestDivisor(int N, ArrayList<Integer> primeSet)
	{
		if (Collections.binarySearch(primeSet, N) >= 0)
		{
			return N;
		}
			
		for (int i = (int)Math.sqrt(N) ; i < N ; i++)
		{
			if (N % i == 0)
				return i;
		}
		
		return N;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		ArrayList<Integer> primeSet = PrimeFunctions.generatePrimeNumbers(1000000);	
		
		int answer = 1;
		/*
		int index = 0;
		while (answer * primeSet.get(index) < 1000000)
		{
			answer *= primeSet.get(index);
			index++;
		}
		System.out.println(answer);
		*/
		
		answer = 0;
		double largestValue = 0;
		for (int i = 2 ; i < 1000000; i++)
		{
			
				int totientValue = totientFunction(i, primeSet);	
				double result = (double)i / (double)totientValue;
				if (result > largestValue)
				{
					answer = i;
					largestValue = result;
				}	
		}
		System.out.println(answer);
		
		
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
