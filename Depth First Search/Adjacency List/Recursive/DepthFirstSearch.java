/* 
    Name: Gabriel Grimberg
    Course: DT228/2
    Module: Algorithms & Data Structures
    Type: Depth First Search (Linked List + Recurive Version)
*/

import java.io.*;

class DepthFirstSearch
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
    private Node[] adj; //Array of nodes.
    private Node z;
    
    //Used for traversing graph
    private int[] visited;
    private int id;
    
    
    //Default constructor
    public DepthFirstSearch(String graphFile)  throws IOException
    {
        int u, v;
        int e, wgt;
        Node t;

        FileReader fr = new FileReader(graphFile);
		BufferedReader reader = new BufferedReader(fr);
	           
        String splits = " +";  //Multiple whitespace as delimiter
		String line = reader.readLine();        
        String[] parts = line.split(splits);
        System.out.println("Parts[] = " + parts[0] + " " + parts[1]);
        
        V = Integer.parseInt(parts[0]);
        E = Integer.parseInt(parts[1]);
        
        //Create sentinel node
        z = new Node(); 
        z.next = z;
            
        //Create adjacency lists, initialised to sentinel node z
        visited = new int[V+1];
        adj = new Node[V + 1];
        
        for(v = 1; v <= V; ++v)
        {
            adj[v] = z;               
        }
        
        System.out.println("Reading edges from text file");
        
        System.out.println(" ");
        
        //Read the edges
        for(e = 1; e <= E; ++e)
        {
            line = reader.readLine();
            parts = line.split(splits);
            u = Integer.parseInt(parts[0]);
            v = Integer.parseInt(parts[1]); 
            wgt = Integer.parseInt(parts[2]);
                    
            System.out.println("Edge " + toChar(u) + "--(" + wgt + ")--" + toChar(v));    
            
            //Insert new values to linked list
            insert(u, wgt, v); 
            insert(v, wgt, u);
        
         }
    }
    
    public void insert(int i, int x, int v)
    {
        Node n = new Node();
        n.wgt = x;
        n.vert = v;
        n.next = adj[i];
    
        adj[i] = n;
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
        
        for(v = 1; v <= V; ++v)
        {
            System.out.print("\nadj[" + toChar(v) + "] ->" );
            for(n = adj[v]; n != z; n = n.next)
            { 
                System.out.print(" |" + toChar(n.vert) + " | " + n.wgt + "| ->");   
            } 
        }
        
        System.out.println("");
    }

    //Method to initialise Depth First Traversal of Graph
    public void DF(int s) 
    {
        id = 0;
        
        for(int v = 1; v <= V; ++v)
        {
            visited[v] = 0;
        }
        
        System.out.println("\n Depth First Graph Traversal\n");
        System.out.println("Starting with Vertex: " + toChar(s) );
        
        //Start visiting the graph vertices using
        //DF from starting vertex s.
        dfVisit(0, s);
    }

    //Recursive Depth First Traversal for adjacency matrix
    private void dfVisit(int prev, int cur)  
    {
        visited[cur] = ++id;
        
        if(prev != 0 )   
        {
            System.out.println("Visited vertex | "+toChar(prev)+" | through edge  | " + prev + " | "+ toChar(cur) + " | ");
        }

        Node n;
        
        for(n = adj[cur]; n != z; n = n.next)  
        {
            if(visited[n.vert] == 0 )  
            {
                dfVisit(cur, n.vert);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        int s = 1;
        String fname = "Graph2.txt";               

        DepthFirstSearch g = new DepthFirstSearch(fname);
       
        g.display();
        
        g.DF(s);
    }

}