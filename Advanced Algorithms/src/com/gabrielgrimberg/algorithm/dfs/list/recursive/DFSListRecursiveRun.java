package com.gabrielgrimberg.algorithm.dfs.list.recursive;

import java.io.IOException;

public class DFSListRecursiveRun {

    public static void dfsListRecursive() throws IOException {

        int s = 1;

        String filePath = "resources/dfs/graph/graph-dfs-example.txt";

        DFSListRecursive g = new DFSListRecursive(filePath);

        g.display();

        g.DF(s);
    }
}
