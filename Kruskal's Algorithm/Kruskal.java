/* 
	Name: Gabriel Grimberg.
	Course: DT228/2.
	Module: Algorithms & Data Structures.
	Type: Final Year Assignment.
	Code: Kruskal's Algorithm.
*/

import java.io.*;
import java.util.Scanner;

//Convert vertex into char for pretty printing 
class Edge 
{
	
	// missing code
	
	public void show() 
	{
		System.out.print("Edge {0}-{1}-{2}\n",toChar(u), wgt, toChar(v)) ;
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

	//Bottom up heap constructor
	public Heap(int _N, Edge[] _edge) 
	{
		int i;
		Nmax = N = _N;
		h = new int[N+1];
		edge = _edge;
	   
		//Initially just fill heap array with 
		//Indices of edge[] array.
		for (i=0; i <= N; ++i)
		{
			h[i] = i;
		}
		   
		//Then convert h[] into a heap
		//From the bottom up.
		for(i = N/2; i > 0; --i)
		{
			siftDown(i);
		}
	}
	
	private void siftDown( int k) 
	{
		int v =  h[k];
		int j = 2 * k;
		
		//If you have a left child.
		while(j <= N)
		{
			if(j < N && h[j + 1] > h[j])
			{
				++j;
			}

			if(v >= h[j])
			{
				System.exit(0);
			}
			else
			{
				h[k] = h[j];
				k = j;
				j = 2 * k;
			}

		}

		h[k] = v;
		
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
	
	public UnionFindSets(int V)
	{
		while(V != treeParent[V])
		{
			V = treeParent[V];
		}
		return V;	   
	}
	
	public void makeSet(x)
	{
		treeParent[x] = x;
	}

	public int findSet(int vertex)
	{
		if(treeParent[vertex] == vertex)
		{
			return vertex;
		}
		else
		{
			return findSet(treeParent[vertex]);
		}
	
	}
	
	public void union( int set1, int set2)
	{
		int xRoot = findSet(set1);
		int yRoot = findSet(set2);
		
		treeParent[yRoot] = xRoot;
	}
	
	public void showTrees()
	{
		int i;
		for(i = 1; i <= N; ++i)
		{
			System.out.print("{0}->{1}  ", toChar(i), toChar(treeParent[i]));
		}
		System.out.print("\n");
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

		FileReader fr = new FileReader(graphFile);
		BufferedReader reader = new BufferedReader(fr);
		
		String splits = " +";
		String line = reader.readLine();        
		
		String[] parts = line.split(splits);
		System.out.println("Parts[] = " + parts[0] + " " + parts[1]);
		
		//Find out number of vertices and edges
		V = Integer.parseInt(parts[0]);
		E = Integer.parseInt(parts[1]);

		
		//Create edge array
	   	//Create sentinel node
		z = new Node(); 
		z.next = z;
	
		//Create adjacency lists, initialised to sentinel node z       
		adj = new Node[V+1];
	
		for(v = 1; v <= V; ++v)
		{
			adj[v] = z;   
		} 
		
		//Read the edges
		System.out.print("Reading edges from text file");
		
	    for(e = 1; e <= E; ++e)
	    {
			line = reader.readLine();
			parts = line.split(splits);
			u = int.Parse(parts[0]);
			v = int.Parse(parts[1]); 
			w = int.Parse(parts[2]);
			
			System.out.print("Edge {0}--({1})--{2}", toChar(u), w, toChar(v));    
			 
			t = new Node();
			t.wgt = wgt;
			t.vert = v;
			t.next = adj[u];
			adj[u] = t;

			t = new Node();
			t.wgt = wgt;
			t.vert = u;
			t.next = adj[v];
			adj[v] = t;
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
		
		//Create edge array to store MST
		//Initially it has no edges.
		mst = new Edge[V-1];

		//Priority queue for indices of array of edges
		//Missing code

		//Create partition of singleton sets for the vertices
		//Missing code
		partition.showSets();

		while(i < V-1) 
		{
	 
		}
		return mst;
	}


	//Convert vertex into char for pretty printing
	private char toChar(int u)
	{  
		return (char)(u + 64);
	}

	public void showMST()
	{
		System.out.print("\nMinimum spanning tree build from following edges:\n");
		for(int e = 0; e < V - 1; ++e) 
		{
			mst[e].show(); 
		}
		//Console.WriteLine();
	   
	}
	
}

public class Kruskal
{
	public static void main(String args[]) throws IOException 
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("\nInput name of file with graph definition: ");
		String fname = in.nextLine();

		Graph g = new Graph(fname);

		g.MST_Kruskal();

		g.showMST();

	}
	
}