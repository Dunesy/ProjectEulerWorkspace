import java.math.BigInteger;


public class Problem48
{

	public static BigInteger calculateSeries(int seriesSize)
	{
		BigInteger bi = new BigInteger("0");
		for (int i = 1 ; i <= seriesSize ; i++)
		{
			BigInteger temp = new BigInteger("" + i);
			temp = temp.pow(i);
			bi = bi.add(temp);
		}
		
		return bi;
	}
	
	
	public static void main (String[] args)
	{
		BigInteger series = calculateSeries(1000);
		String sequence = series.toString(0);
		
		for (int i = sequence.length() - 10; i <  sequence.length(); i++)
		{
			System.out.print(sequence.charAt(i));
		}
		System.out.println("");
		for (int i = 0 ; i < 10; i++)
		{
			System.out.print(sequence.charAt(i));
		}
	}
	
}
