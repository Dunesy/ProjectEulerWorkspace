import java.util.Set;

public class Pair 
{
	public int key;
	public Set<Integer> value;
	
	Pair(int key, Set<Integer> value)
	{
		this.key = key;
		this.value = value;
	}

	public String toString()
	{
		return this.key + " " + this.value.toString();
	}
	
}