
public class Problem45 
{
	public static boolean isPentagonal(long v)
	{
		double x = (Math.sqrt(24 * v + 1) + 1) / 6;
		return (x == (long)x);
	}
	public static  void main (String [] args)
	{
		boolean found = false;
		int n = 145;
		while (!found)
		{
			long hexagonalNumber = n * (2 * n - 1);
			n+=2;
			
			if (isPentagonal(hexagonalNumber))
			{
				found = true;
				System.out.println(hexagonalNumber);
			}
		}
		
	}

}
