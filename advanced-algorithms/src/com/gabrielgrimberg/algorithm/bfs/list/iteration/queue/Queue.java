package com.gabrielgrimberg.algorithm.bfs.list.iteration.queue;

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
