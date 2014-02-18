import java.util.ArrayList;
import java.util.Collections;


public class Problem70 
{
		
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		int maxRange = 10000000;
		ArrayList<Integer> primeSet = PrimeFunctions.generatePrimeNumbers(maxRange);
		int firstFactor = (int)Math.sqrt(maxRange);
		int currentLargest = 0;
		for (int i = firstFactor ; i >= 0 ; i--)
		{
			if (Collections.binarySearch(primeSet, i) >= 0)
			{
				int range = maxRange / i;			
				for (int j = firstFactor; j <= range ; j++ )
				{
					if (Collections.binarySearch(primeSet, j) >= 0)
					{					
						int totientResult = Problem69.totientFunction(j * i, primeSet);
						if (Problem52.isPermutation(j * i, totientResult))
						{
							System.out.println(i * j);
							System.out.println(System.currentTimeMillis() - startTime);
							return;
						}
					}					
				}
			}
		}
		
			
	}
	
}
