
public class Problem28 
{
	
	
	public static int functionalSolution(int x)
	{
		int total = 0;
		for (int i = 0 ; i < x ; i++)
		{
			if (i == 0)
				total += 1;
			else
			{
				total += 4 * (2 * i + 1) * (2 * i + 1) - 12 * i;
			}
			
		}
		return total;
		
	}
	
	public static void main (String[] args)
	{
		
		int [][] grid = new int[1001][1001];		
		int i = 500;
		int j = 500;
		int currentNumber = 1;
		int direction  = 1;
		
		//Startup
		grid[500][500] = currentNumber;
		
		do
		{	
			currentNumber++;	
			if (direction == 1) // EAST
			{
				if (i < 1001)
				{
					i++;
					grid[i][j] = currentNumber;
				}
				if (grid[i][j + 1] == 0 || i == 1000)
				{
					direction = 2;
				}				
			}
			else if (direction == 2) // SOUTH
			{
				if (j < 1001)
				{
					j++;
					grid[i][j] = currentNumber;				
				}
				if (grid[i - 1][j] == 0 || j == 1000)
				{
					direction = 3;
				}		
				
			}
			else if (direction == 3) // WEST
			{
				if (i > 0)
				{
					i--;
					grid[i][j] = currentNumber;				
				}
				if (grid[i][j - 1] == 0 || i == 0)
				{
					direction = 4;
				}		
				
			}
			else if (direction == 4) // NORTH
			{
				if (j > 0)
				{
					j--;				
					grid[i][j] = currentNumber;
				}
				if (grid[i + 1][j] == 0 || j == 0)
				{
					direction = 1;
				}		
				
			}						
		} while (i != 1000 || j != 0);
		
		i = 0;
		j = 0;
		int sum = 0;
		
		for (i = 0 ; i < 5; i++)
		{
			for (j  = 0 ; j < 5 ; j++)
			{
				System.out.print(grid[j][i] + " ");
			}
			System.out.println();
		}
		
		i = 0;
		j = 0;
		do
		{
			
			sum += grid[i][j] + grid[1000 - i][j];
			i++;
			j++;
					
		} while(i != 1001 && j != 1001);
		
		sum -= 1;
		System.out.println(sum);
		
		System.out.println(grid.toString());
		
	}		
		
}
