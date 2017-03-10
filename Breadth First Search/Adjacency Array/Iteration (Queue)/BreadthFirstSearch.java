/* 
	Name: Gabriel Grimberg
	Course: DT228/2
	Module: Algorithms & Data Structures
	Type: Breadh First Search (Array + Iterative Version: Queue)
*/

import java.io.*;

class Queue 
{
	private class Node 
	{
		int data;
		Node next;
	}

	Node z;
	Node head;
	Node tail;

	public Queue() 
	{
		z = new Node(); 
		z.next = z;
		head = z;  
		tail = null;
	}
	
	public void display() 
	{
		System.out.println("\nThe queue values are:\n");

		Node temp = head;
		
		while( temp != temp.next) 
		{
			System.out.print( temp.data + "  ");
			temp = temp.next;
		}
		
		System.out.println("\n");
	}

	public void enQueue( int x) 
	{
		Node temp;

		temp = new Node();
		temp.data = x;
		temp.next = z;
		
		//Case of empty list
		if(head == z)
		{
			head = temp;
		}
		//Case of list not empty
		else
		{
			tail.next = temp;
		}

		tail = temp;//New node is now at the tail
	}


	//Assume the queue is non-empty when this method is called
	public int deQueue() 
	{
		if(head == head.next)
		{
			return -1;
		}
		else 
		{
			int temp = head.data;
			
			head = head.next;
			
			return temp;
		}
	}

	public boolean isEmpty() 
	{
		return head == head.next;
	}

	public boolean isMember(int x) 
	{
		Node temp = head;
		
		while(temp != z) 
		{
			if(temp.data == x)
			{
				return true;
			}
			
			temp = temp.next;
		}
		
		return false;
	}
	
}

class BreadthFirstSearch 
{
	// V = number of vertices
	// E = number of edges
	// adj[ ][ ] is the adjacency matrix
	private int V, E;
	private int[][] adj;
		
	//Used for traversing graph
	private int[] visited;
	private int id;
	 
	//Default constructor
	public BreadthFirstSearch(String graphFile)  throws IOException
	{
		int u, v;
		int e, wgt;

		FileReader fr = new FileReader(graphFile);
		BufferedReader reader = new BufferedReader(fr);
	   

		String splits = " +";  //Multiple whitespace as delimiter		   
		String line = reader.readLine();       
		String[] parts = line.split(splits);
		System.out.println(" ");
		System.out.println("Parts[] = " + parts[0] + " " + parts[1]);
				
		V = Integer.parseInt(parts[0]);
		E = Integer.parseInt(parts[1]);

		adj = new int[V+1][V+1];        
		visited = new int[V+1];
		
		System.out.println("Reading edges from text file");
		System.out.println(" ");
		
		for(e = 1; e <= E; ++e)
		{
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
	
	public void display() 
	{
		int u,v;
		
		for(v = 1; v <= V; ++v)
		{
			System.out.print("\nadj[" + v + "] = ");
			
			for(u = 1; u <= V; ++u)
			{
				System.out.print("  " + adj[u][v]);
			}    
			 
		}
		
	}
	
	/*
	BEGIN
	Graph :: BF( Vertex s)
		Queue q
		id = 0
		
		for v = 1 to V
			visited[v] = 0
		
		q.enQueue(s)
		while (not q.isEmpty())
			v = q.deQueue() 
			if (not visited[v])
				visited[v] = ++id
				for each vertex u  adj(v)
					if (not visited[u]) 
						q.enQueue(u)
				end for end if
		end while End
	END
	*/
	public void BF(int s)
	{
		Queue q = new Queue();
		
		id = 0;
		
		for(int v = 0; v < V; v++)
		{
			visited[v] = 0;
		}
		q.enQueue(s);
		
		while(!q.isEmpty())
		{
			int v = q.deQueue();
			
			if(visited[v] == 0) 
			{
				visited[v] = ++id;
				System.out.print(toChar(v) + " -> ");
				
				for(int u=1; u<adj[v].length; u++) 
				{ 
					if(visited[u] == 0) 
					{ 
						q.enQueue(u);
					}						
				}			
			}	
		}
	}
	

	public static void main(String[] args) throws IOException
	{
		int s = 2;
		String fname = "GraphExample.txt";               

		BreadthFirstSearch g = new BreadthFirstSearch(fname);
			 
		g.display();
		 
		System.out.println("\n");
	   	System.out.println("Breadh First Search: ");
		 
		g.BF(s);

	}

}