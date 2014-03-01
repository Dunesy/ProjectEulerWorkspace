import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class MinHeap
{
        
    public MinHeap()
    {
        items = new ArrayList<Node>();                
        mySize = 0;
    } 

    public void add(Node x)
    {           	  
         items.add(x);
         trickleUp(mySize++);         
    } 

    public Node remove()           // delete item with max key
    {                           // (assumes non-empty list)
    Node root = items.get(0);
    
    items.set(0, items.get(--mySize));   
    trickleDown(0);
    items.remove(root);
    return root;
    }  // end remove()
    
    public void trickleUp(int index)
    {
    	 int parent = (index-1) / 2;
         Node bottom = items.get(index);

         while( index > 0 && items.get(parent).weight > bottom.weight )
            {
            items.set(index, items.get(parent));
            index = parent;
            parent = (parent-1) / 2;
            }  // end while
         items.set(index, bottom);
    }
    
    public int getIndex(Node n)
    {
    	return items.indexOf(n);
    }
    
    public void trickleDown(int index)
    {
    int largerChild;
    Node top = items.get(index);       
    while(index < mySize/2)       
       {                               
       int leftChild = 2*index+1;
       int rightChild = leftChild+1;
                                       
       if(rightChild < mySize &&  items.get(leftChild).weight > items.get(rightChild).weight)
          largerChild = rightChild;
       else
          largerChild = leftChild;
                                       // top >= largerChild?
       if( top.weight <= items.get(largerChild).weight )
          break;
                                       // shift child up
       items.set(index, items.get(largerChild));
       index = largerChild;            // go down
       }  // end while
    items.set(index, top);            // root to index
    }  // end trickleDown()
           
    public boolean change(int index, int newValue)
    {
    if(index<0 || index>=mySize)
       return false;
    int oldValue = items.get(index).weight; // remember old
    items.get(index).weight = newValue;  // change to new

    if(oldValue > newValue)             // if raised,
       trickleUp(index);                // trickle it up
    else                                // if lowered,
       trickleDown(index);              // trickle it down
    return true;
    }  // end change()
    
    public Object peekMin() 
    {
        return items.get(0);
    }

    public boolean isEmpty()
    {
        return mySize == 0;
    }

    private List<Node> items;
    private int  mySize;
} 