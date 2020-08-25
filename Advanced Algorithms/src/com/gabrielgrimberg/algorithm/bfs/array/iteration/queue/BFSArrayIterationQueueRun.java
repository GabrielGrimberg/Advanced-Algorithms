package com.gabrielgrimberg.algorithm.bfs.array.iteration.queue;

import java.io.IOException;

public class BFSArrayIterationQueueRun {

    public static void bfsArrayIterationQueueRun() throws IOException {

        int s = 2;

        String filePath = "resources/bfs/graph/array/graph-bfs-array-example.txt";

        BFSArrayIterationQueue g = new BFSArrayIterationQueue(filePath);

        g.display();

        System.out.println("\n");
        System.out.println("Breadh First Search: ");

        g.BF(s);

    }
}
