package com.gabrielgrimberg.algorithm.dfs.array.recursive;

import java.io.IOException;

public class DFSArrayRecursiveRun {

    public static void dfsIterationRecursive() throws IOException {

        int s = 7;

        String filePath = "resources/dfs/graph/graph-dfs-example.txt";

        DFSArrayRecursive g = new DFSArrayRecursive(filePath);

        g.display();

        g.DF(s);
    }
}