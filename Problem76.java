
public class Problem76 {

	public static long numberOfPossibleSummations(int n, int maxToSubtract, int[][]possibilities)
	{		
		if (n == 0)
		{
			return possibilities[0][0];
		}
			
		long answer = 0;
		for (int i = Math.min(maxToSubtract,  n); i > 0  ; i--)
		{						
			if (possibilities[n-i][i] == 0)
			{
				possibilities[n-i][i] += numberOfPossibleSummations(n- i, i, possibilities);
				answer += possibilities[n-i][i];
			}
			else 
			{
				answer += possibilities[n-i][i];
			}
		}
		return answer;
	}
	
	public static void main (String[] args)
	{
		int limit = 101;
		int [][] values = new int [limit + 1][limit];
				
		values[0][0] = 1;
		System.out.println(numberOfPossibleSummations(limit, limit-1, values));			
	}
	
}
