import java.math.BigInteger;


public class Problem57 
{
	
	public static void main (String[] args)
	{
		BigInteger previousDenominator = new BigInteger("2");
		BigInteger previousNumerator = new BigInteger("3");
		BigInteger numerator;
		BigInteger denominator;
		long counter = 0;
		for (int i = 0 ; i < 1000; i++)
		{
	
			//The Denominator = The Previous Denominator and Numerator Summed 
			//The Numerator = The Current Denominator + The Previous Denominator
			
			denominator = previousDenominator.add(previousNumerator);
			numerator = denominator.add(previousDenominator);
			
			if (numerator.toString().length() > denominator.toString().length())
			{
				counter ++;
			}
			
			//System.out.println(numerator + "/" + denominator);
			
			previousNumerator = new BigInteger(numerator.toString());
			previousDenominator = new BigInteger(denominator.toString());;
		}
		
		System.out.println(counter);
		
	}

	
	

}
