package com.gabrielgrimberg.algorithm.dijkstra;

public class Edge {

    private double eWeight; // Represent the weight of the edge.

    // Every edge connects to 2 vertices.
    private Vertex startVertex;
    private Vertex targetVertex;

    public Edge(double eWeight, Vertex startVertex, Vertex targetVertex) {
        this.eWeight = eWeight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public double geteWeight() {
        return eWeight;
    }

    public void seteWeight(double eWeight) {
        this.eWeight = eWeight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
}
