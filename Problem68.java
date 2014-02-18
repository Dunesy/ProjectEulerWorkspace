import java.util.Set;
import java.util.TreeSet;


public class Problem68 
{
	
	public static Set<String> nGonRing(int digits, int n)
	{
		int[] ring = new int[digits + n];
		Set<String> solutionSet = new TreeSet<String>();
		nGonRingHelper(solutionSet, ring, 0, new boolean[digits + 1]);
		return solutionSet;
	}
	
	public static String convert(int[] ring)
	{
		String s = "";
		for (int i= 0 ; i < ring.length ; i++)
		{
			s += ring[i];
			if (i % 3 == 2 && i > 0)
				s+= ";";
		}
		return s;
	}	
	
	public static int[] rotateToNumericallyLowest(int[] ring)
	{
		int indexOfSmallest = 0 ;	
		for ( int i = 0 ; i < ring.length; i+= 3)
		{
			if (ring[i] < ring[indexOfSmallest])
			{
				indexOfSmallest = i;
			}			
		}				
		String ringString = "";
		int[] ringCopy = new int[ring.length];		
		//smallest
		int j = 0 ; 
		for (int i = indexOfSmallest ; i < indexOfSmallest + 3; i++)
		{
			ringCopy[j] = ring[i];
			j++;
		}
		//rightmost
		for (int i = indexOfSmallest + 3 ; i < ring.length; i++)
		{
			ringCopy[j] = ring[i];
			j++;
		}		
		//leftmost
		for (int i = 0 ; i < indexOfSmallest; i++)
		{
			ringCopy[j] = ring[i];
			j++;
		}
		
		
		return ringCopy;
	}
	
	public static boolean matchingSum(int[] currentRing)
	{
		int previousSum = 0;
		for (int i = 0 ; i < currentRing.length / 3; i++ )
		{
			int sum = 0;
			for (int j = i * 3 ; j < (i+1) * 3 ; j++)
			{
				 sum += currentRing[j];
			}
			if (previousSum != 0)
			{
				if (previousSum != sum)
					return false;
				
				previousSum = sum;
			}
			previousSum = sum;
		}
		return true;
	}
		
	public static boolean doSumsEqual(int[] currentRing, int index1, int index2)
	{
		int sum1 = 0;
		for (int i = index1 ; i >= index1 - 3; i-- )
		{
			sum1 += currentRing[i];
		}
		int sum2 = 0;
		for (int i = index2 -1 ; i >= index2 - 3; i-- )
		{
			sum2 += currentRing[i];
		}
		return (sum1 == sum2);	
	}
	
	public static void nGonRingHelper(Set<String> solutionSet, int[] currentRing, int ringIndex, boolean[] remainingDigits)
	{		
	
		if (ringIndex == currentRing.length)
		{	
			if (matchingSum(currentRing))
			{				
				solutionSet.add(convert(rotateToNumericallyLowest(currentRing)));
			}
		}
		else
		{
			if (ringIndex > 3 && ringIndex % 3 == 0)
			{
				if(!doSumsEqual(currentRing, ringIndex, ringIndex - 3))
					return;
			}
			
			if (ringIndex > 2 & ringIndex % 3 == 1)
			{
				currentRing[ringIndex] = currentRing[ringIndex -2];
				nGonRingHelper(solutionSet, currentRing, ringIndex + 1, remainingDigits);
			}
			else if(ringIndex == currentRing.length - 1)
			{
				currentRing[ringIndex] = currentRing[1];
				nGonRingHelper(solutionSet, currentRing, ringIndex + 1, remainingDigits);
			}
			else
			{
				for (int i = remainingDigits.length - 1; i >= 1; i--)
				{				
					if (!remainingDigits[i])
					{
						boolean[] remainingDigitsCopy = new boolean[remainingDigits.length];
						int[] currentRingCopy = new int[currentRing.length];
						
						System.arraycopy(remainingDigits, 0, remainingDigitsCopy, 0, remainingDigits.length);
						System.arraycopy(currentRing, 0, currentRingCopy, 0, currentRing.length);
						
						remainingDigitsCopy[i] = true;
						currentRingCopy[ringIndex] = i;
						nGonRingHelper(solutionSet, currentRingCopy, ringIndex + 1, remainingDigitsCopy);					
					}					
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(nGonRing(10,5).toString());
		System.out.println(System.currentTimeMillis() - startTime);
	}
	
}
