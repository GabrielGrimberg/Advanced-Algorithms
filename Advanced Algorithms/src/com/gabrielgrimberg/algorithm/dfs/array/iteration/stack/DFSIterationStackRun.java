package com.gabrielgrimberg.algorithm.dfs.array.iteration.stack;

import java.io.IOException;

public class DFSIterationStackRun {

    public static void dfsIterationStack() throws IOException {

        int s = 7;

        String filePath = "resources/dfs/graph/graph-dfs-example.txt";

        DFSIterationStack g = new DFSIterationStack(filePath);

        g.display();

        System.out.println("\n");
        System.out.println("Depth First Search: ");

        g.DF_Iter(s);
    }
}