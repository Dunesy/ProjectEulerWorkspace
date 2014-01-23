import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;


public class Problem61 
{
	
		
	public static boolean compareFirstAndLastDigits(int n1, int n2)
	{
		String c1 = String.valueOf(n1);
		String c2 = String.valueOf(n2);
		
		if (c1.substring(c1.length() - 2).equals(c2.substring(0, 2)))
			return true;		
		return false;		
	}
	
	public static void main (String[] args)
	{
		double startTime = System.currentTimeMillis(); 				
		ArrayList<Integer> triangleSet = generateTriangleNumbers(10000);
		ArrayList<Integer> squareSet = generateSquareNumbers(10000);
		ArrayList<Integer> pentagonalSet = generatePentagonalNumbers(10000);
		ArrayList<Integer> hexagonalSet = generateHexagonalNumbers(10000);
		ArrayList<Integer> heptagonalSet = generateHeptagonalNumbers(10000);
		ArrayList<Integer> octagonalSet = generateOctagonalNumbers(10000);
				
		ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
		sets.add(triangleSet);
		sets.add(squareSet);
		sets.add(pentagonalSet);
		sets.add(hexagonalSet);
		sets.add(heptagonalSet);		
		
		for (int j = 0 ; j < octagonalSet.size(); j++)
		{
			ArrayList<Integer> currentSet = new ArrayList<Integer>();
			currentSet.add(octagonalSet.get(j));
			findNextMatchingNumbers(octagonalSet.get(j), currentSet, sets);
		}					
		
		System.out.println(System.currentTimeMillis() - startTime + "ms");
	}
	
	public static int findStartingIndex(ArrayList<Integer> set, int key)
	{
		boolean found = false;
		int begin = 0, end = set.size();
		int currentIndex = set.size() / 2;
		while (!found && Math.abs(end - begin) > 1)
		{
			if (set.get(currentIndex) == key)
				return currentIndex;
			else if (set.get(currentIndex) > key)
			{
				end = currentIndex;
				currentIndex = (end + begin) / 2;				
			}
			else
			{
				begin = currentIndex;
				currentIndex = (end + begin) / 2;
			}
		}
		return currentIndex;
	}
	
	public static void findNextMatchingNumbers(int number, ArrayList<Integer> currentSet ,ArrayList<ArrayList<Integer>> sets)
	{
		if (currentSet.size() == 6)
		{
				int sum = 0;
				System.out.println(currentSet);
				for (int x : currentSet)
				{
					sum+= x;
				}
				System.out.println(sum);
			
		}			
		else
		{
			String n1 = String.valueOf(number);
			int minRange = Integer.parseInt(n1.substring(n1.length() - 2)) * 100;
			int maxRange = minRange + 99;
			for (int i = 0 ; i < sets.size(); i++)
			{
				
				for (int j = findStartingIndex(sets.get(i), minRange) ; j < sets.get(i).size() && sets.get(i).get(j) < maxRange ; j++)
				{
					if (sets.get(i).get(j) >= minRange && sets.get(i).get(j) <= maxRange)
					{
						ArrayList<ArrayList<Integer>> setCopy = new ArrayList<ArrayList<Integer>>(sets);
						setCopy.remove(sets.get(i));
						
						if (currentSet.size() == 5 &&compareFirstAndLastDigits(currentSet.get(currentSet.size() -1), currentSet.get(0)))
						{
							int sum = 0;
						}
						else
						{
							
						}
						
						ArrayList<Integer> currentSetCopy = new ArrayList<Integer>(currentSet);
						currentSetCopy.add(sets.get(i).get(j));
						
						findNextMatchingNumbers(sets.get(i).get(j), currentSetCopy, setCopy);
					}
				}
			}
		}		
	}
	
	public static ArrayList<Integer> generateTriangleNumbers(int N)
	{
		ArrayList<Integer> triangleNumbers = new ArrayList<Integer>();
		int currentTriangleNumber = 1;
		int n = 1;
		while (currentTriangleNumber < N)
		{
			currentTriangleNumber = n * (n + 1) / 2;
			if (currentTriangleNumber > 1000 && currentTriangleNumber < N)
				triangleNumbers.add(currentTriangleNumber);		
			n++;
		}
		return triangleNumbers;		
	}
	
	public static ArrayList<Integer> generateSquareNumbers(int N)
	{
		ArrayList<Integer> squareNumbers = new ArrayList<Integer>();
		int currentSquareNumber = 1;
		int n = 1;
		while (currentSquareNumber < N)
		{
			currentSquareNumber = n * n;
			if (currentSquareNumber > 1000 && currentSquareNumber < N)
				squareNumbers.add(currentSquareNumber);
			n++;
		}
		return squareNumbers;		
	}

	public static ArrayList<Integer> generatePentagonalNumbers(int N)
	{
		ArrayList<Integer> pentagonalNumbers = new ArrayList<Integer>();
		int currentPentagonalNumbers = 1;
		int n = 1;
		while (currentPentagonalNumbers < N)
		{
			currentPentagonalNumbers = n * (3 * n - 1) / 2;
			if (currentPentagonalNumbers > 1000 && currentPentagonalNumbers < N)
				pentagonalNumbers.add(currentPentagonalNumbers);
			n++;
		}
		return pentagonalNumbers;		
	}
	
	public static ArrayList<Integer> generateHexagonalNumbers(int N)
	{
		ArrayList<Integer> hexagonalNumbers = new ArrayList<Integer>();
		int currentHexagonalNumbers = 1;
		int n = 1;
		while (currentHexagonalNumbers < N)
		{
			currentHexagonalNumbers = n * (2 * n - 1);
			if (currentHexagonalNumbers > 1000 && currentHexagonalNumbers < N)
				hexagonalNumbers.add(currentHexagonalNumbers);
			n++;
		}
		return hexagonalNumbers;		
	}
	
	public static ArrayList<Integer> generateHeptagonalNumbers(int N)
	{
		ArrayList<Integer> heptagonalNumbers = new ArrayList<Integer>();
		int currentHeptagonalNumber = 1;
		int n = 1;
		while (currentHeptagonalNumber < N)
		{
			currentHeptagonalNumber = n * (5 * n - 3) / 2;
			if (currentHeptagonalNumber > 1000 && currentHeptagonalNumber < N)
				heptagonalNumbers.add(currentHeptagonalNumber);
			n++;
		}
		return heptagonalNumbers;
	}
	
	public static ArrayList<Integer> generateOctagonalNumbers(int N)
	{
		ArrayList<Integer> ocatagonalNumbers = new ArrayList<Integer>();
		int currentOctagonalNumber = 1;
		int n = 1;
		while (currentOctagonalNumber < N)
		{
			currentOctagonalNumber = n * (3 * n - 2);
			if (currentOctagonalNumber > 1000 && currentOctagonalNumber < N)
				ocatagonalNumbers.add(currentOctagonalNumber);
			n++;
		}
		return ocatagonalNumbers;
	}
	
		
	
}
