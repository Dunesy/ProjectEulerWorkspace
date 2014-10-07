import java.util.ArrayList;
import java.util.HashMap;


public class Problem90 {

	public static HashMap<String, Integer> sets = new HashMap<String, Integer>(); 
	
	public static void containsAllSquares() {		
				
	}
	
	public static void recursiveSolver(String currentString,  ArrayList<Integer> digits) { 
		
		if (currentString.length() == 6) {
			
			
		}
		
		for (int i = 0 ; i < digits.size() - 6 - currentString.length() ; i++) {
			
			ArrayList<Integer> digitsClone = (ArrayList<Integer>)digits.clone();
			
			currentString += digits.get(i);
			while (digitsClone.get(0) == digits.get(i)) {
				digitsClone.remove(0);
			}
			digitsClone.remove(0);
			recursiveSolver(currentString, digitsClone);
		}
		
	}
	
	//01, 04, 09, 16, 25, 36, 49, 64, 81
	
	public static void main (String []  args) {
		
		
		
		
	}
	
	
}
