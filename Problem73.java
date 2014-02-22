
public class Problem73 
{

	public static void main(String [] args)
	{
		int limit = 12000;
		double rightMost = 0.5;
		double leftMost = 1.0/3.0;
		int[] phiSieve = Problem72.totientSieve(limit);
		double estimateResult = 0.0;
		for (int i = 2 ; i < phiSieve.length ; i++)
		{
			estimateResult += phiSieve[i];
		}
		estimateResult = estimateResult * rightMost - estimateResult * leftMost;
		System.out.println(estimateResult);
		System.out.println(numberOfFractionsBetween(3 , 2, 12000));
		
		
		
	}	
	public static int numberOfFractionsBetween(int a , int b, int limit)
	{
		int count = 0;
		//pb < bq
		
		for (int i = 2 ; i <= limit; i++)
		{
			for (int j = i / a + 1 ; j < (i - 1) / b + 1; j++)
			{
				if (gcd(j, i) == 1)
				{					
					count++;
				}				
			}
		}
		return count;
	}
	
	public static int gcd(int a, int b)
	{
	    while (a != b)
	    {
	        if (a > b)
	           a = a - b;
	        else
	           b = b - a;	    
	    }
	    return a;
	}
}
