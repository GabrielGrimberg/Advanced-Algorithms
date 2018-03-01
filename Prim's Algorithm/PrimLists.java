/* 
    Name: Gabriel Grimberg.
    Course: DT228/2.
    Module: Algorithms & Data Structures.
    Type: Final Year Assignment.
    Code: Prim's Algorithm using a Priority Queue(Heap).
    Class: Main Class.
*/

import java.io.*;
import java.util.Scanner;

public class PrimLists {
    
    public static void main(String[] args) throws IOException {
        
        Scanner keyInput = new Scanner(System.in);
        
        // Entering the file name.
        System.out.println("Enter the name of the file including the .txt : ");
        String fname = keyInput.nextLine(); 
        
        // Entering the starting vertex.
        System.out.println("Enter the vertex you wish to start on : ");
        int startVertex = keyInput.nextInt();             
        
        Graph g = new Graph(fname);
       
        g.display();                   // Display the graph.
        g.MST_Prim(startVertex);       // Performe Algorithm and display the weight of it.
        g.showMST();                   // Show the MST.
               
    }
}