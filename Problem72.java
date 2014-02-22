import java.util.ArrayList;


public class Problem72 
{

	public static int[] totientSieve(int limit)
	{
		int phi[] = new int[limit + 1];
		for (int i = 0 ; i <= limit; i++)
		{
			phi[i] = i;
		}
		
		for (int i = 2 ; i <= limit ; i++ )
		{
			if (phi[i] == i)
			{
				for (int j = i ; j <= limit ; j += i)
				{
					phi[j] = phi[j] / i * (i - 1);
				}
			}
		}
		return phi;
	}
	
	public static void main (String [] args)
	{
		int limit = 1000000;
		int[] totient = totientSieve(limit);
		long result = 0;		
			
		for (int i = 2 ; i <= limit; i++)
		{
			result += totient[i];
		}
				
		System.out.println(result);
	}
	
}
