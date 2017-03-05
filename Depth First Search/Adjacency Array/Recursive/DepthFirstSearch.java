/* 
    Name: Gabriel Grimberg
    Course: DT228/2
    Module: Algorithms & Data Structures
    Type: Depth First Search (Array + Recurive Version)
*/

import java.io.*;

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
    START
        Graph :: DF( Vertex s) Begin
            id = 0
                for v = 1 to V
                    visited[v] = 0 
            dfVisit(Null, s)
    End
    */
    // method to initialise Depth First Traversal of Graph
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
        // DF from starting vertex s.
        dfVisit(0, s);
        
        
    }
    
    /*
    START
        Graph :: dfVisit( Vertex prev, Vertex v)
            visited[v] = ++id
            print “Visited vertex “, v, “ along edge “, prev, “—“, v
            
            for each vertex u  adj(v) 
                if not visited[u]
                    dfVisit(u) 
    END
    */
    // Recursive Depth First Traversal for adjacency matrix
    private void dfVisit(int prev, int v)
    {
        int u;
        
        //Mark the visted array.
        visited[v] = ++id;
        
        System.out.println("\nDF just visited vertex: " + toChar(v) + toChar(prev) + "--" + toChar(v) );
        
        //Each Vertex that's connect to U they have an edge in common.
        //How to know if it doesn't have an edge? The value is 0.
        //If you go to visit U from V and there is no edge it will go back to the loop.
        for(u = 1; u <= V; ++u)
        {
            if(adj[v][u] != 0 && visited[u] == 0)
            {
                dfVisit(v, u);
            }
        }

    }

    public static void main(String[] args) throws IOException
    {
        int s = 7;
        
        String fname = "Graph.txt";               

        DepthFirstSearch g = new DepthFirstSearch(fname);
       
        g.display();
        
        g.DF(s);
    }

}