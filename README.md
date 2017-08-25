# Advanced Algorithms

A repository for my learning and understandings of complex Algorithms that are graph related in Java.

## Spanning Trees
- A spanning tree of an undirected G graph is a subgraph that includes all the vertices of the G graph, 
  but it usually doesn't include all the edges of this given graph.
- In general, a tree may have several spanning trees.
- We can assign a weight to each edge.
- A minimum spanning tree is then a spanning tree with weight less than or equal to 
  the weight of every other spanning tree.
- Spannings Trees have a lot of applications such as Big Data Analysis, finding the minimum cost for a
  telecommunications company laying out a cable into a new neighborhood.
- Standard Algorithms: Prim's Algorithm and Kruskal Algorithm (Both of them are greedy algorithms).

## Prim's Algorithm
The way Prim's Algorithm works is:
- The algorithm continuously increases the size of a tree, one edge at a time, starting with a tree consisting of a single vertex, until it spans all vertices.

##### Information
- Prim's algorithm is a greedy algorithm that finds a minimum spanning tree for a connected weighted undirected graph.
- This means it finds a subset of the edges that forms a tree that includes every vertex, where the total weight of all the edges in the tree is minimized.
- Time Complexity for: Binary heap and adjacency lists for sparse graph = O(V^2).
- Time Complexity for: Adjacency matrix for dense or sparse graph = O(V^2 logV).
- Time Complexity for: Fibonacci heap and adjacency list = O( E + V log V ).

Furthermore, adjacency lists use only the required memory for sparse graphs and are more efficient space wise for sparse graphs. Matrix representation is very inefficient both memory wise and in performance for sparse graphs.

Better to use an adjacency matrix for a dense graph, in which case which gives complexity O(V^2) and adjacency lists for sparse graphs O(V log2 V).

## Kruskal Algorithm
The way Kruskal Algorithm works is:
- We sort the edges according to their edge weights.
- This can be done with a Mergesort or a Quicksort.
- Then we must use a union find data structure also known as disjoint set. So we start adding edges to the MST and we want to make sure there will be no cycle in the MST.

##### Information
- Kruskal Algorithm is often used in computer networking.
- Time Complexity: O(N*LogN) with Mergesort or Quicksort.
- Worst Case : O(E*LogE). E is for the edges in the graph.
- Memory Complexity: Depending on the approach you take for example priority queue or sort the edge weights.

This algorithm can be used for huge graphs.
If the edges are sorted: The algorithm will be quasi-linear.
If we multiply the weights with a constant or add a constant to the edge weights: The results will be the same.
In this algorithm, the spanning trees are invariant under the transformation of these weights.

## Breadth First Search
When you have a graph and you want to visit every node, you can do it using this algorithm. Has serveral applications such as being used in the Dijkstra algorithm if all the edges weights are equal to one and in artificial intelligence.

##### Information
- Breadth First Search is used to constructs a shortest path.
- Time Complexity: O(V + E).
- Memory Complexity: Not good, we have to store a lot of references.

Iteration is available for Breadth First Search for the Linked List approach and the Array approach. We visit every vertex exactly once. We visit the neighbours then the neighbours of these new vertices and so on.

##### Abstract Data Type for Depth First Search: Queue.

This Breadth First Search is written in Java and uses the queue iteration.
- Method to initialise Breadth First Traversal of Graph.
- Iteration Breadth First Traversal for the adjacency matrix.
- Method to display the graph representation.

## Depth First Search
In computer science there are many useful algorithms that operate on a graph data structure such as Depth First Search. Before this is implemented we need to consider how graphs are stored in computer memory. Saving it on text file is good as it can be used a secondary storage.

##### Information
- Depth First Search is a widely used graph traversal algorithm and used as a strategy to solve mazes.
- Time Complexity: O(V + E).
- Memory Complexity: A bit better than Breadth First Search.

Recursion used for the Linked List approach and the Array approach. Iteration available for the Array approach for this Depth First Search, as far as the performance is concerned these two are approximately the same. So the speed of this algorithm is going to be the same even if you use the Recursion approach.

##### Abstract Data Type for Depth First Search: Stack.

This Depth First Search is written in Java, uses recursion as it's more compact and includes the following features:
- Method to initialise Depth First Traversal of Graph.
- Recursive Depth First Traversal for the adjacency matrix.
- Method to display the graph representation.

## Topological Ordering
Topological ordering of a directed graph is a linear ordering of its vertices such that for every directed edge "uv" from vertex "u" to vertex "v", "u" comes before v in the ordering.

For example in a game you would have a quest although that quest may have requirements such as completing other quests in order to complete this quest.

##### Information
- Time Complexity: Linear.
- We can use topological ordering only if the graph has no directed cycles.
- Important in project management.

As mentioned above the applications for Topological Ordering can be used in games such as quests and tasks. It can also be used in universities at constructing the syllabus.
