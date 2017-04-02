/* 
    Name: Gabriel Grimberg.
    Course: DT228/2.
    Module: Algorithms & Data Structures.
    Type: Final Year Assignment.
    Code: Prim's Algorithm using a Priority Queue(Heap).
*/

import java.io.*;
import java.util.Scanner; //For keyboard input.

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
        N = 0;                     //Assume size of heap is 0.
        h = new int[maxSize + 1];
        dist = _dist;              //Given as parameters and you intiliasie them.
        hPos = _hPos;              //Given as parameters and you intiliasie them.
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
        //h[0] = 0;
        
        //Smallest value into distance 0 so it can be compared.
        dist[0] = 0;
        
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


    public void siftDown(int k) 
    {
        int v, j;
       
        v = h[k];  
        
        j = 2 * k;
        
        while(j <= N)
        {
            if( (j + 1 <= N) && dist[ h[j] ] > dist[ h[j + 1] ] )
            {
                j++; //Next element.
            }
            
            //If the distance of vertex element we are currently on is
            //Greater than the vertex we are sifting down then abort.
            if( dist[ h[j] ] >= dist[v] )
            {
                break;
            }
            //If it's not then continue down the list.
            else
            {
                h[k] = h[j];
                k = j;
                j = k * 2;
            }
        }
        
        //When the right position is found put it into the array.
        h[k] = v;
        hPos[v] = k;
    }


    public void insert( int x) 
    {
        //Adding a new vertex onto the end of the heap array.
        h[++N] = x;
        
        //Sifting up the vertex to find the correct location.
        siftUp( N);
    }

    public int remove() 
    {
        //Give the element a 0 value then sift it down.  
        int v = h[1];
        
        //V is no longer in heap.
        hPos[v] = 0;
        
        //Put null node into empty spot
        h[N+1] = 0;
        
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
    
    //V = number of vertices
    //E = number of edges
    //adj[] is the adjacency lists array
    private int V, E;
    private Node[] adj;
    private Node z;
    private int[] mst;
    
    //Used for traversing graph
    private int[] visited;
    private int id;
    
    
    //Default constructor
    public Graph(String graphFile)  throws IOException
    {
        int u, v;
        int e, wgt;
        Node t;

        FileReader fr = new FileReader(graphFile);
		BufferedReader reader = new BufferedReader(fr);

        //Multiple whitespace as delimiter
        String splits = " +";
		String line = reader.readLine();        
        String[] parts = line.split(splits);
        System.out.println("\nVertices = " + parts[0] + " Edges = " + parts[1]);
        
        V = Integer.parseInt(parts[0]);
        E = Integer.parseInt(parts[1]);
        
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
        System.out.println("Reading edges from text file");
        System.out.println("Graph below in order of: Node, Weight and Node");
        
        for(e = 1; e <= E; ++e)
        {
            line = reader.readLine();
            parts = line.split(splits);
            u = Integer.parseInt(parts[0]);
            v = Integer.parseInt(parts[1]); 
            wgt = Integer.parseInt(parts[2]);
            
            System.out.println("Edge " + toChar(u) + "--(" + wgt + ")--" + toChar(v));    
            
            //Putting edge into adjacency matrix into the linked list.
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
   
    //Convert vertex into char for pretty printing
    private char toChar(int u)
    {  
        return (char)(u + 64);
    }
        
    //Method to display the graph representation
    public void display() 
    {
        int v;
        Node n;
        
        System.out.println("\nNodes connected to each other with distance.");
        for(v = 1; v <= V; ++v)
        {
            System.out.print("\nadj[" + toChar(v) + "] ->" );
            
            //Go through the vertices, for each one start at the beginning of the Linked List.
            for(n = adj[v]; n != z; n = n.next) 
            {
                System.out.print(" |" + toChar(n.vert) + " | " + n.wgt + "| ->");    
            }
        }
        System.out.println("");
    }
    
    /*
    Prim_Lists( Vertex s ) 
    Begin
        foreach v   V              // G = (V, E)
            dist[v] :=  Infinity 
            parent[v] := 0         // treat 0 as a special null vertex
            hPos[v] := 0           // indicates that v   heap
            
        h = new Heap(|V|, hPos, dist) // priority queue (heap) initially empty
        h.insert(s)                 // s will be the root of the MST
        
        while (not h.isEmpty() )    // should repeat |V|-1 times
            v := h.remove()         // add v to the MST
            dist[v] := -dist[v]     // marks v as now in the MST
            
            foreach u   adj(v)      // examine each neighbour u of v
            
                if wgt(v, u) < dist[u] 
                    dist[u] := wgt(v, u)
                    parent[u] := v
            
                    if u   h
                        h.insert( u)
                    else
                        h.siftUp( hPos[u])
                
                end if 
            end for
        end while
        return parent 
    End
    */
	public void MST_Prim(int s)
	{
        int v, u;
        int wgt, wgt_sum = 0;
        int[]  dist, parent, hPos;
        Node t;

        dist = new int[V + 1];      //Distance from node to node.
        parent = new int[V + 1];    //Parent node.
        hPos = new int[V + 1];      //Current heap position.
        
        
        for(v = 0; v <= V; v++) 
        {	
            dist[v] = Integer.MAX_VALUE; //Set to infinity.
            
            parent[v] = 0; //Treat 0 as a special null vertex.
            
            hPos[v] = 0; //Indicates that it's not on the heap.
        }
        
        //Creating a new empty priority heap.
        //V is the max size of the heap array.
        Heap pq =  new Heap(V, dist, hPos);
        
        //Insert first element into the heap, s is used a the root of the MST.
        pq.insert(s);
        
        //Set the distance to 0.
        dist[s] = 0;
        
        
        while (!pq.isEmpty()) 
        {
            v = pq.remove(); //Adding V to the MST.
            dist[v] = -dist[v]; //Marking V as in the MST.
            
            Node n;
            int w;
            
            //Examine each neighbour u of v.
            for (n = adj[v]; n != z; n = n.next) 
            {
                u = n.vert;
                w = n.wgt;
                
                if (w < dist[u]) 
                {
                    if (dist[u] != Integer.MAX_VALUE) 
                    {
                        wgt_sum -= dist[u];
                    }

                    dist[u] = w;
                    parent[u] = v;
                    wgt_sum += w;

                    if (hPos[u] == 0) 
                    {
                        pq.insert(u);
                    } 
                    else 
                    {
                        pq.siftUp(hPos[u]);
                    }
                }
            }
        }
        //Displaying the weight of the graph.
        System.out.println("\n");
        System.out.println("------------------------");
        System.out.println("- Weight of MST is: " + wgt_sum + " -");
        System.out.println("------------------------");
        
        mst = parent;                      		
	}
    
    public void showMST()
    {
            System.out.print("\n\nMinimum Spanning tree parent array is:\n");
            
            for(int v = 1; v <= V; ++v)
            {
                System.out.println(toChar(v) + " -> " + toChar(mst[v]));
            }
            System.out.println("");
    }

}

public class PrimLists 
{
    public static void main(String[] args) throws IOException
    {
        Scanner keyInput = new Scanner(System.in);
        
        //Entering the file name.
        System.out.println("Enter the name of the file including the .txt : ");
        String fname = keyInput.nextLine(); 
        
        //Entering the starting vertex.
        System.out.println("Enter the vertex you wish to start on : ");
        int startVertex = keyInput.nextInt();             
        
        Graph g = new Graph(fname);
       
        g.display();     //Display the graph.
        g.MST_Prim(startVertex);   //Performe Algorithm and display the weight of it.
        g.showMST();     //Show the MST.
               
    }
}