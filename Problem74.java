
class ColouredNode
{
	public boolean visited;
	public int next ;
	
	public ColouredNode(int value, int value2)
	{
		visited = false;
		next = value;	
	}	
}

public class Problem74 
{
	
	public static int[] factorials = {1, 1 ,2 , 6, 24, 120, 720, 5040, 40320, 362880 };
	public static ColouredNode[] map;
	public static int[] sequenceLengths;
	
	public static int recursiveVisit(int index) 
	{		
		if (map[index] == null)
		{
			int temp = index;
			int sum = 0;
			while(temp != 0)
			{				
				sum += factorials[temp % 10];
				temp /= 10;
			}
			map[index] = new ColouredNode(sum, index);	
		}
		
		if (sequenceLengths[index] != 0)
		{
			return sequenceLengths[index];
		}
		else if (map[index].visited)
		{
			return 0;
		}
		else
		{
			map[index].visited = true;
			sequenceLengths[index] = 1 + recursiveVisit(map[index].next);
			return sequenceLengths[index];
		}
	}
	

	public static void main (String[] args)
	{
		long startTime = System.currentTimeMillis(); 
		int limit = 1000000;
		sequenceLengths = new int[limit * 10];		
		map = new ColouredNode[limit * 10];
		int answer = 0;
		//Count the chain sequences
		for (int i = 0 ; i <= limit; i++)
		{
			int counter = 0;
			int currentIndex = i;			
			counter = recursiveVisit(currentIndex);
			
			if (counter == 60)
			{						
				answer++;
			}
		}
		System.out.println(answer);		
		System.out.println("Time Elapsed " + (System.currentTimeMillis() - startTime) + "ms");
	}
}
