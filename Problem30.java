import java.util.ArrayList;


public class Problem30 
{
	// (9 ^ 5) * 5 = 295245
	//5 digit limit
	public static void main(String[] args)
	{
		ArrayList set = new ArrayList(); 
		double productSum = 0;	
		
		for (int i = 0 ; i < 355000 ; i++)
		{
			productSum = 0;
			//Can only be a 5 digit number or a 4 digit number						
			int value = i;
			while (value != 0)
			{
				productSum +=  Math.pow((value % 10), 5);
				value /= 10;
			}
			
			if (i == productSum)
			{
				set.add(i);
			}			
			
			
			
		}
		int sum = 0;
		for (int i = 0 ; i < set.size(); i++)
		{
			sum += (int)set.get(i);
		}
		
		System.out.println(sum);
	}
	

}