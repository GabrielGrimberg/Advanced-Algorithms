/* 
	Name: Gabriel Grimberg
	Course: DT228/2
	Module: Algorithms & Data Structures
	Type: Breadh First Search (Linked List + Iterative Version: Queue)
*/

import java.io.*;

class Queue {
	
	private class Node {
		
		int data;
		Node next;
	}

	Node z;
	Node head;
	Node tail;
	
	public Queue() {
		
		z = new Node(); 
		z.next = z;
		head = z;  
		tail = null;
	}

	public void display() {
		
		System.out.println("\nThe queue values are:\n");

		Node temp = head;
		
		while( temp != temp.next) {
			
			System.out.print( temp.data + "  ");
			temp = temp.next;
		}
		System.out.println("\n");
	}

	public void enQueue( int x) {
		
		Node temp;

		temp = new Node();
		temp.data = x;
		temp.next = z;
		
		// Case of empty list.
		if(head == z) {
			
			head = temp;
			
		} else { //Case of list not empty.
			
			tail.next = temp;
		}
		
		// New node is now at the tail.
		tail = temp;
	}


	// Assume the queue is non-empty when this method is called.
	public int deQueue() {
		
		if(head == head.next) {
			
			return -1;
		}
		else {
			
			int temp = head.data;
			
			head = head.next;
			
			return temp;
		}
	}

	public boolean isEmpty() {
		
			return head == head.next;
	}

	public boolean isMember(int x) {
		
		Node temp = head;
		
		while (temp != z) {
			
			if (temp.data == x) {
				
				return true;
			}
			
			temp = temp.next;
		}
		
		return false;
	}
	
}

class BreadthFirstSearch {
	
	class Node {
		
			public int vert;
			public int wgt;
			public Node next;
	}
		
	// V = number of vertices.
	// E = number of edges.
	// adj[] is the adjacency lists array.
	private int V, E;
	private Node[] adj;
	private Node z;
		
	// Used for traversing graph.
	private int[] visited;
	private int id;
		
	// Default constructor.
	public BreadthFirstSearch(String graphFile)  throws IOException {
		
		int u, v;
		int e, wgt;
		Node t;

		FileReader fr = new FileReader(graphFile);
		BufferedReader reader = new BufferedReader(fr);
	           
		String splits = " +";  // Multiple whitespace as delimiter.
		String line = reader.readLine();        
		String[] parts = line.split(splits);
		System.out.println(" ");
		System.out.println("Parts[] = " + parts[0] + " " + parts[1]);
				
		V = Integer.parseInt(parts[0]);
		E = Integer.parseInt(parts[1]);
				
		// Create sentinel node.
		z = new Node(); 
		z.next = z;
				
		// Create adjacency lists, initialised to sentinel node z.
		visited = new int[V+1];
		adj = new Node[V + 1];
		
		for(v = 1; v <= V; ++v) {
			
			adj[v] = z;               
		}
			
		System.out.println("Reading edges from text file");
			
		System.out.println(" ");
		
		// Read the edges.	
		for(e = 1; e <= E; ++e) {
			
			line = reader.readLine();
			parts = line.split(splits);
			u = Integer.parseInt(parts[0]);
			v = Integer.parseInt(parts[1]); 
			wgt = Integer.parseInt(parts[2]);
						
			System.out.println("Edge " + toChar(u) + "--(" + wgt + ")--" + toChar(v));    
				
			// Insert new values into the linked list.
			insert(u, wgt, v); 
			insert(v, wgt, u);
			
		}	   
	}
	 
	// Convert vertex into char for pretty printing.
	private char toChar(int u) {
		  
		return (char)(u + 64);
	}
	
	// Method to display the graph representation.
	public void display() {
		
		int v;
		Node n;
				
		for(v = 1; v <= V; ++v) {
			
			System.out.print("\nadj[" + toChar(v) + "] ->" );
			
			for(n = adj[v]; n != z; n = n.next) {
				
				System.out.print(" |" + toChar(n.vert) + " | " + n.wgt + "| ->");   
			} 
		}
			
		System.out.println("");
	}
	
	// Method to insert new values into the linked list.		
	public void insert(int i, int x, int vert) {
		
		Node node = new Node();
		node.wgt = x;
		node.vert = vert;
		node.next = adj[i];
		
		adj[i] = node;
	}

	
	public void BF(int s) {
		
		Queue q = new Queue();
		
		id = 0;
			
		for(int v = 0; v < V; v++) {
			
			visited[v] = 0;
		}
			
		q.enQueue(s);
			
		while(!q.isEmpty() ) {
			
			int v = q.deQueue();
		
			if(visited[v] == 0) {
				
				visited[v] = ++id;
				System.out.print(toChar(v) + " -> ");
					
				Node n = new Node();
				
				for(n = adj[v]; n != z; n = n.next) {
					 
					if(visited[n.vert] == 0 && n.wgt !=  0) {
						 
						q.enQueue(n.vert);
					}						
				}			
			}	
		}
	}
	
	// Main.
	public static void main(String[] args) throws IOException {
		
		int s = 2;
		String fname = "GraphExample.txt";               

		BreadthFirstSearch g = new BreadthFirstSearch(fname);
			 
		g.display();
			 
		System.out.println("\n");
	   	System.out.println("Breadth First Tree: ");
	
		g.BF(s);
		
	}

}