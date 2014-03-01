import java.io.IOException;
import java.util.ArrayList;


public class Problem82 {
	
		
	public static int ThreeWaySolution(int x, int y, int destX, int destY, int previousX, int[][]map, int[][]summationsTable)
	{				
		
		System.out.println(x + " " + y);
		if (x < 0 || y < 0 || x == map.length || y == map.length )
			return Integer.MAX_VALUE/2;				
		
		if (x == destX && y == destY || summationsTable[x][y] > 0)
		{
			return summationsTable[x][y];
		}		
		else
		{	
			int resultUp = Integer.MAX_VALUE/2;
			int resultDown = Integer.MAX_VALUE/2;
			if (previousX != x - 1)
			{
				resultUp =  map[x][y] + ThreeWaySolution(x-1, y, destX, destY, x, map,summationsTable);
			}
			if (previousX != x + 1)
			{
				resultDown = map[x][y] + ThreeWaySolution(x+1, y, destX, destY,x, map,summationsTable);
			}			
			int resultLeft = map[x][y] + ThreeWaySolution(x, y-1, destX, destY,x, map, summationsTable);
		
			summationsTable[x][y] = Math.min(resultUp, Math.min(resultDown, resultLeft));			
		}		
		return summationsTable[x][y];
	}
	
		
	public static int processThreeWaySolution(int x, int destX, int[][] map, int[][] summationsTable)
	{
		//Starting Point Process the first Line
		summationsTable[x][0] = map[x][0];
		for (int i = x; i >= 0 ; i--)
		{			
			if (i == x)
				continue;
			summationsTable[i][0] = summationsTable[i + 1][0] + map[i][0];
			//System.out.println(summationsTable[i][0]);
		}
		for (int i = x; i < map.length; i++)
		{
			if (i == x)
				continue;
			summationsTable[i][0] = summationsTable[i - 1][0] + map[i][0];
			//System.out.println(summationsTable[i][0]);
		}
				
		int y = 1;
		while (y < map.length)
		{
			for (int i = 0 ; i < map.length; i++)
			{
				summationsTable[i][y] = summationsTable[i][y - 1] + map[i][y];
			}
			
			for (int i = 1 ; i < map.length; i++)
			{											
				summationsTable[i][y] = Math.min(summationsTable[i][y], summationsTable[i - 1][y] + map[i][y]);												
			}
			for (int i = map.length - 2  ; i >= 0; i--)
			{				
				summationsTable[i][y] = Math.min(summationsTable[i][y], summationsTable[i + 1][y] + map[i][y]);			
			}
			y++;
		}
		
		
		return summationsTable[destX][map.length-1];
	}
	
	
	public static void main (String[] args) throws IOException
	{
		//Minimal Path Sum
		long startTime = System.currentTimeMillis();
		ArrayList<String> strings = Problem81.readFile("I:\\Project Euler Workspace\\Problem26\\src\\matrix.txt");
		String[] testString = strings.get(0).split(",");
		int[][] map = new int[strings.size()][testString.length];
		int[][] summationsTable = new int[map.length][map[0].length];
		
		int i = 0;
		
		for(String s : strings)
		{
			String[] row = s.split(",");
			for (int j = 0 ; j < row.length; j++)
			{
				map[i][j] = Integer.parseInt(row[j]);
			}
			i++;
		}		
		int bestSum = Integer.MAX_VALUE/2;
		for (i = 0 ; i < map.length ; i++)
		{
			for (int j = 0 ; j < map.length; j ++)
			{
				summationsTable[i][0] = map[i][0];
				bestSum = Math.min(bestSum, processThreeWaySolution(i, j,map, summationsTable));
				summationsTable = new int[map.length][map.length];
			}
		}
		System.out.println(bestSum);
	}
	
}
