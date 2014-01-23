
public class Problem36 
{

	public static boolean isPalindrome(String number)
	{
		int index = 0;
		boolean even = (number.length() % 2 == 0);
		while ( index < number.length() / 2)
		{
			
			if (!even && index == number.length() / 2)
			{
				return true;
			}
			else
			{
				if (number.charAt(index) != number.charAt(number.length() - 1 - index))
				{
					return false;
				}
			}
			index++;
		}
				
		return true;			
	}
	
	public static void main (String[] args)
	{
		int number = 0;
		int sum = 0;
		while (number <= 1000000)
		{
			if (isPalindrome(String.valueOf(number)) && isPalindrome(Integer.toBinaryString(number)))
				sum += number;
			number++;
		}
		
		System.out.println(sum);
	}
	
}
