import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;


public class Problem32 
{
		
	//UpperBound 987654321
	// Minimum number of digits 
	public static SortedSet<Integer> set = new TreeSet<Integer>();
	
	public static ArrayList<Integer> createMultiplicands ()
	{
		ArrayList<Integer> multiplicands = new ArrayList<Integer>();
		
		for (int i = 123 ; i <= 9876 ; i++)
		{
			SortedSet<Integer> digitChecker = new TreeSet<Integer>();
			digitChecker.add(0);
			int temp = i;
			boolean valid = true;
			while (temp != 0)
			{				
				if (!digitChecker.add(temp % 10))
				{
					valid = false;
					break;
				}
				temp /= 10;
			}
			if (valid)
				multiplicands.add(i);
			
		}
	
		return multiplicands;
	}
	
	public static boolean used(int [] digits, int i , int j)
	{		
		for (int k = 0; k < digits.length ; k++)
		{
			if (i == digits[k] - 1 || j == digits[k] - 1)
			{
				return true;
			}		
		}	
		return false;
	}
	
	public static ArrayList<Integer> createMultipliers (int multiplicand)
	{
		SortedSet<Integer> multiplierDigits = new TreeSet<Integer>();			
		SortedSet<Integer> multiplicandDigits = new TreeSet<Integer>();
		ArrayList<Integer> multipliers = new ArrayList<Integer>();
		int temp = multiplicand;		
		
		while (temp != 0)
		{				
			multiplicandDigits.add(temp % 10);								
			temp /= 10;
		}
		
		for (int i = 1 ; i <= 98 ; i++)
		{
			SortedSet<Integer> digitChecker = new TreeSet<Integer>();
			digitChecker.add(0);
			temp = i;
			boolean valid = true;
			while (temp != 0)
			{				
				if (!digitChecker.add(temp % 10) || multiplicandDigits.contains(temp % 10))
				{
					valid = false;
					break;
				}
				temp /= 10;
			}
			if (valid)
				multipliers.add(i);
		
		}
		return multipliers;
	}
	
	public static boolean isValid(int product, SortedSet<Integer> multiplicandDigits, SortedSet<Integer> multiplierDigits) {
		SortedSet<Integer> remainingDigits = new TreeSet<Integer>(); 
		while (product != 0)
		{			
			if (product % 10 == 0 || multiplicandDigits.contains(product % 10) || multiplierDigits.contains(product % 10) || remainingDigits.contains(product % 10))
			{
				return false;
			}	
			remainingDigits.add(product % 10);
			product /= 10;			
		}
		
		if (remainingDigits.size() == 9 - multiplicandDigits.size() - multiplierDigits.size())
			return true;
		
		return false;
	}
	
	
	public static void main (String [] args)
	{				
		int product = 0;
		
		ArrayList<Integer> multiplicands = createMultiplicands();
		ArrayList<Integer> multipliers;
		for (int multiplicand : multiplicands)
		{
			int temp = multiplicand, index = 0;
			SortedSet<Integer> multiplicandDigits = new TreeSet<Integer>();
			int[] value = new int[4];
			while (temp != 0 )
			{								
				multiplicandDigits.add(temp % 10);  
				value[index] = temp % 10;
				temp /= 10;
				index ++ ;
			}			
			
			multipliers = createMultipliers(multiplicand);
			
			for (int number : multipliers)				
			{
				SortedSet<Integer> multiplierDigits = new TreeSet<Integer>();				
				temp = number;
				while (temp != 0)
				{
					multiplierDigits.add(temp % 10);					
					temp /= 10;
				}
											
				product = multiplicand * number;
				temp = product;		
								
				if (isValid(temp, multiplicandDigits, multiplierDigits))
				{
					set.add(product);
				}
										
			}
			
		}
		int sum = 0;
		for(int iterator : set)
		{
			sum += iterator;
		}
		
		System.out.println(sum);
				
	}

}	