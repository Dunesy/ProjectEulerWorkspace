import java.math.BigInteger;


public class Problem53 
{
	
	public static BigInteger combinatoric (String number, String choices)
	{
		BigInteger n = new BigInteger("1");
		
		int num = Integer.parseInt(number);
		int choiceValue = Integer.parseInt(choices);
		
		for (int i = 1 ; i <= num; i++)
		{
			n = n.multiply(new BigInteger(String.valueOf(i)));
		}
		
		BigInteger nminusr = new BigInteger("1");
		for (int i = 1 ; i <= num - choiceValue; i++ )
		{
			nminusr = nminusr.multiply(new BigInteger(String.valueOf(i)));		
		}
		
		BigInteger r = new BigInteger("1");
		for (int i = 1 ; i <= choiceValue; i++ )
		{
			r = r.multiply(new BigInteger(String.valueOf(i)));		
		}
		
							
		return n.divide(r.multiply(nminusr));
			
			
			
	}
		
	
	
	public static void main (String[] args)
	{
			
		int counter = 0;
		for (int i = 1 ; i <= 100 ; i++)
		{
			for ( int j = 1 ; j <= 100 ; j++)
			{
				if (combinatoric(String.valueOf(i), String.valueOf(j)).toString().length() >= 7)
					counter ++;
			}
		}
		
		System.out.println(counter);
		
	}
	
}
