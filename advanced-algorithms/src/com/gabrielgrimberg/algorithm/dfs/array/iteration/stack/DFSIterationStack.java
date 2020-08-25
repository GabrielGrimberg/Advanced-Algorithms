package com.gabrielgrimberg.algorithm.dfs.array.iteration.stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class DFSIterationStack {

    // V = number of vertices.
    // E = number of edges.
    // adj[ ][ ] is the adjacency matrix.
    private int V, E;
    private int[][] adj;

    // Used for traversing graph.
    private int[] visited;
    private int id;

    // Default constructor, takes a single parameter give it the name of the graph file.
    // Exception thrown if file not found.
    public DFSIterationStack(String graphFile) throws IOException {

        int u, v;
        int e, wgt;

        // Create a file reader, give it a name of the file.
        FileReader fr = new FileReader(graphFile);

        // Then read the file.
        BufferedReader reader = new BufferedReader(fr);

        /***
         * Read it in as strings, you could have tabs, commas etc.. so you need a dilimiter.
         ***/
        String splits = " +";  											// Multiple whitespace as delimiter.
        String line = reader.readLine();								// Go to the reader.
        String[] parts = line.split(splits);							// We get the line and we split it, when you split it you get an array of strings.
        System.out.println("Parts[] = " + parts[0] + " " + parts[1]);	// Display the 2 strings, just to see if it's correct.

        V = Integer.parseInt(parts[0]); // Convert it from a string into an int.
        E = Integer.parseInt(parts[1]); // Convent it from a string into an int.

        // Create adjacency matrix, initialised to 0's.
        // Create 2 Dimensinal.
        adj = new int[V+1][V+1];

        // Create the visted array.
        visited = new int[V+1];

        // Read the edges.
        System.out.println("Reading edges from text file");

        for(e = 1; e <= E; ++e) {

            // Read a line.
            // Split it in string/parts.
            // This time there will be 3 parts to it, u,v,wgt.
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
    private char toChar(int u) {

        return (char)(u + 64);
    }

    // Method to display the graph representation.
    public void display() {

        int u,v;

        for(v=1; v<=V; ++v) {

            System.out.print("\nadj[" + v + "] = ");

            for(u = 1 ; u <= V; ++u) {

                System.out.print("  " + adj[u][v]);
            }
        }
        System.out.println("");
    }

    public void DF_Iter(int s) {

        Stack stack = new Stack();

        id = 0;

        for(int v = 0; v < V; v++) {

            visited[v] = 0;
        }
        stack.push(s);

        while(!stack.isEmpty()) {

            int v = stack.pop();

            if(visited[v] == 0) {

                visited[v] = ++id;
                System.out.print(toChar(v) + " -> ");

                for(int u = 1; u < adj[v].length; u++) {

                    if(visited[u] == 0) {

                        stack.push(u);
                    }
                }
            }
        }
    }
}
