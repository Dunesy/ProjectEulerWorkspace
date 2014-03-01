import java.math.BigInteger;


public class Problem78 
{

	public static void main (String [] args)
	{		
		
		int x = 0;
		long startTime = System.currentTimeMillis();		
		int m = 1000000;		
		long[] numbers2 = new long[x+ 1];		
		numbers2[0] = 1;						
		do
		{				
			x++;
			numbers2 = pentagonalNumberGrowthFunction(x, m, numbers2);							
		}while (numbers2[x] != 0);				
		
		System.out.println("Answer: " + x + " Generating ");
		System.out.println(System.currentTimeMillis() - startTime + "ms");
	}	
		
	public static BigInteger[] bigPentagonalNumberGrowthFunction(int N, BigInteger[] numbers)
	{		
		if (numbers.length - 1 < N)
		{
			BigInteger[] numberCopy = new BigInteger[numbers.length * 2];
			System.arraycopy(numbers, 0, numberCopy, 0, numbers.length);
			numbers = numberCopy;			
		}			
		numbers[N] = new BigInteger("0");		
		for (int i = 1 ; i*(3 * i - 1)/2 <= N ; i++)
		{
			BigInteger precursor = new BigInteger("-1");
			precursor = precursor.pow(i-1);
			int pentagonalIndex1 = i*(3*i-1)/2;					
			int pentagonalIndex2 = i*(3*i+1)/2;	
			BigInteger result1 = new BigInteger("0");;
			BigInteger result2 = new BigInteger("0");
			if (pentagonalIndex1 <= N)
			{
				result1 = numbers[N-pentagonalIndex1];
			}
			if (pentagonalIndex2 <= N)
			{
				result2 = numbers[N-pentagonalIndex2];
			}							
			numbers[N] = numbers[N].add(((result1.add(result2)).multiply(precursor)));				
		}				
		return numbers;
	}
	
	public static long[] pentagonalNumberGrowthFunction(int N, int mod, long[] numbers)
	{		
		if (numbers.length - 1 < N)
		{
			long[] numberCopy = new long[numbers.length * 2];
			System.arraycopy(numbers, 0, numberCopy, 0, numbers.length);
			numbers = numberCopy;			
		}			
		numbers[N] = 0;		
		for (int i = 1 ; i*(3 * i - 1)/2 <= N ; i++)
		{
			int precursor = -1;
			precursor = (int)Math.pow(precursor,i-1);
			int pentagonalIndex1 = i*(3*i-1)/2;					
			int pentagonalIndex2 = i*(3*i+1)/2;	
			long result1 = 0;
			long result2 = 0;
			if (pentagonalIndex1 <= N)
			{
				result1 = numbers[N-pentagonalIndex1];
			}
			if (pentagonalIndex2 <= N)
			{
				result2 = numbers[N-pentagonalIndex2];
			}							
			numbers[N] += ((result1 + result2) * precursor);
			numbers[N] %= 1000000;
		}				
		return numbers;
	}
	
}
