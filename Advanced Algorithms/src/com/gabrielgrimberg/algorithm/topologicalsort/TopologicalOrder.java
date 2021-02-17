package com.gabrielgrimberg.algorithm.topologicalsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalOrder {

    public static void topologicalOrder() {

        TODFS topologicalOrdering = new TODFS();

        List<Vertex> graph = new ArrayList<>();

        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));
        graph.add(new Vertex("6"));

        graph.get(2).addNeighbour(graph.get(3));
        graph.get(3).addNeighbour(graph.get(1));
        graph.get(4).addNeighbour(graph.get(0));
        graph.get(4).addNeighbour(graph.get(1));
        graph.get(5).addNeighbour(graph.get(0));
        graph.get(5).addNeighbour(graph.get(2));
        graph.get(6).addNeighbour(graph.get(3));

        for (Vertex value : graph) {
            if (!value.isVisited()) {
                topologicalOrdering.DFS(value);
            }
        }

        Stack<Vertex> stack = topologicalOrdering.getStack();

        for (int i = 0; i < graph.size(); i++) {
            Vertex vertex = stack.pop();
            System.out.print(vertex+"->");
        }
    }
}