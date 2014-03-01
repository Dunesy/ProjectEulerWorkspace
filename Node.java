import java.util.ArrayList;

public class Node implements Comparable<Node>
{
	public int weight = 0;
	public int coordinatex;
	public int coordinatey;
	public ArrayList<Node> adjacentNodes;
	public Node previous;
	
	public Node(int w, int x, int y)
	{
		 coordinatex = x;
		 coordinatey = y;
		 weight = w;
		 adjacentNodes = new ArrayList<Node>();
		 previous = null;
	}

	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		if (this.weight < arg0.weight)
			return -1;
		else if(this.weight > arg0.weight)
			return 1;
		else return 0;		
	}
	
	public String toString()
	{
		return String.valueOf(this.weight);
	}
}