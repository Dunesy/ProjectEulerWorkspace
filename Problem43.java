import java.util.ArrayList;


public class Problem43 
{
	public static ArrayList<String> pandigitalSet = new ArrayList<String>();
	public static int[] divisors = {1,2,3,5,7,11,13,17};
	
	public static ArrayList<String> generatePandigitals(int n)
	{
		ArrayList<Integer> pandigits = new ArrayList<Integer>();
		for (int i = n ; i >= 0; i--)
		{
			pandigits.add(i);
		}
		ArrayList<String> set = new ArrayList<String>();
		generatePandigitalHelper(set, "", pandigits);			
		return set;
	}
	
	public static ArrayList<String> generatePandigitals(ArrayList<Integer> digits)
	{
		ArrayList<String> set = new ArrayList<String>();
		generatePandigitalHelper(set, "", digits);			
		return set;
	}
	
	
	public static void generatePandigitalHelper(ArrayList<String> set , String currentNumber, ArrayList<Integer> pandigits)
	{
		
		if (pandigits.size() == 1)
		{
			//System.out.println(currentNumber + pandigits.get(0));
			set.add(currentNumber + pandigits.get(0));
			return;
		}	
		int counter = 0;
		while (counter < pandigits.size())
		{
			ArrayList<Integer> pandigitCopy = (ArrayList<Integer>) pandigits.clone();
			generatePandigitalHelper(set, currentNumber + pandigitCopy.remove(counter), pandigitCopy);
			counter++;
		}
	}
	
	public static boolean matchesPattern(String pandigitalNumber)
	{
		
		if (pandigitalNumber.length() != 10 || pandigitalNumber.charAt(0) == '0')
			return false;
		else 
		{
			for (int i = 0 ; i < pandigitalNumber.length() - 2 ; i++)
			{
				String subString = pandigitalNumber.substring(i, i + 3);
				if (Integer.parseInt(subString) % divisors[i] != 0)
					return false;
			}
		}
		System.out.println(pandigitalNumber);
		return true;
	}
	
	public static void main (String[] args)
	{
		
		generatePandigitals(9);
		long sum = 0;
		for (int i = 0 ; i < pandigitalSet.size(); i++)
		{
			if (matchesPattern(pandigitalSet.get(i)))
			{
				sum += Long.parseLong(pandigitalSet.get(i));
			}
		}
		
		System.out.println(sum);
		
	}
}
