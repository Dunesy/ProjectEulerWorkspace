import java.util.ArrayList;

public class Vertex<T>
{
	public static int auto_key = 0;
	public int key;		
	public T value;
	public ArrayList<Vertex<T>> adjacency;
	public int depth;
		
	public Vertex(T aValue)
	{
		adjacency = new ArrayList<Vertex<T>>();
		this.key = auto_key++;
		this.value = aValue;	
		depth = 0;
	}
	
	public String toString()
	{
		String s = "";
		for (int i = 0 ; i < adjacency.size(); i++)
			s += adjacency.get(i).value + " ";
		return value + "," + depth + ": " + s;
	}
}
