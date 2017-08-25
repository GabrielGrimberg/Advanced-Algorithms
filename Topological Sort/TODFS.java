/* 
	Name: Gabriel Grimberg.
	Type: Topological Order.
	Code: Recursive DFS Algorithm Class.
*/

import java.util.Stack;

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
		
		for(Vertex v : vertex.getNeighbourList())
		{
			if( !v.isVisited())
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
