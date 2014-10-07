import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;


public class Problem88 {

/*
A natural number, N, that can be written as the sum and product of a given set of at least two natural numbers, 
{a1, a2, ... , ak} is called a product-sum number: N = a1 + a2 + ... + ak = a1 × a2 × ... × ak.

For example, 6 = 1 + 2 + 3 = 1 × 2 × 3.

For a given set of size, k, we shall call the smallest N with this property a minimal product-sum number.
The minimal product-sum numbers for sets of size, k = 2, 3, 4, 5, and 6 are as follows.

k=2: 4 = 2 × 2 = 2 + 2
k=3: 6 = 1 × 2 × 3 = 1 + 2 + 3
k=4: 8 = 1 × 1 × 2 × 4 = 1 + 1 + 2 + 4
k=5: 8 = 1 × 1 × 2 × 2 × 2 = 1 + 1 + 2 + 2 + 2
k=6: 12 = 1 × 1 × 1 × 1 × 2 × 6 = 1 + 1 + 1 + 1 + 2 + 6

Hence for 2 < k < 6, the sum of all the minimal product-sum numbers is 4+6+8+12 = 30; note that 8 is only counted once in the sum.

In fact, as the complete set of minimal product-sum numbers for 2< k < 12 is {4, 6, 8, 12, 15, 16}, the sum is 61.

What is the sum of all the minimal product-sum numbers for 2 < k < 12000?
 
*/	

	public static int[] kResults = new int[12000 + 1];
	
	public static ArrayList<Integer> getDivisors(int n) {
		
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		
		for (int i = 2 ; i <= n / 2; i ++) {
			if (n % i == 0)
				divisors.add(i);
		}		
		
		return divisors;
	}
		
	public static ArrayList<Integer> getDivisors2(int n) {
		
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		
		for (int i = 2 ; i <= n / 2; i ++) {
			if (n % i == 0)
				divisors.add(i);
		}		
		divisors.add(n);
		return divisors;
	}
		
	public static int calculateSum(int[] values) {
		int sum = 0;
		for (int i = 0 ; i < values.length; i++) {
			if (values[i] != 1) {
				sum += values[i];
			}
			else {
				sum += values.length - i - 1;
				break;
			}
		}
		return sum ;
	}
	
	public static int calculateProduct(int[] values) {
		int product = 1;
		for (int i = 0 ; i < values.length; i++) {
			if (values[i] != 1) {
				product *= values[i];
			}
			else {				
				break;
			}
		}
		return product ;
	}
	public static TreeSet<Integer> set = new TreeSet<Integer>();
	
	public static void recursiveSolver(int initialValue, ArrayList<Integer> factors, int value) {
		
		ArrayList<Integer> divisors = getDivisors(value);
			if (factors.size() > 0) {
			int sum = 0 ;
			
			for (int afactor : factors) {				
				sum += afactor;
			}
			sum += value;
			if (sum == initialValue && kResults[factors.size()] == 0) {
				kResults[factors.size()] = initialValue;
				set.add(initialValue);
			} else {
				int k = factors.size() + 1 + initialValue - sum;
				if (k > 0 && k <= 12000 && kResults[k] == 0) {
					kResults[k] = initialValue;
					set.add(initialValue);
				}
			}
		}
		for (int aFactor : divisors) {
			ArrayList<Integer> factorClone = (ArrayList<Integer>)factors.clone();
			factorClone.add(aFactor);
			recursiveSolver(initialValue, factorClone, value / aFactor);
		}
	}
	
	
	public static void main (String[] args) {
							
		int n = 4;
		while ( n <= 24000 ) {
			
			if (!PrimeFunctions.isPrime(n))
			{
				ArrayList<Integer> divisors = getDivisors(n);
				recursiveSolver(n, new ArrayList<Integer>(), n);						
			}
			n++;
		}				
		
		int sum2 = 0 ; 
		for (int data : set) {			
			sum2 += data;
		}
		
		System.out.println(sum2);
	
	}
	
	
}
