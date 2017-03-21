/* 
	Name: Gabriel Grimberg.
	Course: DT228/2.
	Module: Algorithms & Data Structures.
	Type: Final Year Assignment.
	Code: Kruskal's Algorithm.
*/

using System;
using System.IO;

	// convert vertex into char for pretty printing
 
class Edge 
{
	
	// missing code
	
	public void show() 
	{
		Console.Write("Edge {0}-{1}-{2}\n",toChar(u), wgt, toChar(v)) ;
	}
	
	// convert vertex into char for pretty printing
	private char toChar(int u)
	{  
		return (char)(u + 64);
	}
}


class Heap
{
	private int[] h;
	int N, Nmax;
	Edge[] edge;


	// Bottom up heap constructor
	public Heap(int _N, Edge[] _edge) 
	{
		int i;
		Nmax = N = _N;
		h = new int[N+1];
		edge = _edge;
	   
		// initially just fill heap array with 
		// indices of edge[] array.
		for (i=0; i <= N; ++i) 
			h[i] = i;
		   
		// Then convert h[] into a heap
		// from the bottom up.
		for(i = N/2; i > 0; --i)
			siftDown(i);
	}




	private void siftDown( int k) 
	{
 
	}


	public int remove() 
	{
		h[0] = h[1];
		h[1] = h[N--];
		siftDown(1);
		return h[0];
	}
}

/*******************************************************************
*															       *
*       UnionFind partition to support union-find operations       *
*       Implemented simply using Discrete Set Trees			       *
*        	 												       *
********************************************************************/

class UnionFindSets
{
	private int[] treeParent;
	private int N;
	
	public UnionFindSets( int V)
	{
	   
	}

	public int findSet( int vertex)
	{   
	   
	}
	
	public void union( int set1, int set2)
	{
	  
	}
	
	public void showTrees()
	{
		int i;
		for(i=1; i<=N; ++i)
			Console.Write("{0}->{1}  ", toChar(i), toChar(treeParent[i]));
		Console.Write("\n");
	}
	
	public void showSets()
	{

	}

	private void showSet(int root)
	{

	
	}
	
	private char toChar(int u)
	{  
		return (char)(u + 64);
	}
}

class Graph 
{ 
	private int V, E;
	private Edge[] edge;
	private Edge[] mst;        

	public Graph(string graphFile) 
	{
		int u, v;
		int w, e;

		StreamReader reader = new StreamReader(graphFile);
	   
	    char[] splits = new char[] { ' ', ',', '\t'};     
		string line = reader.ReadLine();
		string[] parts = line.Split(splits, StringSplitOptions.RemoveEmptyEntries);
		
		// find out number of vertices and edges
		V = int.Parse(parts[0]);
		E = int.Parse(parts[1]);

		
		// create edge array
	   // missing code   
		
		// read the edges
		Console.WriteLine("Reading edges from text file");
	    for(e = 1; e <= E; ++e)
	    {
			line = reader.ReadLine();
			parts = line.Split(splits, StringSplitOptions.RemoveEmptyEntries);
			u = int.Parse(parts[0]);
			v = int.Parse(parts[1]); 
			w = int.Parse(parts[2]);
			
			Console.WriteLine("Edge {0}--({1})--{2}", toChar(u), w, toChar(v));    
			 
			// missing code
		}
	}


/**********************************************************
*
*       Kruskal's minimum spanning tree algorithm
*
**********************************************************/
public Edge[] MST_Kruskal() 
{
	int ei, i = 0;
	Edge e;
	int uSet, vSet;
	UnionFindSets partition;
	
	// create edge array to store MST
	// Initially it has no edges.
	mst = new Edge[V-1];

	// priority queue for indices of array of edges
	// missing code

	// create partition of singleton sets for the vertices
	// missing code
	partition.showSets();

	while(i < V-1) 
	{
 
	}
	return mst;
}


	// convert vertex into char for pretty printing
	private char toChar(int u)
	{  
		return (char)(u + 64);
	}

	public void showMST()
	{
		Console.Write("\nMinimum spanning tree build from following edges:\n");
		for(int e = 0; e < V-1; ++e) 
		{
			mst[e].show(); 
		}
		Console.WriteLine();
	   
	}

	// test code
	public static int Main() 
	{
		string fname = "wGraph3.txt";
		Console.Write("\nInput name of file with graph definition: ");
		fname = Console.ReadLine();

		Graph g = new Graph(fname);

		g.MST_Kruskal();

		g.showMST();
		
		return 0;
	}

} // end of Graph class