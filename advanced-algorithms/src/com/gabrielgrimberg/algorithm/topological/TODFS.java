package com.gabrielgrimberg.algorithm.topological;

import java.util.Stack;

public class TODFS {

    private Stack<Vertex> stack;

    public TODFS() {
        this.stack = new Stack<>();
    }

    public void DFS(Vertex vertex) {
        vertex.setVisited(true);

        for (Vertex v : vertex.getNeighbourList()) {

            if (!v.isVisited()) { DFS(v); }
        }
        stack.push(vertex);
    }

    public Stack<Vertex> getStack() { return this.stack; }
}