import java.math.BigInteger;
import java.util.ArrayList;


public class Problem66 
{
	//x2 – Dy2 = 1
	//X^2 = Dy^2 + 1 
	//x = SquareRoot(Dy^2 + 1)
	
	public static ArrayList<Integer> findPeriodQuotients(int N)
	{
		ArrayList<Integer> quotients = new ArrayList<Integer>();
		
		int period = 0;
		int d = 1;
		int m = 0;		
		int a = Problem64.squareRoot(N);
		
		
		quotients.add(a);
		if (a * a == N)
		{
			return quotients;
		}
		else 
		{
			do
			{							
				m = d * a - m;
				d = (N - m * m) / d;			
				a = (Problem64.squareRoot(N) + m) / d;			
				quotients.add(a);
			} while (a != 2 * Problem64.squareRoot(N));
		}
		return quotients;
	}
	
	public static BigInteger findContinuedFractionMinamilistSolution(int N, int type)
	{								
		
		ArrayList<Integer> quotients = findPeriodQuotients(N);				
		if (quotients.size() == 1)
		{
			return new BigInteger(String.valueOf(quotients.get(0)));
		}
		boolean solutionFound = false;
		
		BigInteger numerator = new BigInteger(String.valueOf(quotients.get(0)));
		BigInteger denominator = new BigInteger("1");
		int index = 1;				
		BigInteger previousNumerator = new BigInteger("1");
		BigInteger previousDenominator = new BigInteger("0");
		BigInteger tempNumerator = new BigInteger("1");
		BigInteger tempDenominator = new BigInteger("1");
		do
		{
			tempNumerator = numerator.multiply(new BigInteger(String.valueOf(quotients.get(index)))).add(previousNumerator);
			tempDenominator = denominator.multiply(new BigInteger(String.valueOf(quotients.get(index)))).add(previousDenominator);
			
			previousNumerator = numerator;
			previousDenominator = denominator;
			
			numerator = tempNumerator;
			denominator = tempDenominator;
			System.out.println(numerator + "/" + denominator);
			index++;						
			if (numerator.multiply(numerator).subtract(denominator.multiply(denominator.multiply(new BigInteger(String.valueOf(N))))).toString().equals("1"))
				solutionFound = true;
			
			if (index == quotients.size())
			{
				index = 1;
			}
			
			
		}while (!solutionFound)	;
		if (type == 1)
			return numerator;
		else
			return denominator;
							
	}
	
		
	public static void main (String[] args)
	{
		BigInteger largestX = new BigInteger("0");
		int DforX = 0;
		for (int D = 2 ; D <= 1000 ; D++)
		{
			BigInteger x = findContinuedFractionMinamilistSolution(D, 1);
			if (x.compareTo(largestX) == 1)
			{
				DforX = D ;
				largestX = x;
			}
						
		}
		System.out.println(largestX);
		System.out.println(DforX);
	}
	
}
