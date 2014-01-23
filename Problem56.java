import java.math.BigInteger;


public class Problem56 {
	
	public static int sumTheDigits(BigInteger bi)
	{
		String numberString = bi.toString();
		int sum = 0;
		for (int i = 0 ; i < numberString.length(); i++)
		{
			sum += Integer.parseInt(numberString.charAt(i) + "");
		}
		
		return sum;
	}
	
	public static void main (String []args)
	{
		
		int largestSum = 0;
		for (int i = 1 ; i <= 100 ; i ++)
		{
			for (int j = 1 ; j <= 100 ; j++)
			{
				BigInteger bi = new BigInteger(String.valueOf(i));
				bi = bi.pow(j);
				largestSum = Math.max(sumTheDigits(bi), largestSum);
			}
		}
		
		System.out.println(largestSum);
	}

}
