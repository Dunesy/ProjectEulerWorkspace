import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Problem81 
{

	public static ArrayList<String> readFile(String filename) throws IOException 
	{
		try 
		{
			BufferedReader br  = new BufferedReader(new FileReader(filename));
			ArrayList<String> strings = new ArrayList<String>();
			while (br.ready())
			{				
				strings.add(br.readLine());				
			}
			return strings;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//Recursive Solution that uses Memoization
	public static int TwoWaySolution(int x, int y, int[][]map, int[][]summationsTable)
	{				
		if (x == 0 && y == 0 || summationsTable[x][y] > 0)
		{
			return summationsTable[x][y];
		}
		else
		{						
			if (x == 0)
			{		
				summationsTable[x][y] = map[x][y] + TwoWaySolution(x, y-1, map, summationsTable);							
			}
			else if (y == 0)
			{			
				summationsTable[x][y] = map[x][y] + TwoWaySolution(x-1, y, map, summationsTable);								
			}
			else
			{
				summationsTable[x][y] = Math.min(map[x][y] + TwoWaySolution(x-1, y, map, summationsTable), map[x][y] + TwoWaySolution(x, y-1, map, summationsTable));
			}			
		}		
		return summationsTable[x][y];
	}
	
	public static void main (String [] args) throws IOException
	{
		//Minimal Path Sum
		long startTime = System.currentTimeMillis();
		ArrayList<String> strings = readFile("I:\\Project Euler Workspace\\Problem26\\src\\matrix.txt");
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
		summationsTable[0][0] = map[0][0];
		System.out.println(TwoWaySolution(map.length - 1, map[0].length - 1, map, summationsTable));
		System.out.println(System.currentTimeMillis() - startTime);			
	}
	
}
