import java.util.ArrayList;


public class Problem47 
{

	public static ArrayList<Integer> distinctPrimeFactorization(int number)
	{
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		int startingFactor = 2;
		while (number != 1)
		{
			if (number % startingFactor == 0)
			{
				number /= startingFactor;
				primeFactors.add(startingFactor);
				
				while (number % startingFactor == 0)
				{
					number /= startingFactor;
				}
			}
			startingFactor++;
			
		}
		return primeFactors;
	}
	
	public static void main (String[] args)
	{
		ArrayList<Integer> consecutiveNumbers = new ArrayList<Integer>();
		int currentNumber = 2;
		while (consecutiveNumbers.size() != 4)
		{
			if (distinctPrimeFactorization(currentNumber).size() == 4)
			{
				consecutiveNumbers.add(currentNumber);
			}
			else
			{
				consecutiveNumbers.clear();
			}
			
			currentNumber++;
			
		}
		
		System.out.println(consecutiveNumbers.get(0));
	}
	
	
	
}
