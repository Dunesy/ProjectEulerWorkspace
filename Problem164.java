
public class Problem164 
{

	
	public static void main (String[] args)
	{
		//1 2 3 4 5 6 7 8 9		(n)(m)(o) where n + m + o <= 9
		//1 2 3 4 5 6 7 8 9
		//1 2 3 4 5 6 7 8 9
		int [][] digitMemorySpace = new int[3][10];
		for( int j = 1 ;  j < digitMemorySpace[0].length; j++)
		{				
			
			digitMemorySpace[0][j] = 1;
		}
		
		for (int i = 1 ; i < digitMemorySpace.length; i++)
		{
			if (i == 1)
			{
				// i - 1
				for( int j = digitMemorySpace[0].length - 1 ;  j >= 0; j--)
				{
					//i
					for(int k = digitMemorySpace[0].length -1 - j ;  k >= 0; k--)
					{
						digitMemorySpace[i][j] += digitMemorySpace[i-1][j];						
					}
				}
			}
			if(i >= 2)
			{
				int loc = digitMemorySpace[0].length -1;
				// i - 1
				for(int j = loc ;  j >= 0; j--)
				{
					//i - 2
					for(int k = loc - j ;  k >= 0; k--)
					{						
						for (int z = loc - k ; z >= 0; z--)
						{													
							digitMemorySpace[i][j][k] += digitMemorySpace[i-1][j][z];
						}		
						
					}										
				}			
			}					
		}
		
		for (int i = 0 ; i < digitMemorySpace.length; i++)
		{
			for (int j = 0; j < digitMemorySpace[0].length; j++)
			{
				System.out.print(digitMemorySpace[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
