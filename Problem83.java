//Dijkstra's Algorithm Seems to be Best Fit here
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem83 
{
	
	public static int DijkstrasShortestPath(int destX, int destY, MinHeap heap, int[][] map)
	{		
		while (true)		
		{						
			Node top = (Node)heap.peekMin();
			//System.out.println(top.coordinatex + " " + top.coordinatey + " " + top.weight);
			if (top.coordinatex == destX && top.coordinatey == destY)
			{
				return top.weight;
			}
			for (Node n : top.adjacentNodes)
			{			
				int index = heap.getIndex(n);
				heap.change(index,  Math.min(top.weight + map[n.coordinatex][n.coordinatey], n.weight));				
			}
			heap.remove();						
		}
					
	}
	
	public static void main (String[] args) throws IOException
	{
		
		
		MinHeap heap = new MinHeap();		
		long startTime = System.currentTimeMillis();
		ArrayList<String> strings = Problem81.readFile("I:\\Project Euler Workspace\\Problem26\\src\\matrix.txt");
		String[] testString = strings.get(0).split(",");
		
		int[][] map = new int[strings.size()][testString.length];				
		Node[][] nodeMap = new Node[80][80];		
		int i = 0;				
		//Building the Heap and Graph
		for(String s : strings)
		{
			String[] row = s.split(",");
			for (int j = 0 ; j < row.length; j++)
			{
				map[i][j] = Integer.parseInt(row[j]);
				//Set the Weight of the Nodes to Infinite
				Node n = new Node(Integer.MAX_VALUE/2, i, j);
				if (i == 0 && j == 0)
				{
					n.weight = map[i][j];
				}
				heap.add(n);
				nodeMap[i][j] = n;
			}
			i++;
		}		
		
		for ( i = 0 ; i < nodeMap.length; i++)
		{
			for (int j = 0 ; j < nodeMap.length ; j++)
			{
				if (i < nodeMap.length - 1)
					nodeMap[i][j].adjacentNodes.add(nodeMap[i+1][j]);				
				if (i > 0)
					nodeMap[i][j].adjacentNodes.add(nodeMap[i-1][j]);
				if (j < nodeMap.length - 1)
					nodeMap[i][j].adjacentNodes.add(nodeMap[i][j+1]);
				if (j > 0)
					nodeMap[i][j].adjacentNodes.add(nodeMap[i][j-1]);
			}
		}
		
		//Performing Dijkstra's ALgorithm
		System.out.println(DijkstrasShortestPath(79, 79, heap, map));
		System.out.println(System.currentTimeMillis() - startTime + " ms");
	}
	
}
