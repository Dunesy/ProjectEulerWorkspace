import java.util.ArrayList;


public class Problem64 {

	public static int squareRoot(long number)
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
		
		result = 1;		
		while (Math.abs(result - pastResult) >= 1)
		{
			long calculatedAmount = result * result;
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
	
	
	public static int continuedFractionPeriodLength(int N)
	{		
		if (squareRoot(N) * squareRoot(N) == N)
			return 0;
		
		int period = 0;
		int d = 1;
		int m = 0;
		int a = squareRoot(N);
				
		do
		{							
			m = d * a - m;
			d = (N- m * m) / d;
			a = (squareRoot(N) + m) / d;
			period ++;
		} while (a != 2 * squareRoot(N));
		
		return period;					
	}
	
	public static void main (String [] args)
	{
		int counter = 0;
		for (int i = 2 ; i < 10000; i++)
		{
			int periodLength = continuedFractionPeriodLength(i);
			if (periodLength % 2 == 1)
				counter ++;			
		}
		System.out.println(counter);
	}
	
	
}
