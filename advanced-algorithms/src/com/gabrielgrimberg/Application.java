package com.gabrielgrimberg;

import java.io.IOException;

import static com.gabrielgrimberg.algorithm.dfs.array.recursive.DFSArrayRecursiveRun.dfsIterationRecursive;
import static com.gabrielgrimberg.algorithm.dfs.list.recursive.DFSListRecursiveRun.dfsListRecursive;

public class Application {

    public static void main(String[] args) throws IOException {
        //topologicalOrder();
        //prim();
        //kruskal();
        //dijkstra();
        //dfsIterationStack();
        //dfsIterationRecursive();
        dfsListRecursive();
    }
}