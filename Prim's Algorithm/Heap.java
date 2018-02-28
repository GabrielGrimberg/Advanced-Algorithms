/* 
	Name: Gabriel Grimberg.
	Course: DT228/2.
	Module: Algorithms & Data Structures.
	Type: Final Year Assignment.
	Code: Prim's Algorithm using a Priority Queue(Heap).
	Class: Heap
*/

import java.io.*;
import java.util.Scanner; //For keyboard input.

class Heap {
	
	private int[] h;	   // Heap array
	private int[] hPos;	   // hPos[h[k]] == k
	private int[] dist;    // dist[v] = priority of v
	
	//Size of heap.
	private int N;
   
	// The heap constructor gets passed from the Graph:
	// 1. Maximum heap size
	// 2. Reference to the dist[] array
	// 3. Reference to the hPos[] array
	public Heap(int maxSize, int[] _dist, int[] _hPos) {
		
		N = 0;                     //Assume size of heap is 0.
		h = new int[maxSize + 1];
		dist = _dist;              //Given as parameters and you intiliasie them.
		hPos = _hPos;              //Given as parameters and you intiliasie them.
	}
	
	//Method that checks if the heap is empty.
	public boolean isEmpty() {
		
		return N == 0;
	}


	public void siftUp( int k) {
	
		//Current position of the vertex.
		int v = h[k];
		
		//Making a dummy node to place at the top of the heap.
		//h[0] = 0;
		
		//Smallest value into distance 0 so it can be compared.
		dist[0] = 0;
		
		//While distance value at the current element.
		//Is less than the distance value at k / 2.
		//Keep dividing going up the list to insert the element
		//At the correct place.
		while(dist[v] < dist[ h[k / 2] ]) {
			
			//If not found, then siftUp the value to next value.
			h[k] = h[k / 2];
			hPos[ h[k] ] = k;
			
			//Then divide the element by 2 to go up.
			k = k / 2;
		}
		
		//Insert Vertex into the correct place on to the heap array.
		h[k] = v;
		hPos[v] = k;
	}


	public void siftDown(int k) {
		
		int v, j;
	   
		v = h[k];  
		
		j = 2 * k;
		
		while(j <= N) {
			
			if( (j + 1 <= N) && dist[ h[j] ] > dist[ h[j + 1] ] ) {
				
				j++; //Next element.
			}
			
			//If the distance of vertex element we are currently on is
			//Greater than the vertex we are sifting down then abort.
			if( dist[ h[j] ] >= dist[v] ) {
				
				break;
				
			} else { //If it's not then continue down the list.
			
				h[k] = h[j];
				k = j;
				j = k * 2;
			}
		}
		
		//When the right position is found put it into the array.
		h[k] = v;
		hPos[v] = k;
	}


	public void insert( int x) {
		
		//Adding a new vertex onto the end of the heap array.
		h[++N] = x;
		
		//Sifting up the vertex to find the correct location.
		siftUp( N);
	}

	public int remove() {
		
		//Give the element a 0 value then sift it down.  
		int v = h[1];
		
		//V is no longer in heap.
		hPos[v] = 0;
		
		//Put null node into empty spot
		h[N+1] = 0;
		
		h[1] = h[N--];
		siftDown(1);
		
		return v;
	}

}