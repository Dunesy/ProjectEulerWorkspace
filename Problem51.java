import java.util.ArrayList;


public class Problem51 
{
	
	public static boolean[] primes = Problem46.generatePrimes(10000000);
	
	public static ArrayList<String> createWildCardCombinations(int number, int numberOfWildCards)
	{
		String stringForm = String.valueOf(number);
		ArrayList<String> wildcardCombos = new ArrayList<String>();
		createWildCardCombinationsHelper(wildcardCombos, stringForm, numberOfWildCards);	
		return wildcardCombos;
	}
	
	public static void createWildCardCombinationsHelper(ArrayList<String> wildcardCombos, String number, int numberOfWildCards)
	{
		if (numberOfWildCards == 0)
		{
			wildcardCombos.add(number);
		}
		else
		{
			int indexOfLastWildCard = -1;
			for (int i = number.length() -1 ; i >= 0; i--)
			{
				if (number.charAt(i) == '_')
				{
					indexOfLastWildCard = i;
					break;
				}			
			}
			
			char[] arrayRepresentation = number.toCharArray();
		
			for (int i = indexOfLastWildCard + 1; i < arrayRepresentation.length; i++)
			{
				char placeHolder = arrayRepresentation[i];
				arrayRepresentation[i] = '_';				
				String temp = "";
				for (int j = 0 ; j < arrayRepresentation.length; j++)
				{
					temp += arrayRepresentation[j];					
				}
				createWildCardCombinationsHelper(wildcardCombos, temp, numberOfWildCards - 1);
				arrayRepresentation[i] = placeHolder;
			}		
		}		
	}
	
	
	
	public static void main (String [] args)
	{				
				
		for (int i = 2 ; i < primes.length; i++)
		{
			if (primes[i])
			{
				int numberOfDigits = 0;
				int temp = i;
				while (temp != 0)
				{
					numberOfDigits ++;
					temp /= 10;
				}							
				for (int j = 1 ; j < numberOfDigits - 1; j ++)
				{
										
					ArrayList<String> combinations = createWildCardCombinations(i, j);					
					for (String combination : combinations)
					{
						int counter = 0;
						int smallestMemberOfSet = 1000000;
						for (int k = 0 ; k < 10 ; k++)
						{
							
							String tempString = combination.replaceAll("_", k + "");
							int number = Integer.parseInt(tempString);
							
							if (String.valueOf(number).length() < combination.length())
								continue;
							
							if (primes[number])
							{
								counter++;
								smallestMemberOfSet = Math.min(number, smallestMemberOfSet);
							}
						}
						if (counter == 8)
						{
							System.out.println(smallestMemberOfSet);
							System.out.println(combination);
							return;
						}
					}
					
				}
									
			}
		}
		
	}
}
