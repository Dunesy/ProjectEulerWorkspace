import java.util.ArrayList;
import java.util.SortedSet;


public class Problem35 {

	
	
	public static ArrayList<Integer> calcCyclicPrimeNumbers(int n) 
	{
	    boolean[] isPrimeNumber = new boolean[n + 1]; // boolean defaults to
	    // false
	    ArrayList<Integer> primes = new ArrayList<Integer>();
	    for (int i = 2; i < n; i++) 
	    {
	      isPrimeNumber[i] = true;
	    }
	    for (int i = 2; i < n; i++) 
	    {
	      if (isPrimeNumber[i]) 
	      {	       
	        // now mark the multiple of i as non-prime number
	        for (int j = 2 * i; j < n; j+= i)
	        {	          
	        	  isPrimeNumber[j] = false;
	        }
	      }

	    }
	    for (int i = 2; i < n; i++) 
	    {	    	
		      if (isPrimeNumber[i]) 
		      {	    
		    	  int numberOfDigits = 0;
		    	  int temp = i;
		    	  boolean valid = true;
		    	  while (temp != 0)
		    	  {
		    		  numberOfDigits++;
		    		  if (temp % 10 == 0)
		    			  valid = false;
		    		  temp /= 10;		    		  
		    	  }
		    	  int counter = 0;
		    	  
		    	  temp = i;
		    	  while (counter < numberOfDigits)
		    	  {
		    		  temp = rotateNumber(temp);
		    		  if (!isPrimeNumber[temp])
		    		  {
		    			  valid = false;
		    		  }
		    		  counter ++;
		    	  }
		    	  if (valid)
		    	  {
		    		  primes.add(i);
		    	  }
		      }
	    }
	    return primes;	
	}
	
	public static int rotateNumber(int n)
	{
		
		int multiplier = 0;
		int temp = n;
		
		int firstDigit = 0, lastDigit = 0;
		while (temp != 0)
		{
			lastDigit = temp % 10;
			temp /= 10;
			multiplier++;					
		}
		temp = n;
		temp -= lastDigit  * (int)Math.pow(10, multiplier - 1);
		temp *= 10;
		temp += lastDigit;
		
		return temp; 
		
	}
	
	
	public static void main (String [] args )
	{
		System.out.println(calcCyclicPrimeNumbers(1000000).size());
	}
	
}
