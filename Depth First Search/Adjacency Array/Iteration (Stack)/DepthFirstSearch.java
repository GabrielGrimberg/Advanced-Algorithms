/* 
	Name: Gabriel Grimberg
	Course: DT228/2
	Module: Algorithms & Data Structures
	Type: Depth First Search (Array + Iterative Version(Stack) )
*/

import java.io.*;

class Stack
{
	class Node 
	{
		int data; 
		Node next; //Reference (placeholder).  
	}
	
	private Node top; //Top reference to node.
	
	//Constructs an empty stack.
	public Stack()
	{ 
		top = null;
	}
		
	public void push(int x) 
	{
		Node  t = new Node(); //Creating a new node.
		t.data = x;
		t.next = top;
		top = t;
	}

	//Only called if the list is not empty.
	public int pop()
	{
		Node t = top;
		top = top.next;
		return t.data;
	}
	
	//Method to see if the stack is empty.
	public boolean isEmpty()
	{
		return top == null;
	}
	
	//Method to see if a node is in stack.
	public boolean isMember(int x)
	{
		Node current = top;
		
		while (current != null) 
		{
			if(current.equals(x)) 
			{
				return true;
			} 
			else 
			{
				current = current.next;
			}
		}
		
		return false;
	}
}

class DepthFirstSearch 
{
	// V = number of vertices
	// E = number of edges
	// adj[ ][ ] is the adjacency matrix
	private int V, E;
	private int[][] adj;
	
	// used for traversing graph
	private int[] visited;
	private int id;
   
	// default constructor, takes a single parameter give it the name of the graph file.
	//Exception thrown if file not found.
	public DepthFirstSearch(String graphFile) throws IOException
	{
		int u, v;
		int e, wgt;

		//Create a file reader, give it a name of the file. 
		FileReader fr = new FileReader(graphFile);

		//Then read the file
		BufferedReader reader = new BufferedReader(fr);
	   
		//Read it in as strings, you could have tabs, commas etc.. so you need a dilimiter.
		String splits = " +";  // multiple whitespace as delimiter		   
		String line = reader.readLine();//Go to the reader       
		String[] parts = line.split(splits);//We get the line and we split it, when you split it you get an array of strings.
		System.out.println("Parts[] = " + parts[0] + " " + parts[1]);//Display the 2 strings, just to see if it's correct.
		
		V = Integer.parseInt(parts[0]); //Convert it from a string into an int.
		E = Integer.parseInt(parts[1]); //Convent it from a string into an int.

		//Create adjacency matrix, initialised to 0's
		//Create 2 Dimensinal
		adj = new int[V+1][V+1];    
		
		//Create the visted array.
		visited = new int[V+1];
		
		//Read the edges
		System.out.println("Reading edges from text file");
		for(e = 1; e <= E; ++e)
		{
			//Read a line
			//Split it in string/parts.
			//This time there will be 3 parts to it, u,v,wgt.
			line = reader.readLine();
			parts = line.split(splits);
			u = Integer.parseInt(parts[0]);
			v = Integer.parseInt(parts[1]); 
			wgt = Integer.parseInt(parts[2]);
			
			System.out.println("Edge " + toChar(u) + "--(" + wgt + ")--" + toChar(v));    
			 
			adj[u][v] = wgt;
			adj[v][u] = wgt;          
	   }	       
	}

	//Convert vertex into char for pretty printing
	private char toChar(int u)
	{  
		return (char)(u + 64);
	}
	
	//Method to display the graph representation
	public void display() 
	{
		int u,v;
		
		for(v=1; v<=V; ++v)
		{
			System.out.print("\nadj[" + v + "] = ");
			for(u = 1 ; u <= V; ++u)
			{ 
				System.out.print("  " + adj[u][v]);
			}
		}    
		System.out.println("");
	}
	
	/*
	Graph :: DF_iter( Vertex s) 
	Begin
		Stack s
		id = 0
		
		for v = 1 to V
			visited[v] = 0
		s.push(s)
		
		while (not s.isEmpty())
			v = s.pop()
			if (not visited[v])
				visited[v] = ++id
			for each vertex u  adj(v)
		end while 
	End
	*/
	public void DF_Iter(int s)
	{
		Stack stack = new Stack();
			
		id = 0;
			
		for(int v = 0; v < V; v++)
		{
			visited[v] = 0;
		}
		stack.push(s);
			
		while(!stack.isEmpty())
		{
			int v = stack.pop();
				
			if(visited[v] == 0) 
			{
				visited[v] = ++id;
				System.out.print(toChar(v) + " -> ");
					
				for(int u = 1; u < adj[v].length; u++) 
				{ 
					if(visited[u] == 0) 
					{ 
						stack.push(u);
					}						
				}			
			}	
		}
	}

	public static void main(String[] args) throws IOException
	{
		int s = 7;
		
		String fname = "Graph.txt";               

		DepthFirstSearch g = new DepthFirstSearch(fname);
	   			 
		g.display();
		 
		System.out.println("\n");
	   	System.out.println("Depth First Search: ");
		 
		g.DF_Iter(s);
	}

}