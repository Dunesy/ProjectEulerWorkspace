import java.util.ArrayList;
import java.util.Collections;


public class Problem86 
{

	public static int calculateMinDistance(int l, int w, int h)  
	{				
		int result = l * l + (w + h) * (w + h);				
		double result2 = Math.sqrt(result);
		
		if ((int)(result2) * (int)(result2) == result)
			return result;
		else 
			return -1;
		
	}
	
	public static void main (String[] args)
	{
		int m = 1;
		int counter = 0;
		int width = 1;
		int height = 1;
		counter = 0;
		while (counter < 1000000)
		{
			ArrayList<Integer> dimensions = new ArrayList<Integer>();			
			for (width = m; width > 0 ; width--)
			{
				for (height = 1; height <= width ; height++)
				{																		
					if (calculateMinDistance(m, width, height) > 0)
					{
						counter += 1;
					}				
				}
			}
			m++;
			System.out.println(counter);
		}
	
			System.out.println(m);
			
		
		
		
	}
	
	
	
	
}
