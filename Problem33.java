
class Fraction
{
	public int numerator; 
	public int denominator;
	
	Fraction(int n , int d)
	{
		this.numerator = n;
		this.denominator = d;
	}
}

public class Problem33 
{
	
	public static boolean hasCommonDenominator(int x, int y)
	{
		int smallest = Math.min(x, y);
		for (int i = 2 ; i <= smallest ; i++)
		{
			if (x % i == 0 && y % i == 0)
			{
				return true;
			}
		}
		return false;
			
	}
	
	public static Fraction reduce(int x, int y)
	{
		int smallest = Math.min(x, y);
		for (int i = 2 ; i <= smallest ; i++)
		{
			if (x % i == 0 && y % i == 0)
			{				
				x /= i;
				y /= i;
				i--;
			}
		}
		return new Fraction(x, y);
	}
	
	public static boolean digitCancellationEffective(int x, int y)
	{
		double cancelledX = (double)(x / 10);
		double cancelledY = y % 10;
		
		if (cancelledY == 0)
		{
			return false;
		}
		
		double result1 = (double)x / (double)y;
		double result2 = (double)cancelledX / (double)cancelledY;
		
		return (result1 == result2);
	}
	
	
	public static void main (String [] args)
	{
		int bigNumerator = 1;
		int bigDenominator = 1 ;
		for (int i = 10 ; i < 99; i++)
		{		
			int yDigit = i % 10;
			if (yDigit > (i / 10) % 10)
				for (int j = yDigit * 10 ; j < (yDigit + 1) * 10; j++)
				{
					if (hasCommonDenominator(i, j) && digitCancellationEffective(i, j))
					{
						System.out.println(i + "/" + j);
						bigNumerator *= i;
						bigDenominator *= j;
					}
						
				}
			
		}
		
		System.out.println(bigNumerator + "/" + bigDenominator);
		Fraction f = reduce(bigNumerator, bigDenominator);
		System.out.println(f.numerator + "/" + f.denominator);
	}
}
