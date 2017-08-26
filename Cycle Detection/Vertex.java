/* 
	Name: Gabriel Grimberg.
	Type: Cycle Detection.
	Code: Vertex.
*/

import java.util.ArrayList;
import java.util.List;

public class Vertex 
{

	private String name; //Name for Vertices.
	private boolean visited; //Check whether we have a visited vertex.
	private boolean beingVisited; //Whether this given vertex is being visited or not.
	private List<Vertex> adjacenciesList; //Reference to a list of vertices.

	public Vertex(String name) 
	{
		this.name = name;
		this.adjacenciesList = new ArrayList<>(); //Instantiate as a new array list.
	}

	public void addNeighbour(Vertex vertex) 
	{
		this.adjacenciesList.add(vertex);
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public boolean isVisited() 
	{
		return visited;
	}

	public void setVisited(boolean visited) 
	{
		this.visited = visited;
	}

	public boolean isBeingVisited() 
	{
		return beingVisited;
	}

	public void setBeingVisited(boolean beingVisited) 
	{
		this.beingVisited = beingVisited;
	}

	public List<Vertex> getAdjacenciesList() 
	{
		return adjacenciesList;
	}

	public void setAdjacenciesList(List<Vertex> adjacenciesList) 
	{
		this.adjacenciesList = adjacenciesList;
	}

	public String toString() 
	{
		return this.name;
	}
}
