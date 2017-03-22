/* 
    Name: Gabriel Grimberg.
    Course: DT228/2.
    Module: Algorithms & Data Structures.
    Type: Final Year Assignment.
    Code: Prim List Using a Heap.
*/

import java.io.*;

class Heap
{
    private int[] h;	   // Heap array
    private int[] hPos;	   // hPos[h[k]] == k
    private int[] dist;    // dist[v] = priority of v
    
    //Size of heap.
    private int N;
   
    // The heap constructor gets passed from the Graph:
    // 1. Maximum heap size
    // 2. Reference to the dist[] array
    // 3. Reference to the hPos[] array
    public Heap(int maxSize, int[] _dist, int[] _hPos) 
    {
        N = 0;
        h = new int[maxSize + 1];
        dist = _dist;
        hPos = _hPos;
    }
    
    //Method that checks if the heap is empty.
    public boolean isEmpty() 
    {
        return N == 0;
    }


    public void siftUp( int k) 
    {
        //Current position of the vertex.
        int v = h[k];
        
        //Making a dummy node to place at the top of the heap.
        h[0] = 0;
        
        //Smallest value into distance 0 so it can be compared.
        dist[0] = Integer.MIN_VALUE;
        
        //While distance value at the current element.
        //Is less than the distance value at k / 2.
        //Keep dividing going up the list to insert the element
        //At the correct place.
        while(dist[v] < dist[ h[k / 2] ])
        {
            //If not found, then siftUp the value to next value.
            h[k] = h[k / 2];
            hPos[ h[k] ] = k;
            
            //Then divide the element by 2 to go up.
            k = k / 2;
        }
        
        //Insert Vertex into the correct place on to the heap array.
        h[k] = v;
        hPos[v] = k;
    }


    public void siftDown( int k) 
    {
        int v, j;
       
        v = h[k];  
        
        // code yourself 
        // must use hPos[] and dist[] arrays
    }


    public void insert( int x) 
    {
        h[++N] = x;
        siftUp( N);
    }


    public int remove() 
    {   
        int v = h[1];
        hPos[v] = 0; // v is no longer in heap
        h[N+1] = 0;  // put null node into empty spot
        
        h[1] = h[N--];
        siftDown(1);
        
        return v;
    }

}

class Graph 
{
    class Node 
    {
        public int vert;
        public int wgt;
        public Node next;
    }
    
    // V = number of vertices
    // E = number of edges
    // adj[] is the adjacency lists array
    private int V, E;
    private Node[] adj;
    private Node z;
    private int[] mst;
    
    // used for traversing graph
    private int[] visited;
    private int id;
    
    
    // default constructor
    public Graph(String graphFile)  throws IOException
    {
        int u, v;
        int e, wgt;
        Node t;

        FileReader fr = new FileReader(graphFile);
		BufferedReader reader = new BufferedReader(fr);
	           
        String splits = " +";  // multiple whitespace as delimiter
		String line = reader.readLine();        
        String[] parts = line.split(splits);
        System.out.println("Parts[] = " + parts[0] + " " + parts[1]);
        
        V = Integer.parseInt(parts[0]);
        E = Integer.parseInt(parts[1]);
        
        // create sentinel node
        z = new Node(); 
        z.next = z;
        
        // create adjacency lists, initialised to sentinel node z       
        adj = new Node[V+1];        
        for(v = 1; v <= V; ++v)
            adj[v] = z;               
        
       // read the edges
        System.out.println("Reading edges from text file");
        for(e = 1; e <= E; ++e)
        {
            line = reader.readLine();
            parts = line.split(splits);
            u = Integer.parseInt(parts[0]);
            v = Integer.parseInt(parts[1]); 
            wgt = Integer.parseInt(parts[2]);
            
            System.out.println("Edge " + toChar(u) + "--(" + wgt + ")--" + toChar(v));    
            
            // write code to put edge into adjacency matrix     
            
        }	       
    }
   
    // convert vertex into char for pretty printing
    private char toChar(int u)
    {  
        return (char)(u + 64);
    }
    
    // method to display the graph representation
    public void display() 
    {
        int v;
        Node n;
        
        for(v=1; v<=V; ++v)
        {
            System.out.print("\nadj[" + toChar(v) + "] ->" );
            for(n = adj[v]; n != z; n = n.next) 
            {
                System.out.print(" |" + toChar(n.vert) + " | " + n.wgt + "| ->");    
            }
        }
        System.out.println("");
    }


    
	public void MST_Prim(int s)
	{
        int v, u;
        int wgt, wgt_sum = 0;
        int[]  dist, parent, hPos;
        Node t;

        //code here
        
        dist[s] = 0;
        
        Heap pq =  new Heap(V, dist, hPos);
        pq.insert(s);
        
        while ( ...)  
        {
            // most of alg here
            
        }
        System.out.print("\n\nWeight of MST = " + wgt_sum + "\n");
        
        mst = parent;                      		
	}
    
    public void showMST()
    {
            System.out.print("\n\nMinimum Spanning tree parent array is:\n");
            for(int v = 1; v <= V; ++v)
                System.out.println(toChar(v) + " -> " + toChar(mst[v]));
            System.out.println("");
    }

}

public class PrimLists 
{
    public static void main(String[] args) throws IOException
    {
        int s = 2;
        String fname = "wGraph3.txt";               

        Graph g = new Graph(fname);
       
        g.display();
               
        
    }
}