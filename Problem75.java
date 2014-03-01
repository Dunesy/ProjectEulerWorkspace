
public class Problem75 
{
	public static void main (String[] args)
	{
		int answer = 0;
		int limit = 1500000;
		int triangles[] = new int[limit + 1];
		
		int mMax = (int)Math.sqrt(limit);
		for (int m = 2; m <= mMax; m++)
		{		
			for (int n = 1 ; n < m; n++)
			{			
				if ((n + m) % 2 == 1 && Problem73.gcd(n, m) == 1)
				{
					int a = m * m - n * n;
					int b = 2 * m * n;
					int c = m * m + n * n;
					
					int perimeter = c + b + a;
					int k = 1;
					while (perimeter <= limit)
					{
						triangles[perimeter]++;
						k++;
						perimeter = k * (a + b + c); 
					}
				}
			}						
		}
		for (int i = 0 ; i < triangles.length ; i++)
		{
			if (triangles[i] == 1)
			{
				answer ++;
			}
		}
		System.out.println(answer);
	}
}
