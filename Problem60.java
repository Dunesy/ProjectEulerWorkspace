import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problem60 {

public static void main(String [] args)
	{
		boolean[] primes = Problem58.generatePrimes(30000);
		boolean[] isPrimes = Problem58.generatePrimes(100000000);
		ArrayList<Integer> primeSet = new ArrayList<Integer>();			
		for (int i = 2 ; i < primes.length; i++)
		{
			if (primes[i])
			{
				primeSet.add(i);
			}
		}		
		
		ArrayList<Integer> primeTestSet = new ArrayList(primeSet);
		for (int i = 2 ; i < primes.length; i++)
		{
			if (isPrimes[i])
			{
				primeTestSet.add(i);
			}
		}		
						
		HashMap<Integer, Set<Integer>> map = evaluatePrimeCombos(isPrimes, primeSet, primeTestSet);				
		Set<Entry<Integer, Set<Integer>>> iterativeSet = map.entrySet();
		
		ArrayList<Pair> result = new ArrayList<Pair>();		
		for (Entry<Integer,Set<Integer>> e : iterativeSet)
		{
			result.add(new Pair(e.getKey(), e.getValue()));
		}
		
		Collections.sort(result, new Comparators().Pair);		
		
		int bestSum = 100000000;
		for (int i = result.size() - 1 ; i >= 0; i--)
		{												
				Set<Integer> s1 = result.get(i).value;	
				for (Integer setValue1 : s1)
				{					
					Set<Integer> s2 = setIntersection(s1, map.get(setValue1));
					for (Integer setValue2 : s2)
					{
						Set<Integer> s3 = setIntersection(s2, map.get(setValue2));						
						for (Integer setValue3 : s3)
						{							
							Set<Integer> s4 = setIntersection(s3, map.get(setValue3));							
							for (Integer setValue4 : s4)
							{											
								System.out.println(result.get(i).key + " " + setValue1 + " " + setValue2 + " " + setValue3 + " " + setValue4);
								bestSum = Math.min(setValue1 + result.get(i).key + setValue2 + setValue3 + setValue4, bestSum);
							}
						}
					}					
				}								
		}
		
		System.out.println(bestSum);
	}

public static Set<Integer> setIntersection(Set<Integer> s1, Set<Integer> s2)
{	
	Set<Integer> tempSet = new TreeSet<>(s1);
	tempSet.retainAll(s2);
	return tempSet;
}
		
public static HashMap<Integer, Set<Integer>> evaluatePrimeCombos(boolean[] primes, ArrayList<Integer> primeSet, ArrayList<Integer> primeTestSet) 
{
	HashMap<Integer, Set<Integer>> primeMap = new HashMap<Integer, Set<Integer>>();

	for (int i = 0; i < primeSet.size(); i++) {
		for (int j = primeSet.size() - 1; j > i; j--) {
			if (isConcatanatablePrimes(primeSet.get(i), primeSet.get(j),
					primes, primeTestSet)) {
				if (primeMap.containsKey(primeSet.get(i))) {
					Set<Integer> count = primeMap.get(primeSet.get(i));
					count.add(primeSet.get(j));
				} else {
					Set<Integer> newSet = new TreeSet<Integer>();
					newSet.add(primeSet.get(j));
					primeMap.put(primeSet.get(i), newSet);
				}

				if (primeMap.containsKey(primeSet.get(j))) {
					Set<Integer> count = primeMap.get(primeSet.get(j));
					count.add(primeSet.get(i));
				} else {
					Set<Integer> newSet = new TreeSet<Integer>();
					newSet.add(primeSet.get(i));
					primeMap.put(primeSet.get(j), newSet);
				}
			}
		}
	}
	return primeMap;
}

public static boolean isPrime(int number, boolean[] primes,
		ArrayList<Integer> primeTestSet) {
	if (number < primes.length)
		return primes[number];
	else {
		if (Collections.binarySearch(primeTestSet, number) == number) {
			return true;
		} else {
			return isPrime(number);
		}
	}
}

public static boolean isPrime(int n) {
	if (n <= 1)
		return false;
	if (n == 2)
		return true;
	if (n % 2 == 0)
		return false;
	if (n < 9)
		return true;
	if (n % 3 == 0)
		return false;
	if (n % 5 == 0)
		return false;

	int[] ar = new int[] { 2, 3 };
	for (int i = 0; i < ar.length; i++) {
		if (Witness(ar[i], n))
			return false;
	}
	return true;
}

private static boolean Witness(int a, int n) {
	int t = 0;
	int u = n - 1;
	while ((u & 1) == 0) {
		t++;
		u >>= 1;
	}

	long xi1 = ModularExp(a, u, n);
	long xi2;

	for (int i = 0; i < t; i++) {
		xi2 = xi1 * xi1 % n;
		if ((xi2 == 1) && (xi1 != 1) && (xi1 != (n - 1)))
			return true;
		xi1 = xi2;
	}
	if (xi1 != 1)
		return true;
	return false;
}

private static long ModularExp(int a, int b, int n) {
	long d = 1;
	int k = 0;
	while ((b >> k) > 0)
		k++;

	for (int i = k - 1; i >= 0; i--) {
		d = d * d % n;
		if (((b >> i) & 1) > 0)
			d = d * a % n;
	}

	return d;
}

public static boolean testSet(ArrayList<Integer> chosenPrimes,
		boolean[] primes, ArrayList<Integer> primeTestSet) {
	for (int i = 0; i < chosenPrimes.size(); i++) {
		for (int j = 0; j < chosenPrimes.size(); j++) {
			if (j != i) {
				if (!isConcatanatablePrimes(chosenPrimes.get(i),
						chosenPrimes.get(j), primes, primeTestSet))
					return false;
			}
		}
	}
	return true;
}

public static boolean isConcatanatablePrimes(int p1, int p2,
		boolean[] primes, ArrayList<Integer> primeSet) {
	String c1 = p1 + "" + p2;
	String c2 = p2 + "" + p1;

		try {
			if (isPrime(Integer.parseInt(c1), primes, primeSet)
					&& isPrime(Integer.parseInt(c2), primes, primeSet))
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}

	}

}
