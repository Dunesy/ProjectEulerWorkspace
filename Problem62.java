
public class Problem62 
{

	
	public static int cubeRoot(long number)
	{
		int result = 0;
		int pastResult = 0;
		int digitCount = 0 ;
		long temp = number;
		while (temp != 0)
		{
			temp /= 10;
			digitCount++;
		}
		
		result = (int) Math.pow(10, (int)(digitCount / 3));		
		while (Math.abs(result - pastResult) > 1)
		{
			long calculatedAmount = result * result * result;
			if (calculatedAmount == number) {
				break;
			} else if (calculatedAmount > number) {				
				result = (pastResult + result) / 2;				
			} else if (calculatedAmount < number) {
				pastResult = result;
				result *= 2;
			}			
		}			
		return result;
	}

	public static int numberOfDigits(long number)
	{
		int digitCount = 0;
		while (number != 0)
		{
			number /= 10;
			digitCount ++;
		}
		return digitCount;
	}
	
	public static void main (String[] args)
	{
		long startTime = System.currentTimeMillis();
		boolean found = false;
		long currentBase = 345;		
		long smallestCube  = 0;
		
		while (!found)
		{
			long calculatedCube = currentBase * currentBase * currentBase;						
			int digitCount = numberOfDigits(calculatedCube);
			long currentMax = (long) Math.pow(10, digitCount);
			int matches = 0;
			
			long currentValue = calculatedCube;
			long base = currentBase + 1;
			while (matches < 4 && currentValue < currentMax)
			{				
				currentValue = base * base * base;
				if (Problem52.isPermutation(currentValue, calculatedCube))
				{
					matches ++;
					if (matches == 1)
					{
						smallestCube = calculatedCube;						
					}				
				}
				base++;				
			}			
						
			if (matches == 4)
			{			
				found = true;
			}
			currentBase ++;
		}
		
		System.out.println(smallestCube);
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
