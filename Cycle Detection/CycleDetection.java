/* 
	Name: Gabriel Grimberg.
	Type: Cycle Detection.
	Code: Recursive DFS Algorithm Class.
*/

import java.util.List;

public class CycleDetection 
{
	
	//Going to get a list of vertices, and visit vertices.
	public void detectCycle(List<Vertex> vertexList) 
	{
		
		for(Vertex vertex : vertexList) 
		{
			
			if( !vertex.isVisited() )
			{
				dfs(vertex);
			}
		}
	}
	
	//Depth First Search
	private void dfs(Vertex vertex) 
	{
		
		System.out.println("Vertex: " + vertex);
		
		vertex.setBeingVisited(true); 
		
		for(Vertex v : vertex.getAdjacenciesList())
		{
			System.out.println("Visiting the neighbours of vertex: " + vertex);
			
			if(v.isBeingVisited() ) 
			{
				System.out.println("Backward edge ... Cycel Detected!");
				return;
			}
			
			if(!v.isVisited() )
			{
				System.out.println("Visiting vertex: " + v);
				v.setVisited(true);
				dfs(v);
			}
		}
		
		System.out.println("Set vertex " + vertex + " setBeingVisited(false) and visited(true)");
		vertex.setBeingVisited(false);
		vertex.setVisited(true); 
		
	}
}
