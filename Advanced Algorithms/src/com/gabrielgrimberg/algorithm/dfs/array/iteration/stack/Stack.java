package com.gabrielgrimberg.algorithm.dfs.array.iteration.stack;

class Stack {

    class Node
    {
        int data;

        // Reference (placeholder).
        Node next;
    }

    // Top reference to node.
    private Node top;

    // Constructs an empty stack.
    public Stack() {

        top = null;
    }

    public void push(int x) {

        // Creating a new node.
        Node  t = new Node();
        t.data = x;
        t.next = top;
        top = t;
    }

    // Only called if the list is not empty.
    public int pop() {

        Node t = top;
        top = top.next;

        return t.data;
    }

    // Method to see if the stack is empty.
    public boolean isEmpty() {

        return top == null;
    }

    // Method to see if a node is in stack.
    public boolean isMember(int x) {

        Node current = top;

        while (current != null) {

            if(current.equals(x)) {

                return true;

            } else {

                current = current.next;
            }
        }

        return false;
    }
}
