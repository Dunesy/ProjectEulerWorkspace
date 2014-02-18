import java.math.BigInteger;
import java.util.ArrayList;


public class Problem65 {
	
	
	public static BigInteger continuedFractionForE(int convergentTerm)
	{
		String irrationalNumber;
		ArrayList<Integer> quotients = new ArrayList<Integer>();
		quotients.add(2);
		quotients.add(1);
		quotients.add(2);
		int term = 3;
		for (int i = 4 ; i <= convergentTerm; i++)
		{
			if (i % 3 == 0)
				quotients.add(i/ 3 * 2);
			else
				quotients.add(1);
				
			
		}
		System.out.println(quotients);
		
		BigInteger numerator = new BigInteger(String.valueOf(quotients.get(0)));
		BigInteger denominator = new BigInteger("1");
		int index = 1;		
		term = 1;
		BigInteger previousNumerator = new BigInteger("1");
		BigInteger previousDenominator = new BigInteger("0");
		BigInteger tempNumerator = new BigInteger("1");
		BigInteger tempDenominator = new BigInteger("1");
		do
		{
			tempNumerator = numerator.multiply(new BigInteger(String.valueOf(quotients.get(index)))).add(previousNumerator);
			tempDenominator = denominator.multiply(new BigInteger(String.valueOf(quotients.get(index)))).add(previousDenominator);
			
			previousNumerator = numerator;
			previousDenominator = denominator;
			
			numerator = tempNumerator;
			denominator = tempDenominator;
			System.out.println(numerator + "/" + denominator);
			index++;
			term ++;
		}while (term < convergentTerm);
		
		return numerator;
	}
	
	
	public static void main (String[] args)
	{
		
		BigInteger value = continuedFractionForE(10);
		String digits = value.toString();
		int sum = 0;
		for (int i = 0 ; i < digits.length(); i++)
		{
			sum += Integer.parseInt(digits.substring(i, i + 1));
		}
		
		System.out.println(sum);
	}

}
