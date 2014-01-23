
public class Problem40 
{

	
	public static void main (String[] args)
	{
		int[] digitArray = new int[1000000];
		
		int counter = 1;
		int index = 0;
		
		while (index < digitArray.length)
		{
			
			int temp = counter;
			String digits = "";
			if (index == digitArray.length)
				break;
			
			while (temp != 0)
			{
				digits += temp % 10;
				temp /= 10;		
			}
			
			for (int i = digits.length()-1 ; i >= 0; i--)
			{
				if (index == digitArray.length)
					break;
				 digitArray[index] = Integer.parseInt(digits.substring(i, i+1));
				temp /= 10;	
				index ++;
			}
			if (index >= digitArray.length)
				break;
			
			while (digitArray[index] != 0)
			{
				index ++;
				if (index >= digitArray.length)
					break;
			}
			
			counter ++;
		}
		
		
		
		System.out.println(digitArray[0] * digitArray[9] * digitArray[99] * digitArray[999] * digitArray[9999] * digitArray[99999] * digitArray[999999]);
				
	}
	
}
