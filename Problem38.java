
public class Problem38 
{
	
	public static boolean isPandigital(long number)
	{
		boolean[] validDigits = new boolean[9];
	
		for (int i = 0 ; i < validDigits.length; i++)
		{
			validDigits[i] = false;
		}
	
		long tempNumber = number;		
		while ( tempNumber != 0 )
		{
			int digit = (int)(tempNumber % 10); 
			
			if (digit == 0)
			{
				return false;
			}
			
			if (!validDigits[digit - 1])
			{
				validDigits[digit - 1] = true;
			}
			else
			{
				return false;
			}
			tempNumber /= 10;
		}		
		for (int i = 0 ; i < validDigits.length; i++)
		{
			if (!validDigits[i])
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean isNineDigits(long number)
	{
		
		long tempNumber = number;
		int counter = 0;
		
		while (tempNumber != 0)
		{
			tempNumber /= 10;
			counter ++;
		}
		
		return (counter == 9);
	}
	
	public static long createProduct(int number)
	{
		String currentProduct = new String();
		int multiplier = 1;
		while (currentProduct.length() < 9 )
		{
			int product = number * multiplier;
			currentProduct += Integer.toString(product);
			multiplier++;
		}
		return Long.parseLong(currentProduct);
	}
	
	public static void main (String[] args)
	{
		
		System.out.println(isPandigital(987654321));		
		System.out.println(isPandigital(123456788));	
		System.out.println(isNineDigits(123456789));

		
		long largestPandigitalNumber = 0;
		int currentNumbers = 1;
		
		while (currentNumbers < 10000)
		{
			
			long tempNumber = createProduct(currentNumbers);
			if (isNineDigits(tempNumber) && isPandigital(tempNumber))
			{
				if (largestPandigitalNumber < tempNumber)
					largestPandigitalNumber = tempNumber;
			}
			currentNumbers ++;
		}
	
		System.out.println(largestPandigitalNumber);
		
	}
	
	
	
}
