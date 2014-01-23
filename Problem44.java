import java.util.ArrayList;
import java.util.TreeSet;


public class Problem44 
{
	
	public static TreeSet<Integer> pentagonalNumbers = new TreeSet<Integer>();
	public static ArrayList<Integer> pentNumbers = new ArrayList<Integer>();
	public static int generateNthPentagonalNumber(int n)
	{
		return n * ( 3 * n - 1) / 2;
	}

	public static boolean isDifferencePentagonal(int v1, int v2)
	{
		return pentagonalNumbers.contains(Math.abs(v1 - v2));
	}

	public static boolean isSumPentagonal(int v1, int v2)
	{
		return pentagonalNumbers.contains(Math.abs(v1 + v2));
	}
	
	
	public static void main (String [] args)
	{
		for (int i = 1 ; i < 10001 ; i++)
		{
			pentagonalNumbers.add(generateNthPentagonalNumber(i));
			pentNumbers.add(generateNthPentagonalNumber(i));
		}
		
		int minimumDistance = pentNumbers.get(pentNumbers.size() -1);
		
		for (int i = 0 ; i < 10000 ; i ++ )
		{
			for (int j = 0 ; j < 10000; j++)
			{
				if (isSumPentagonal(pentNumbers.get(i), pentNumbers.get(j)) && isDifferencePentagonal(pentNumbers.get(i), pentNumbers.get(j)))
				{
					System.out.println(pentNumbers.get(i) + " and " + pentNumbers.get(j));
					minimumDistance = Math.min(Math.abs(pentNumbers.get(i) - pentNumbers.get(j)), minimumDistance);
				}
				
				if (Math.abs(pentNumbers.get(i) - pentNumbers.get(j)) > minimumDistance)
					break;
			}
		}
		System.out.println(minimumDistance);
	}
	
}
