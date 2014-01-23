import java.math.BigInteger;


public class Problem55
{
	
	
	public static BigInteger process(BigInteger number)
	{
		StringBuilder sb = new StringBuilder(number.toString()).reverse();
		BigInteger result = number.add(new BigInteger(sb.toString()));		
		return result;
	}
	
	public static boolean isPalindrome(BigInteger number)
	{
		String numberString = number.toString();
		for (int i = 0 ; i < numberString.length() / 2 ; i ++)
		{
			if (numberString.charAt(i) != numberString.charAt(numberString.length() - 1 - i))
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main (String [] args)
	{
		int counter = 0;
		for (int i = 0 ; i <= 10000 ; i++)
		{
			BigInteger number = new BigInteger(String.valueOf(i));
			boolean palindrome = false;
			for (int j = 0 ; j < 50 ; j++)
			{
				
				number = process(number);
				if (isPalindrome(number))
				{
					palindrome = true;
					break;
				}
								
			}
			
			if (!palindrome)
			{			
				counter ++;
			}
			
			
		}
		
		System.out.println(counter);
	}
	
}
