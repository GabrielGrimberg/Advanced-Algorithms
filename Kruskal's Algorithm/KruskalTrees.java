/* 
    Name: Gabriel Grimberg.
    Course: DT228/2.
    Module: Algorithms & Data Structures.
    Type: Final Year Assignment.
    Code: Kruskal's Algorithm.
    Class: Main Class.
*/

import java.io.*;  
import java.util.Scanner;  
 
public class KruskalTrees {
    
    public static void main(String args[]) throws IOException {
        
        Scanner in = new Scanner(System.in);
            
        System.out.print("Enter the name of the graph with the .txt extension: ");
        
        // Entering the name of the text file with the graph in it.
        String fname = in.nextLine();
        
        // Creating the graph from the file.
        Graph g = new Graph(fname);
        
        // Getting the shortest patch using the algorithm.
        g.MST_Kruskal();
        
        // Displaying the shortest path made.
        g.showMST();
    }  
          
}