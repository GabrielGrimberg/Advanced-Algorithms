package com.gabrielgrimberg.algorithm.prim;

import java.io.IOException;
import java.util.Scanner;

public class Prim {

    public static void prim() throws IOException {

        Scanner keyInput = new Scanner(System.in);

        String filePath = "resources/prim/graph/graph-example.txt";

        System.out.println("Enter the vertex you wish to start on : ");
        int startVertex = keyInput.nextInt();

        Graph graph = new Graph(filePath);

        graph.display();                            // Display the graph.
        graph.primMinSpanningTree(startVertex);     // Perform Algorithm and display the weight of it.
        graph.showMinSpanningTree();                // Show the MST.
    }
}