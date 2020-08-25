package com.gabrielgrimberg.algorithm.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    /* Method to compute the paths of the vertices, passing in the starting vertex. */
    public void computePaths(Vertex sourceVertex) {

        // Set the starting vertex's distance to 0 as it need's to be initialised.
        sourceVertex.setDistance(0);

        // Create a priority queue to store the vertices
        // that's why the comparable interface is implemented in the Vertex class
        // because the priority queue is going to order its content and pose the question to
        // order the vertices according to their distance.
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();

        // At the beginning add the source vertex with the distance set to 0.
        priorityQueue.add(sourceVertex);

        // Iterate until the priority queue is not empty.
        while (!priorityQueue.isEmpty()) {

            // Get the actual vertex with the minimal distance from the starting vertex.
            Vertex actualVertex = priorityQueue.poll();

            // Consider all of the vertex's neighbours.
            for (Edge edge : actualVertex.getAdjacenciesList()) {

                Vertex v = edge.getTargetVertex();

                // Define a new distance, consider the edge's weight.
                double newDistance = actualVertex.getDistance() + edge.geteWeight();

                // If the new distance is smaller, which is a better solution.
                // then the priority queue most be updated as there is a better solution.
                if (newDistance < v.getDistance()) {

                    // Remove the previous vertex stored in v.
                    priorityQueue.remove(v);

                    // Set the new distance for the vertex and store it in v.
                    v.setDistance(newDistance);

                    // Set the previous vertex which is the predecessor as that's how it tracks.
                    v.setPreviousVertex(actualVertex);

                    // Add the new vertex to the priority queue.
                    priorityQueue.add(v);
                }
            }
        }
    }

    /* Method to backtrack from previous vertices to build a shortest path. */
    public List<Vertex> getShortestPathTo(Vertex targetVertex) {

        // Contains the vertices that have to be visited.
        List<Vertex> shortestPathToTarget = new ArrayList<>();

        // Backtracking, start at the target vertex, while it's not null, set the vertex to be equal to the previous vertex.
        for (Vertex vertex = targetVertex; vertex!= null; vertex = vertex.getPreviousVertex()) {

            shortestPathToTarget.add(vertex); // Add these vertices to the shortest path.
        }

        Collections.reverse(shortestPathToTarget); // Output will be in reverse order, so the collections must be reversed.

        return shortestPathToTarget;
    }
}
