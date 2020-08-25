package com.gabrielgrimberg.algorithm.kruskal;

import java.io.IOException;
import java.util.Scanner;

public class KruskalTrees {

    public static void kruskal() throws IOException {
        // Entering the name of the text file with the graph in it.
        String filePath = "resources/kruskal/graph/graph-kruskal-example.txt";
        
        // Creating the graph from the file.
        Graph g = new Graph(filePath);
        
        // Getting the shortest patch using the algorithm.
        g.MST_Kruskal();
        
        // Displaying the shortest path made.
        g.showMST();
    }
}