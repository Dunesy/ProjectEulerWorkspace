import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/***
 * Parses Roman Numeral Strings and Interprets into a Numeric Value
 * Also provides an economic equivalent version of the answer.
 * @author Dune
 *
 */
public class RomanNumeralParser {

	public static HashMap<Character, Integer> valueMap = new HashMap<Character, Integer>();
	
	public static void initialize() { 
			
		valueMap.put('I', 1);
		valueMap.put('V', 5);
		valueMap.put('X', 10);
		valueMap.put('L', 50);
		valueMap.put('C', 100);
		valueMap.put('D', 500);
		valueMap.put('M', 1000);
		
	}
	
	public static int parseRomanNumeral(String romanNumeral) {
	
		char[] romanNumerals = romanNumeral.toCharArray();
		int result = 0;
		for (int i = 0 ; i < romanNumerals.length; i++) {
			if (i < romanNumerals.length - 1) {				
				//Check for Subtractive Cases								
				if (romanNumerals[i] == 'I' && romanNumerals[i + 1] == 'V' || romanNumerals[i] == 'I' && romanNumerals[i+1] == 'X') {				
						result += valueMap.get(romanNumerals[i + 1]) - valueMap.get(romanNumerals[i]);	
						i ++;
					}					
				 
				else if (romanNumerals[i] == 'X' && romanNumerals[i+1] == 'L' || romanNumerals[i] == 'X' && romanNumerals[i+1] == 'C') {					
						result += valueMap.get(romanNumerals[i + 1]) - valueMap.get(romanNumerals[i]);
						i ++;
					}		
				
				else if (romanNumerals[i] == 'C' && romanNumerals[i + 1] == 'D' || romanNumerals[i] == 'C' && romanNumerals[i+1] == 'M') {					
						result += valueMap.get(romanNumerals[i + 1]) - valueMap.get(romanNumerals[i]);
						i ++;
					}
				 else if (valueMap.get(romanNumerals[i+1]) > valueMap.get(romanNumerals[i])) {
					System.out.println("Invalid Roman Numeral Detected");
					return 0;
				} else {
					result += valueMap.get(romanNumerals[i]);
				}
			} else {
				result += valueMap.get(romanNumerals[i]);
			}			
		}				
		return result;
	}
	
	public static String createEconomicRomanNumeral(int number) { 
		
		String romanNumeral = "";
		while (number > 0) {
			if (number >= 1000) {
				number -= 1000;
				romanNumeral += "M";
			}
			else if (number - (number % 100) == 900) {
				number -= 900;
				romanNumeral +="CM";
			}
			else if (number >= 500) {
				number -= 500;
				romanNumeral += "D";
			}
			else if (number - (number % 100) == 400) {
				number -= 400;
				romanNumeral += "CD";
			}
			else if (number >= 100) { 
				number -= 100;
				romanNumeral += "C";
			}
			else if (number - (number % 10) == 90) {
				number -= 90;
				romanNumeral += "XC";
			}
			else if (number >= 50) {
				number -= 50;
				romanNumeral += "L" ;
			}
			else if (number - (number % 10) == 40) {
				number -= 40;
				romanNumeral += "XC";
			}
			else if (number >= 10) {
				number -= 10;
				romanNumeral += "X";
			}
			else if (number == 9) {
				number -= 9;
				romanNumeral += "IX";
			}
			else if (number >= 5) {
				number -= 5;
				romanNumeral += "V";
			}
			else if (number == 4) {
				number -= 4;
				romanNumeral += "IV";
			}
			else if (number > 0) {
				number --;
				romanNumeral += "I";
			}
		}
		return romanNumeral;
		
	}
	
	public static void main (String [] args) {		
		initialize();		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:/EclipseWorkSpace/ProjectEuler/src/p089_roman.txt"));
		
			int result = 0;
			while (br.ready()) {
				
				String romanNumeral = br.readLine();
				int initialLength = romanNumeral.length();				
				int economicLength = createEconomicRomanNumeral(parseRomanNumeral(romanNumeral)).length();
				
				result += initialLength - economicLength;
			}
		
			System.out.println(result);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 
	}
}