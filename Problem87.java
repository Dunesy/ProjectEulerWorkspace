import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;


public class Problem87 {

	// The smallest number expressible as the sum of a prime square, prime cube, and prime fourth power is 28.
	//In fact, there are exactly four numbers below fifty that can be expressed in such a way:
	
	//28 = 22 + 23 + 24
	//33 = 32 + 23 + 24
	//49 = 52 + 23 + 24
	//47 = 22 + 33 + 24

	public static void main (String [] args) { 
		
		ArrayList<Integer> primeList = PrimeFunctions.generatePrimeNumbers((int)Math.sqrt(50000000.0));
		TreeSet<Double> results = new TreeSet<Double>();
		
		// increment
		double primeSquare = 0.0;
		double primeCube = 0.0;
		double primePowerFour = 0.0;
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		for (a = 0 ; Math.pow(primeList.get(a),4) < 50000000.0 ; a++) {
			for (b = 0 ; Math.pow(primeList.get(b),3) < 50000000.0 ; b++) {
				for (c = 0; c < primeList.size() && Math.pow(primeList.get(c), 2) < 50000000.0; c++) {
					primeSquare = Math.pow(primeList.get(c), 2);
					primeCube = Math.pow(primeList.get(b), 3);
					primePowerFour = Math.pow(primeList.get(a), 4);
					
					if (primeSquare + primeCube + primePowerFour < 50000000.0) {
						results.add(primeSquare + primeCube + primePowerFour);
					}
					
				}									
			}
}
		
		System.out.println(results.size());
			
		
		
		
	}
	
}
