
public class Problem39 
{
	
	// Perimeter is p
	
	public static int generateTriangleCombinations(int p)
	{
		int counter = 0 ; 
		int perimetre = p;
		for (int a = perimetre - 2 ; a >= 1; a-- )
		{
			for (int b = perimetre - a - 1; b >= 1; b --)
			{
				for (int c = perimetre - a - b ; c >= b ; c--)
				{
					if ( a + b + c == p)
					{
						if (Math.pow(a, 2) == Math.pow(b,  2) + Math.pow(c, 2))
						{
							counter ++;
							//System.out.println(a + " " + b + " "  + c);
						}
					}
				}
			}
		}
		return counter;
	}

	
	public static void main (String[] args)
	{
		int bestPerimeter = 0; int combinations = 0;
		for (int i = 3 ; i <= 1000; i++)
		{
			int temp = generateTriangleCombinations(i);
			if (temp > combinations)
			{
				combinations = temp;
				bestPerimeter = i;
			}
		
		
		}
		
		System.out.println(bestPerimeter);
	}
	
}


