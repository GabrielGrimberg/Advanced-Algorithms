package com.gabrielgrimberg.algorithm.kruskal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Graph {
	 
	private int V, E;
	private Edge[] edge;
	private Edge[] mst;        

	public Graph(String graphFile) throws IOException {
		int u, v;
		int w, e;

		FileReader fr = new FileReader(graphFile);
		BufferedReader reader = new BufferedReader(fr);
	           
		String splits = " +";  // Multiple whitespace as delimiter.
		String line = reader.readLine();        
		String[] parts = line.split(splits);
		System.out.println("\nVertices = " + parts[0] + " Edges = " + parts[1]);
		
		V = Integer.parseInt(parts[0]); // How many Vertices.
		E = Integer.parseInt(parts[1]); // How many Edges.
		
		// Create edge array.
		edge = new Edge[E+1];   
		
		// Read the edges.
		System.out.println("Reading edges from text file");
		System.out.println("Graph below in order of: Node, Weight and Node");
		
		for (e = 1; e <= E; ++e) {
			
			line = reader.readLine();
			parts = line.split(splits);
			u = Integer.parseInt(parts[0]); //u is the First Node.
			v = Integer.parseInt(parts[1]); //v is the Node Connected to the first one.
			w = Integer.parseInt(parts[2]); //w is the weight between the 2 nodes.
			
			System.out.println("Edge " + toChar(u) + "--(" + w + ")--" + toChar(v));                        
			 
			// Creating the edge object.
			edge[e] = new Edge(u, v, w); 
		}
		
		System.out.println("\n");
	}


	/**************************************************************
	*															  *
	*        Kruskal's minimum spanning tree algorithm            *
	*															  *
	**************************************************************/
	public Edge[] MST_Kruskal() {
		
		int ei, i = 0;
		Edge e;
		int uSet, vSet;
		int totalWeight = 0;
		UnionFindSets partition;
		
		// Create edge array to store MST.
		// Initially it has no edges.
		mst = new Edge[V-1];
	
		// Priority queue for indices of array of edges.
		Heap h = new Heap(E, edge);
	
		// Create partition of singleton sets for the vertices.
		partition = new UnionFindSets(V);
		partition.showSets();
		
		while(i < V - 1) {
			
			ei = h.remove();
			e = edge[ei];
			
			uSet = partition.findSet(e.u);
			vSet = partition.findSet(e.v);
			
			if(uSet != vSet) {
				
				mst[i] = e;
				++i;
				
				System.out.print("\n" + i + ": ");
				
				e.show();
				
				partition.union(uSet, vSet);
				partition.showSets();
				partition.showTrees();
				
				totalWeight += e.wgt;
				
			} else {
				
				System.out.print("\nIgnoring ");
				e.show();
			}
			
		}
		
		// Displaying the weight of the graph.
		System.out.println("\n");
		System.out.println("------------------------");
		System.out.println("- Weight of MST is: " + totalWeight + " -");
		System.out.println("------------------------");
		
		return mst;
	}
	
	// Convert vertex into char for pretty printing.
	private char toChar(int u) {
		  
		return (char)(u + 64);
	}
	
	public void showMST() {
		
		System.out.print("\nMinimum spanning tree build from following edges:\n");
		
		for(int e = 0; e < V-1; ++e) {
			
			mst[e].show(); 
		}
		
		System.out.println();
			
	}
	
}