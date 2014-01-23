import java.util.ArrayList;


public class Problem26 
{
	// 1 / 999
	// 0.001
	
	public static int lengthOfRecurringSequence(int d)
	{
		int [] sequence = new int[1000];
		ArrayList<Integer> previousRemainders = new ArrayList<Integer>();
		int previousRemainderIndex = 0;
		int index = 0;
		
		int currentOperatingValue = 1;		
		
		
		while (currentOperatingValue != 0 && sequence[999] == 0)
		{
			if (d > currentOperatingValue)
			{
				currentOperatingValue *= 10;
				sequence[index] = 0;
				index ++;			
			}
			else
			{
				sequence[index] = currentOperatingValue / d;								
				currentOperatingValue -= d * sequence[index];
				if (previousRemainders.contains(currentOperatingValue))
					return previousRemainderIndex;
				else
				{
					previousRemainders.add(currentOperatingValue);
					previousRemainderIndex = index;
				}
			}					
			
			
			if (index > 999)
				return index;
			
		}		
		return 0;
	}
	

	
	public static void main(String [] args)
	{
		int a = 0;
		for (int i = 2 ; i <= 1000 ; i++)
		{
			//System.out.println(lengthOfRecurringSequence(i));
			a = Math.max(a, lengthOfRecurringSequence(i));			
		}
		
		System.out.println(a);
			
	}
	
	
}
