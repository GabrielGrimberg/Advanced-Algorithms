/* 
	Name: Gabriel Grimberg.
	Course: DT228/2.
	Module: Algorithms & Data Structures.
	Type: Final Year Assignment.
	Code: Kruskal's Algorithm.
	Class: Edge Class.
*/

class Edge {
	
	public int u, v, wgt;

	public Edge() {
		
		u = 0;
		v = 0;
		wgt = 0;
	}

	public Edge(int x, int y, int w) {
		
		this.u = x;
		this.v = y;
		this.wgt = w;	
	}
	
	public void show() {
		
		System.out.print("Edge  {" + toChar(u) + "}-{" + wgt + "}-{" + toChar(v) + "}\n") ;
	}
	
	// Convert vertex into char for pretty printing.
	private char toChar(int u) {
		  
		return (char)(u + 64);
	}
	
}