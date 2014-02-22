import java.util.ArrayList;


public class Problem71 
{
	//p / q < a / b = pb < aq;
	//pb < aq - 1
	//p < (aq - 1) / b
	
	public static void main (String [] args)
	{
		//p < (3q - 1) / 7
		int b = 7;
		int a = 3;		
		int limit = 1000000;
		ArrayList<Integer> primeSet = PrimeFunctions.generatePrimeNumbers(limit);
		
		int bestq = 1;
		int bestp = 0;
		double bestDistance = limit;
		for (int prime = 2 ; prime < limit; prime++)
		{
			int p = (a * prime - 1) / b;						
			double distance = b * p - prime * a;
			
			if (distance < 0)
				distance *= -1.0;
			
			if (distance <= bestDistance)
			{				
				bestDistance = distance;	
				bestq = prime;
				bestp = p;
			}		
		}
		System.out.println(bestp + "/" + bestq);
		
	}
}
