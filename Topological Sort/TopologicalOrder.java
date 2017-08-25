import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class App
{
	
}

public class Vertex
{
	private String data; //Label of the nodes.
	private boolean isVisited; //Tracking.
	private List<Vertex> neighbourList;
	
	public Vertex(String data)
	{
		this.data = data;
		this.neighbourList = new ArrayList<>();
	}
	
	public void addNeighbour(Vertex vertex)
	{
		this.neighbourList.add(vertex)
	}
	
	public String getData()
	{
		return data;
	}
	
	public void setData(String data)
	{
		this.data = data;
	}
	
	public boolean isVisited()
	{
		return isVisited;
	}
	
	public void setVisited(boolean visited)
	{
		this.isVisited = isVisited;
	}
	
	@Override
	public String toString()
	{
		return this.data;
	}
	
}

public class TODFS
{
	private Stack<Vertex> stack;
	
	public TODFS()
	{
		this.stack = new Stack<>();
	}
	
	//Implementing in a recursive manner.
	public void DFS(Vertex vertex)
	{
		vertex.setVisited(true);
		
		for(Vertex v : vertex.getNeighbourList() )
		{
			if(!v.isVisited())
			{
				DFS(v);
			}
		}
		
		//Pushing a visited vertex onto the stack.
		stack.push(vertex);
		
	}
	
	public Stack<Vertex> getStack()
	{
		return this.stack;
	}
	
}


class TopologicalOrder 
{
	public static void main(String[] args) 
	{
		
	}

}