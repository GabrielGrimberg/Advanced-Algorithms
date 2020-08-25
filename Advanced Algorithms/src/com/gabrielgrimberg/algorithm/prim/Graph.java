package com.gabrielgrimberg.algorithm.prim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Graph {

    class Node {

        public int vert;
        public int wgt;
        public Node next;
    }

    private int numberOfVertices, numberOfEdges;
    private Node[] adjacencyList;
    private Node z;
    private int[] mst;

    // Used for traversing graph.
    private int[] visited;
    private int id;

    public Graph(String graphFile) throws IOException {
        int u, v;
        int e, wgt;
        Node t;

        FileReader fr = new FileReader(graphFile);
        BufferedReader reader = new BufferedReader(fr);

        // Multiple whitespace as delimiter.
        String splits = " +";
        String line = reader.readLine();
        String[] parts = line.split(splits);
        System.out.println("\nVertices = " + parts[0] + " Edges = " + parts[1]);

        numberOfVertices = Integer.parseInt(parts[0]);
        numberOfEdges = Integer.parseInt(parts[1]);

        // Create sentinel node.
        z = new Node();
        z.next = z;

        // Create adjacency lists, initialised to sentinel node z.
        adjacencyList = new Node[numberOfVertices +1];

        for(v = 1; v <= numberOfVertices; ++v) { adjacencyList[v] = z; }

        // Read the edges.
        System.out.println("Reading edges from text file");
        System.out.println("Graph below in order of: Node, Weight and Node");

        for (e = 1; e <= numberOfEdges; ++e) {
            line = reader.readLine();
            parts = line.split(splits);
            u = Integer.parseInt(parts[0]);
            v = Integer.parseInt(parts[1]);
            wgt = Integer.parseInt(parts[2]);

            System.out.println("Edge " + toChar(u) + "--(" + wgt + ")--" + toChar(v));

            // Putting edge into adjacency matrix into the linked list.
            t = new Node();
            t.wgt = wgt;
            t.vert = v;
            t.next = adjacencyList[u];
            adjacencyList[u] = t;

            t = new Node();
            t.wgt = wgt;
            t.vert = u;
            t.next = adjacencyList[v];
            adjacencyList[v] = t;
        }
    }

    // Convert vertex into char for pretty printing.
    private char toChar(int u) {
        return (char)(u + 64);
    }

    // Method to display the graph representation.
    public void display() {
        int v;
        Node n;

        System.out.println("\nNodes connected to each other with distance.");

        for (v = 1; v <= numberOfVertices; ++v) {
            System.out.print("\nadj[" + toChar(v) + "] ->" );

            // Go through the vertices, for each one start at the beginning of the Linked List.
            for (n = adjacencyList[v]; n != z; n = n.next) {
                System.out.print(" |" + toChar(n.vert) + " | " + n.wgt + "| ->");
            }
        }
        System.out.println("");
    }

    public void primMinSpanningTree(int s) {
        int v, u;
        int wgt, wgt_sum = 0;
        int[]  dist, parent, hPos;
        Node t;

        dist = new int[numberOfVertices + 1];      // Distance from node to node.
        parent = new int[numberOfVertices + 1];    // Parent node.
        hPos = new int[numberOfVertices + 1];      // Current heap position.

        for (v = 0; v <= numberOfVertices; v++) {
            dist[v] = Integer.MAX_VALUE; // Set to infinity.
            parent[v] = 0; // Treat 0 as a special null vertex.
            hPos[v] = 0; // Indicates that it's not on the heap.
        }

        // Creating a new empty priority heap.
        // V is the max size of the heap array.
        Heap pq =  new Heap(numberOfVertices, dist, hPos);

        // Insert first element into the heap, s is used a the root of the MST.
        pq.insertIntoHeap(s);

        // Set the distance to 0.
        dist[s] = 0;

        while (!pq.isHeapEmpty()) {

            v = pq.removeFromHeap(); 	// Adding V to the MST.
            dist[v] = -dist[v]; // Marking V as in the MST.

            Node n;
            int w;

            // Examine each neighbour u of v.
            for (n = adjacencyList[v]; n != z; n = n.next) {
                u = n.vert;
                w = n.wgt;
                if (w < dist[u]) {
                    if (dist[u] != Integer.MAX_VALUE) {
                        wgt_sum -= dist[u];
                    }
                    dist[u] = w;
                    parent[u] = v;
                    wgt_sum += w;
                    if (hPos[u] == 0) {
                        pq.insertIntoHeap(u);
                    } else {
                        pq.siftUp(hPos[u]);
                    }
                }
            }

			/*
			//Contents of Dist[] and Parent[] Array Step by Step. *For Report Purposes*
			System.out.println("\n");

			for(int i = 1; i <= V; ++i)
			{
				System.out.println("Parent Array");
				System.out.println(toChar(i) + " -> " + toChar(parent[i]));
			}
			System.out.println("\n");

			for(int x = 1; x <= V; ++x)
			{
				System.out.println("Dist[] Array");
				System.out.println(x + " OR " + toChar(x) + " -> " + dist[x] );
			}
			*/
        }

        // Displaying the weight of the graph.
        System.out.println("\n");
        System.out.println("------------------------");
        System.out.println("- Weight of MST is: " + wgt_sum + " -");
        System.out.println("------------------------");
        mst = parent;
    }

    public void showMinSpanningTree() {
        System.out.print("\n\nMinimum Spanning tree parent array is:\n");
        for(int v = 1; v <= numberOfVertices; ++v) {
            System.out.println(toChar(v) + " -> " + toChar(mst[v]));
        }
        System.out.println("");
    }
}