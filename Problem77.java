import java.util.ArrayList;

public class Problem77
{
	public static ArrayList<Integer> primeSet = new ArrayList<Integer>();
	// Which is the first Value that can be written as a sum 5500 different ways.
	public static int numberOfPossibleSummations(int n, int index, int[][]possibilities)
	{		
		if (n == 0)
		{
			return 1;
		}		
		if (n == 1)
		{
			return 0;
		}
		
		int answer = 0;				
		int primeIndex = index;
		
		if (primeSet.get(index) > n)
		{
			for (int i = index ; i >= 0; i--)
			{
				if (primeSet.get(i) <= n)
				{
					primeIndex = i;
					break;
				}
			}
		}
		
		for (int i = primeIndex; i >= 0  ; i--)
		{						
			if (possibilities[n-primeSet.get(i)][i] == 0)
			{
				possibilities[n-primeSet.get(i)][i] += numberOfPossibleSummations(n - primeSet.get(i), i, possibilities);
				answer += possibilities[n-primeSet.get(i)][i];
			}
			else 
			{
				answer += possibilities[n-primeSet.get(i)][i];
			}
		}
		return answer;
	}
	
	public static void main (String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int x = 0;
		int number = 4;
	    primeSet = PrimeFunctions.generatePrimeNumbers(1000000);
		
		int startingIndex = 0;
		
		int [][] possibilities;		
		long count = 0;
		
		while (count <= 5000)
		{
			number ++;
			//System.out.println(number);
			possibilities = new int[number + 1][number];			
			for (int i = startingIndex ; i < primeSet.size(); i++)
			{
				if (primeSet.get(i) < number)
					startingIndex = i;
				else 
					break;
			}											
			count = Problem77.numberOfPossibleSummations(number, startingIndex, possibilities);
			System.out.println(number + " " + count);
					
		}
		System.out.println(System.currentTimeMillis() - startTime + "ms");
		
	}
	
}
