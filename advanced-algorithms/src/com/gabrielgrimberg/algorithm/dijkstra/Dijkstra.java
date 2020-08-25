package com.gabrielgrimberg.algorithm.dijkstra;

public class Dijkstra {

    public static void dijkstra() {

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