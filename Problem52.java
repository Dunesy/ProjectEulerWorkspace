
public class Problem52 
{

	public static boolean isPermutation(int original, int testNumber)
	{
		int[] digitCountOriginal = new int[10];
		int[] digitCountTestNumber = new int[10];
		
		if (original == testNumber)
			return false;
		
		while (original != 0)
		{
			digitCountOriginal[original % 10]++;
			original /= 10;
		}
		
		while (testNumber != 0)
		{
			digitCountTestNumber[testNumber % 10]++;
			testNumber /= 10;
		}
		
		for (int i = 0 ; i < digitCountOriginal.length; i++)
		{
			if (digitCountOriginal[i] != digitCountTestNumber[i])
				return false;
		}
		return true;		
	}
	
	
	public static void main (String[] args)
	{
		boolean found = false;
		int currentNumber = 1;
		while (!found)
		{
			
			currentNumber ++;
			if (isPermutation(currentNumber, currentNumber * 6) &&
					isPermutation(currentNumber, currentNumber * 5) &&
					isPermutation(currentNumber, currentNumber * 4) &&
					isPermutation(currentNumber, currentNumber * 3) &&
					isPermutation(currentNumber, currentNumber * 2))
			{
				found = true;
			}
			
			
		
		}
		System.out.println(currentNumber);
		
	}
	
	
	
}
