package com.gabrielgrimberg.algorithm.prim;

class Heap {

    private int[] heapSize;
    private int[] heapPosition;
    private int[] distance;

    private int sizeOfHeap;

    public Heap(int maxSize, int[] _dist, int[] _hPos) {
        sizeOfHeap = 0;
        heapSize = new int[maxSize + 1];
        distance = _dist;
        heapPosition = _hPos;
    }

    public boolean isHeapEmpty() { return sizeOfHeap == 0; }

    public void siftUp(int k) {
        // Current position of the vertex.
        int v = heapSize[k];

        // Making a dummy node to place at the top of the heap.
        // h[0] = 0;

        // Smallest value into distance 0 so it can be compared.
        distance[0] = 0;

        // While distance value at the current element.
        // Is less than the distance value at k / 2.
        // Keep dividing going up the list to insert the element
        // At the correct place.
        while(distance[v] < distance[ heapSize[k / 2] ]) {

            // If not found, then siftUp the value to next value.
            heapSize[k] = heapSize[k / 2];
            heapPosition[ heapSize[k] ] = k;

            // Then divide the element by 2 to go up.
            k = k / 2;
        }

        // Insert Vertex into the correct place on to the heap array.
        heapSize[k] = v;
        heapPosition[v] = k;
    }

    public void siftDown(int k) {
        int v, j;

        v = heapSize[k];

        j = 2 * k;

        while (j <= sizeOfHeap) {
            if ((j + 1 <= sizeOfHeap) && distance[heapSize[j]] > distance[heapSize[j + 1]]) {
                j++; // Next element.
            }

            // If the distance of vertex element we are currently on is
            // Greater than the vertex we are sifting down then abort.
            if (distance[heapSize[j]] >= distance[v]) {
                break;
            } else { // If it's not then continue down the list.
                heapSize[k] = heapSize[j];
                k = j;
                j = k * 2;
            }
        }

        // When the right position is found put it into the array.
        heapSize[k] = v;
        heapPosition[v] = k;
    }

    public void insertIntoHeap(int x) {
        //Adding a new vertex onto the end of the heap array.
        heapSize[++sizeOfHeap] = x;
        //Sifting up the vertex to find the correct location.
        siftUp(sizeOfHeap);
    }

    public int removeFromHeap() {
        //Give the element a 0 value then sift it down.
        int v = heapSize[1];

        //V is no longer in heap.
        heapPosition[v] = 0;

        //Put null node into empty spot
        heapSize[sizeOfHeap +1] = 0;

        heapSize[1] = heapSize[sizeOfHeap--];
        siftDown(1);

        return v;
    }
}