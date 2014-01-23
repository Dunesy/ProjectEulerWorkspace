
public class Problem34 
{
	
	public static int factorial(int n)
	{
		int product = 1;
		if (n == 0 || n == 1)
			return 1;
		for (int i = n ; i >= 2 ; i--)
		{
			product *= i;
		}
		return product;
	}
	
	public static void main (String[] args)
	{
		int number = 3;
		int sumOfFactorials = 0;
		int answer = 0;
		
		while (number <= 10000000)
		{
			sumOfFactorials = 0;
			int temp = number;
			boolean validNumber = true;
			
			while (temp != 0)
			{										
				sumOfFactorials += factorial(temp % 10);
				temp /= 10 ;				
			}
					
			if (sumOfFactorials == number)
			{
				answer += number;
			}
			number ++;
		
		}
		System.out.println(answer);
	}

}
