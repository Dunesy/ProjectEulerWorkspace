import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;


public class Problem42
{

	public static char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	public static SortedSet<Integer> generateTriangleNumbers(double n)
	{
		SortedSet<Integer> triangleNumbers = new TreeSet<Integer>();
		
		for (int i = 0 ; i <= n ; i++ )
		{
			triangleNumbers.add((int)(0.5 * i * (i + 1)) );
		}
		return triangleNumbers;
	}
	
	public static int convertWordToNumericValue(String word)
	{
		int value = 0;
		for (int i = 0 ; i < word.length() ; i++)
		{
			for (int j = 0 ; j < alphabet.length ; j++)
			{
				if (alphabet[j] == word.charAt(i))
				{
					value += j + 1;
					break;
				}
			}
		}
		return value;	
	}
	
	
	 public static void main (String[] args) throws IOException
	 {
		 SortedSet<Integer> triangleNumbers = generateTriangleNumbers(200.0); 
		 System.out.println(triangleNumbers.last());
		 int numberOfTriangleWords = 0;
		 try 
		 {
			BufferedReader in= new BufferedReader(new FileReader("D:\\EclipseWorkSpace\\ProjectEuler\\src\\words.txt"));
			StringBuilder sb = new StringBuilder("");
			while (in.ready())
			{
				char nextCharacter = (char) in.read();
				if (nextCharacter == ',')
				{
					if (triangleNumbers.contains(convertWordToNumericValue(sb.toString())))
					{
						numberOfTriangleWords++;
					}
					sb = new StringBuilder("");
				}
				else if (nextCharacter != '"')
				{
					sb.append(nextCharacter);
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		 System.out.println(numberOfTriangleWords);
		 
	 }
	
}
