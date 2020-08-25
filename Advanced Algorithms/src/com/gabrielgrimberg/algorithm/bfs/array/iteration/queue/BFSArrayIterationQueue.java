package com.gabrielgrimberg.algorithm.bfs.array.iteration.queue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class BFSArrayIterationQueue {
	
	// V = number of vertices.
	// E = number of edges.
	// adj[ ][ ] is the adjacency matrix.
	private int V, E;
	private int[][] adj;
		
	// Used for traversing graph.
	private int[] visited;
	private int id;
	 
	public BFSArrayIterationQueue(String graphFile)  throws IOException {
		
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
		
		for(e = 1; e <= E; ++e) {
			
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
	
	// Convert vertex into char for pretty printing.
	private char toChar(int u) { return (char)(u + 64); }
	
	public void display() {
		
		int u,v;
		
		for(v = 1; v <= V; ++v) {
			
			System.out.print("\nadj[" + v + "] = ");
			
			for(u = 1; u <= V; ++u) {
				
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
	public void BF(int s) {
		
		Queue q = new Queue();
		
		id = 0;
		
		for(int v = 0; v < V; v++) {
			
			visited[v] = 0;
		}
		q.enQueue(s);
		
		while(!q.isEmpty()) {
			
			int v = q.deQueue();
			
			if(visited[v] == 0) {
				
				visited[v] = ++id;
				System.out.print(toChar(v) + " -> ");
				
				for(int u=1; u<adj[v].length; u++) {
					 
					if(visited[u] == 0) {
						 
						q.enQueue(u);
					}						
				}			
			}	
		}
	}
}