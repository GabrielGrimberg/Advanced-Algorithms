package com.gabrielgrimberg.algorithm.kruskal;

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

	private char toChar(int u) {
		return (char)(u + 64);
	}
}