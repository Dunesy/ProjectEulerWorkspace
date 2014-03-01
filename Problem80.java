import java.math.BigInteger;


public class Problem80 
{
	//Digit by Digit Calculation of a Square Root
	// N = ( a1 + a2 + a3+ ... + an)^2
	static int limit = 100;
	
	public static BigInteger precisionSquareRootCalculation(int N, int digitPrecision)
	{
		//Remainder 
		int[] a = new int[digitPrecision + 1];
		BigInteger p = new BigInteger("0");
		BigInteger remainder = new BigInteger(String.valueOf(N));
		
		BigInteger x = new BigInteger("0");
		BigInteger y = new BigInteger("0");
		BigInteger factor1 = new BigInteger("20");
		BigInteger factor2 = new BigInteger("10");
		BigInteger factor3 = new BigInteger("100");
		int i = 0;
		while (i < digitPrecision + 1)
		{											
			x = new BigInteger("0");
			BigInteger bestY = y;
			y = new BigInteger("0");			
			while (y.compareTo(remainder) <= 0)
			{								
				y = x.multiply((p.multiply(factor1)).add(x));	
				if (y.compareTo(remainder) <= 0)
				{
					a[i] = x.intValue();
					bestY = y;
				}
				x = x.add(new BigInteger("1"));
			}						
			p = p.multiply(factor2).add(new BigInteger(String.valueOf(a[i])));
			remainder = remainder.subtract(bestY).multiply(factor3);				
						
			i++;			
		}				
		
		String number = "";
		for (int j = 0 ; j < a.length; j++)
		{
			number += a[j];
		}
		
		return new BigInteger(number);
	}
	
	public static int findLargestSquaredFactor(int n)
	{
		int i = (int)Math.sqrt(n); 
		while (i * i > 1)
		{
			if (n % (i * i) == 0)
			{
				return i;
			}
			i --;
		}		
		return 1;
	}
	
	public static int sumTheRightMostDigits(BigInteger n)
	{
		int sum = 0;
		String numberString = n.toString();
		for (int i = 0 ; i < 100; i++)
		{
			sum += Integer.parseInt(numberString.substring(i, i + 1));
		}		
		return sum;
		
	}
	
	public static void main(String[] args)
	{
		
		long startTime = System.currentTimeMillis();
		int[] factors = new int[limit + 1];
		BigInteger[] precisionDigits= new BigInteger[limit + 1];		
		int result = 0;
		for (int i = 2 ; i <= limit; i ++)			
		{
			
			 factors[i] = findLargestSquaredFactor(i);
			 if (factors[i] * factors[i] == i)
				 continue;
			
			 if (i == 98)
			 {
				 System.out.println("Here");
			 }
			 if (factors[i] == 1)
			 {
				 precisionDigits[i] = precisionSquareRootCalculation(i, 101);
				 result += sumTheRightMostDigits(precisionDigits[i]);
			 }
			 else
			 {
				 precisionDigits[i] = precisionDigits[i / (factors[i] * factors[i])].multiply(new BigInteger(String.valueOf(factors[i])));
				 result += sumTheRightMostDigits(precisionDigits[i]);
			 }	
			 
			 System.out.println(result);
		}
		
		
		System.out.println(result);
		System.out.println(System.currentTimeMillis() - startTime + " ms");
	}
	
}
