import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.TreeSet;


public class Problem59 
{
	
	
	public static int XOR(String value, char key)
	{
		BigInteger bi = new BigInteger(value);
		int ascii = (int)key;
		BigInteger biKey = new BigInteger(String.valueOf(ascii));
		
		return bi.xor(biKey).intValue();
	}
	
	
	
	public static void main(String [] args) throws IOException
	{
		
		TreeSet<String> dictionary = new TreeSet<String>();
		String cipher = "abcdefghijklmnopqrstuvwxyz";
		
		
		
		try {			
			
			BufferedReader br = new BufferedReader(new FileReader("I:\\Project Euler Workspace\\Problem26\\src\\cipher1.txt"));
			char[] buffer = new char[120000];
			String stringBuffer = "";
			br.read(buffer);
			br.close();
									
			for (int i = 0 ; i < buffer.length; i++)
			{
				stringBuffer += buffer[i];
			}
			
			String[] splitCharacters = stringBuffer.split(",");
			for (int i = 0 ;  i < splitCharacters.length; i++)
			{
				splitCharacters[i] = splitCharacters[i].replaceAll("\n", "").trim();
			}
			
			buffer = new char[100000];
			BufferedReader wordReader = new BufferedReader(new FileReader("I:\\Project Euler Workspace\\Problem26\\src\\words.txt"));
			wordReader.read(buffer);
			wordReader.close();
			
			stringBuffer = "";
			
			for (int i = 0 ; i < buffer.length; i++)
			{
				stringBuffer += buffer[i];
			}

			
			String[] wordsCollection = stringBuffer.split(",");
			
			for (int i = 0 ; i < wordsCollection.length ; i++)
			{
				wordsCollection[i] = wordsCollection[i].replaceAll("\"", "");				
				dictionary.add(wordsCollection[i]);
			}
			int largestNumberOfWords = 0;
			char[] bestCipher = new char[3];
			for (int i = 0 ; i < cipher.length() ; i++)
			{
				for (int j = 0 ; j < cipher.length(); j++)
				{		
					
					for (int k = 0 ; k < cipher.length(); k++)
					{
						char[] key = new char[3];
						key[0] = cipher.charAt(i);
						key[1] = cipher.charAt(j);
						key[2] = cipher.charAt(k);
								
						String builtString = "";
						for (int x = 0 ; x < splitCharacters.length; x ++)
						{
							int toBeConverted = XOR(splitCharacters[x], key[x%3]);										
							builtString += (char)toBeConverted;							
						}
						
						String[] potentialWords = builtString.split(" ");
						
						
						int counter = 0;
						for (String word : potentialWords)
						{
							if (dictionary.contains(word.toUpperCase()))
							{
								counter++;	
							}							
						}
						if (counter > largestNumberOfWords)
						{
							largestNumberOfWords = counter;	
							bestCipher[0] = cipher.charAt(i);
							bestCipher[1] = cipher.charAt(j);
							bestCipher[2] = cipher.charAt(k);
							System.out.println(bestCipher[0] + " " + bestCipher[1] + " " + bestCipher[2]);
						}												
					}
				}				
			}
			
			
			
			int sum = 0;
			for (int x = 0 ; x < splitCharacters.length; x ++)
			{
				sum += XOR(splitCharacters[x], bestCipher[x%3]);		
				System.out.print((char)XOR(splitCharacters[x], bestCipher[x%3]));
			}
			
			System.out.println(sum);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
