/***
 * Project Name: Dijkstra Algorithm
 * Date: 18th of March 2018
 * Class: Vertex
 * Type: Represent the vertices in the graph.
 ***/

package com.gabrielgrimberg;

import java.util.ArrayList;
import java.util.List;

// Using the priority queue to compare vertices but comparing to the according the distance.
public class Vertex implements Comparable<Vertex> {

    private String name;

    // A Vertex can have as many neighbours as every edge is pointing to a neighbour
    // with an adjacent vertex.
    private List<Edge> adjacenciesList;

    // Tracking to see if Vertex has been visited or not.
    private boolean visited;

    // Back-tracking.
    private Vertex previousVertex;

    // Representing the distance from the starting vertex.
    private double distance = Double.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    public void addNeighbour(Edge edge) {
        this.adjacenciesList.add(edge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                '}';
    }

    // Will compare which is the smaller distance.
    // Will return +1, -1 or 0.
    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance, otherVertex.getDistance());
    }
}
