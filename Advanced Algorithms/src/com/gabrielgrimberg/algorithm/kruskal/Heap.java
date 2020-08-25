package com.gabrielgrimberg.algorithm.kruskal;

class Heap {
	
	private int[] h;
	int N, Nmax;
	Edge[] edge;

	// Bottom up heap constructor.
	public Heap(int _N, Edge[] _edge) {
		
		int i;
		Nmax = N = _N;
		h = new int[N+1];
		edge = _edge;
	   
		// Initially just fill heap array with indices of edge[] array.
		for (i=0; i <= N; ++i) { h[i] = i; }
		   
		//Then convert h[] into a heap from the bottom up.
		for(i = N / 2; i > 0; --i) { siftDown(i); }
	}
	
	private void siftDown(int k) {
		
		int v, j;
		v = h[k];
		
		while(2 * k <= N) {
			
			j = 2 * k;
			
			if((j < N) && (edge[h[j+1]].wgt < edge[h[j]].wgt)) { ++j; }
			
			if(edge[v].wgt <= edge[h[j]].wgt) { break; }
			
			h[k] = h[j];
			k = j;
		}
		
		h[k] = v;
	}

	public int remove() {
		
		h[0] = h[1];
		h[1] = h[N--];
		
		siftDown(1);
		
		return h[0];
	}
	
}