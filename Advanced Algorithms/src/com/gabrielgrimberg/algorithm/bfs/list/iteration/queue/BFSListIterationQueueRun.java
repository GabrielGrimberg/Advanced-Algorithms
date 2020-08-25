package com.gabrielgrimberg.algorithm.bfs.list.iteration.queue;

import java.io.IOException;

public class BFSListIterationQueueRun {
    public static void bfsListIterationQueueRun() throws IOException {

        int s = 2;

        String filePath = "resources/bfs/graph/list/graph-bfs-list-example.txt";

        BFSListIterationQueue g = new BFSListIterationQueue(filePath);

        g.display();

        System.out.println("\n");
        System.out.println("Breadth First Tree: ");

        g.BF(s);
    }
}