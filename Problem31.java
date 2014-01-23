
public class Problem31
{
	
	
	public static void main(String[] args)
	{
		int counter = 0;
		int target = 200;
		
		for (int x = target ; x >= 0 ; x -= 200)
		{
			for (int i = x ; i >= 0 ; i-=100)
			{
				for (int j = i ; j >= 0 ; j-=50)
				{
					for (int h = j ; h >= 0; h-=20)
					{
						for (int g = h ; g >= 0 ; g -= 10)
						{
							for (int f = g ; f >= 0; f-= 5)
							{
								for (int d = f ; d >= 0 ; d-=2)
								{							
									counter++;
								}							
							}						
						}
					}
				}
			}
		}
		System.out.print(counter);
		Dynamic(200);
		
	}
	
	// Dynamic Solution
	
	public static int Dynamic(int targetAmount)
	{
		
		int [] coins = { 1,2,5,10,20,50,100,200 };
		int [] ways = new int[targetAmount + 1];
		
		ways[0] = 1;
		
		for (int i = 0 ; i < coins.length;  i++)
		{
			for (int j = coins[i]; j <= targetAmount; j++)
			{
				ways[j] += ways[j- coins[i]];
			}
		}
		
		return 0;
	}

	
	
}
