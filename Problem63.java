import java.math.BigInteger;
import java.util.TreeSet;


public class Problem63 {

	
	public static void main (String [] args)
	{
		BigInteger base = new BigInteger("1");
		TreeSet<BigInteger> results = new TreeSet<BigInteger>(); 
		
		for (int i = 1 ; i < 10 ; i++)
		{
			base = new BigInteger(String.valueOf(i));
			
			int power = 1;
			BigInteger result = base.pow(power); 
			while (result.toString().length() == power)
			{								
				if (result.toString().length() == power)
					results.add(result);					
				power++;				
				result = base.pow(power);
			}
												
		}
		System.out.println(results.size());

	}
	
	
	
}
