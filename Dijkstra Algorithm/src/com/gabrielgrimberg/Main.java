/***
 * Project Name: Dijkstra Algorithm
 * Date: 22nd of June 2019
 * Class: Main
 * Type: Testing the application - Running the application.
 ***/

package com.gabrielgrimberg;

public class Main {

    public static void main(String[] args) {

        // Creating vertices
        Vertex sampleVertexOne = new Vertex("A");
        Vertex sampleVertexTwo = new Vertex("B");
        Vertex sampleVertexThree = new Vertex("C");

        // Joining up the vertices and defining a weight between them.
        sampleVertexOne.addNeighbour(new Edge(2, sampleVertexOne, sampleVertexTwo));
        sampleVertexOne.addNeighbour(new Edge(8, sampleVertexOne, sampleVertexThree));
        sampleVertexTwo.addNeighbour(new Edge(4, sampleVertexTwo, sampleVertexThree));

        // Instantiate the algorithm.
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm();

        // Pass in the starting vertex which is vertex A.
        algorithm.computePaths(sampleVertexOne);

        // Print out the shortest path to get from A to C.
        System.out.println(algorithm.getShortestPathTo(sampleVertexThree));

    }
}
