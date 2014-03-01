import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;


public class Problem79 
{	
	static Comparator<Vertex<Integer>> listComparer = new Comparator<Vertex<Integer>>()
	{					
		@Override
		public int compare(Vertex<Integer> arg0,
				Vertex<Integer> arg1) {
				if (arg0.depth < arg1.depth) 
					return -1;
				else if (arg0.depth > arg1.depth)
					return 1;
				
			return 0;
		}};		
		
	public static String[] readFile(String filename) throws IOException 
	{
		try 
		{
			BufferedReader br  = new BufferedReader(new FileReader(filename));
			String readString = "";
			while (br.ready())
			{				
				readString += br.readLine() + " ";				
			}
			return readString.split(" ");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Vertex<Integer>> buildDirectedGraph(ArrayList<String> codes)
	{
		ArrayList<Vertex<Integer>> vertexList = new ArrayList<Vertex<Integer>>();		
		for (int i = 0 ; i < codes.size(); i++)
		{
			String code = codes.get(i);
			int currentSearchableDepth = 0;
			if (code.equals("319"))
			{
				System.out.println("here");
			}
			for (int j = 0 ; j < code.length() - 1; j++)				
			{
				// Find first instance of node.
				Vertex<Integer> searchedVertex = null;
				Vertex<Integer> adjacentVertex = null;
				int value = Integer.parseInt(code.substring(j, j + 1));								
				
				if (searchedVertex == null)
				{
					for (Vertex<Integer> v : vertexList)
					{					
						if (v.value == value && currentSearchableDepth <= v.depth)
						{
							searchedVertex = v;
							currentSearchableDepth = v.depth;
							break;
						}
					}
				}
				if (searchedVertex == null)	
				{
					searchedVertex = new Vertex<Integer>(value);					
					vertexList.add(searchedVertex);
				}				
				
				//Search Adjacency
				int adjacentValue = Integer.parseInt(code.substring(j + 1, j + 2));
				for (Vertex<Integer> v : searchedVertex.adjacency)
				{
					if (v.value == adjacentValue)
					{
						adjacentVertex = v;
						break;
					}
				}
				if (adjacentVertex == null)
				{
					for (Vertex<Integer> v : vertexList)
					{
						if (v.value == adjacentValue  && (currentSearchableDepth <= v.depth) && v != searchedVertex)
						{
							adjacentVertex = v;
							searchedVertex.adjacency.add(v);
							v.depth = Math.max(searchedVertex.depth + 1, v.depth);
							currentSearchableDepth = v.depth;
							setDepthsOfNode(v, v.depth);
							break;
						}
					}					
				}
				
				if (adjacentVertex == null)
				{
					adjacentVertex = new Vertex<Integer>(adjacentValue); 
					searchedVertex.adjacency.add(adjacentVertex);
					adjacentVertex.depth = searchedVertex.depth + 1;
					vertexList.add(adjacentVertex);
				}
				searchedVertex = adjacentVertex;
			}
		}	
		return vertexList;
	}
		
	public static void setDepthsOfNode(Vertex<Integer> node, int depth)
	{
		for (Vertex<Integer> vertex : node.adjacency)
		{
			vertex.depth = depth + 1;
			setDepthsOfNode(vertex , vertex.depth);
		}
	}
	
	public static void main(String [] args) throws IOException
	{
		long startTime = System.currentTimeMillis();
		
		String[] loginCodes = readFile("I:\\Project Euler Workspace\\Problem26\\src\\keylog.txt");				 		
		TreeSet<String> uniqueCodes = new TreeSet<String>();
		ArrayList<String> codes = new ArrayList<String>(); 
				
		for (String s: loginCodes)
		{
			if (uniqueCodes.add(s))
			{
				codes.add(s);
			}
		}					
		ArrayList<Vertex<Integer>> list = buildDirectedGraph(codes);		
		Collections.sort(list, listComparer);		
		for (Vertex<Integer> v : list)
		{		
			System.out.println(v.toString());
		}
		
		System.out.println(System.currentTimeMillis() - startTime + " ms");
		
	}
}
