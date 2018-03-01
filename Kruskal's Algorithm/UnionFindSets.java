/* 
	Name: Gabriel Grimberg.
	Course: DT228/2.
	Module: Algorithms & Data Structures.
	Type: Final Year Assignment.
	Code: Kruskal's Algorithm.
	Class: Union Class.
*/

/*******************************************************************
*															       *
*       UnionFind partition to support union-find operations       *
*       Implemented simply using Discrete Set Trees			       *
*        	 												       *
********************************************************************/
class UnionFindSets {
	
	private int[] treeParent;
	private int N;
	
	public UnionFindSets(int V) {
		
		N = V;
		treeParent = new int[V+1];
			
		for(int i = 1; i <= N; i++) {
			
			treeParent[i] = i;
		}	   
	}

	public int findSet(int vertex) {
		
		while(vertex != treeParent[vertex]) {
			
			vertex = treeParent[vertex];
		}
			
		return vertex;
	}
	
	public void union(int set1, int set2) {
		
		int xRoot = findSet(set1);
		int yRoot = findSet(set2);
			
		treeParent[yRoot] = xRoot;
	}
	
	public void showTrees() {
		
		int i;
		
		for(i = 1; i <= N; ++i) {
			
			System.out.print(toChar(i) + "->" + toChar(treeParent[i]) + "  " );
		}
		
		System.out.print("\n");
	}
	
	public void showSets() {
		
		int u, root;
		int[] shown = new int[N+1];
		
		for (u = 1; u <= N; ++u) {
			   
			root = findSet(u);
			
			if(shown[root] != 1) {
				
				showSet(root);
				shown[root] = 1;
			}            
		} 
		  
		System.out.print("\n");
	}

	private void showSet(int root) {
		
		int v;
		System.out.print("Set{");
		
		for(v = 1; v <= N; ++v) {
			
			if(findSet(v) == root) {
				
				System.out.print(toChar(v) + "");
			}
		}
		
		System.out.print("}  ");
	
	}
	
	private char toChar(int u) { return (char)(u + 64); }
	
}