# Advanced Algorithms

A repository for my learning and understandings of complex Algorithms that are graph related in Java.

## Depth First Search
In computer science there are many useful algorithms that operate on a graph data structure such as Depth First Search. Before this is implemented we need to consider how graphs are stored in computer memory. Saving it on text file is good as it can be used a secondary storage.

- Depth First Search is a widely used graph traversal algorithm and used as a strategy to solve mazes.
- Time Complexity: O(V + E).
- Memory Complexity: A bit better than Breadth First Search.

Recursion and Iteration available for Depth First Search, as far as the performance is concerned these two are approximately the same. So the speed of this algorithm is going to be the same even if you use the Recursion approach.

##### Abstract Data Type for Depth First Search: Stack.

This Depth First Search is written in Java, uses recursion as it's more compact and includes the following features:
- Method to initialise Depth First Traversal of Graph.
- Recursive Depth First Traversal for the adjacency matrix.
- Method to display the graph representation.
