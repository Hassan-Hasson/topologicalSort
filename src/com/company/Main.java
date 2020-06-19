package com.company;// A Java program to print topological
// sorting of a DAG  

import javax.swing.*;
import java.util.*;

// This class represents a directed graph  
// using adjacency list representation  
class Graph {
    static Scanner readInput = new Scanner(System.in);
    // No. of vertices
    private int Vertices;

    // Adjacency List as ArrayList of ArrayList's 
    private ArrayList<ArrayList<Integer>> graph;

    //Constructor  
    Graph(int v) {
        Vertices = v;
        graph = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; ++i)
            graph.add(new ArrayList<Integer>());
    }

    // Function to add an edge into the graph  
    void addEdge(int v, int w) {
        graph.get(v).add(w);
    }

    // A recursive function used by topologicalSort  
    void topologicalSortUtil(
            int v, boolean visited[],
            Stack<Integer> stack) {
        // Mark the current node as visited.  
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent  
        // to thisvertex  
        Iterator<Integer> it = graph.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack  
// which stores result  
        stack.push(new Integer(v));
    }

    // The function to do Topological Sort.  
    // It uses recursive topologicalSortUtil()  
    void topologicalSort() {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited  
        boolean visited[] = new boolean[Vertices];
        for (int i = 0; i < Vertices; i++)
            visited[i] = false;

        // Call the recursive helper  
// function to store
        // Topological Sort starting  
        // from all vertices one by one  
        for (int i = 0; i < Vertices; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack  
        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }


    // Driver method  
    public static void main(String args[]) {

        // reading inputs object


        //number of islands N
        boolean shouldrun = true;
        int numberOfBridger = 0;
        int numberOfIslands = 0;

        //enter the number of island that you gonna enter
        System.out.println("Enter the number of islands");

        do {
            try {
                numberOfIslands = Integer.parseInt(readInput.nextLine());
                shouldrun =false;
            } catch (NumberFormatException e) {
                System.out.println("Enter valid number please.");
            }
        } while (shouldrun);

//        System.out.println("make graph object");
        // Create a graph given in the above diagram
        Graph myGraph = new Graph(numberOfIslands);

        System.out.println("looping on Vertices to get its edges");
        for (int versIterator = 1; versIterator <= numberOfIslands; versIterator++) {
            System.out.println("enter your No."+ versIterator + " please." );
            List<Integer> verEdges  = getInputs();
//            System.out.println("veredge "+ verEdges.get(0));

            for(int edgIterator = 0; edgIterator < verEdges.size(); edgIterator++){
                if (edgIterator == verEdges.size()-1) myGraph.addEdge(verEdges.get(0), verEdges.get(edgIterator));
                else myGraph.addEdge(verEdges.get(0), verEdges.get(edgIterator));

            }
            // add edges and vertices to my graph

        }

        System.out.println(
                "Following is a Topological " +
                        "sort of the given graph");
        myGraph.topologicalSort();
    }

    public static List<Integer>  getInputs() {
        int temp;
        String tempString;
        List<Integer> output = new ArrayList<Integer>();
        boolean shouldrun = true;
        // reading inputs object
        Scanner readInput = new Scanner(System.in);
        System.out.println("enter your number followed by its edges separated by space");


        do {
             try {
                tempString = readInput.nextLine();
                String[] tempoutput =tempString.split(" ", 0);

                for (int i=0; i < tempoutput.length; i++){
                    temp = Integer.parseInt(tempoutput[i]);
                    output.add(temp);
                }
                shouldrun =false;
             } catch (NumberFormatException e) {
                 System.out.println("Enter valid number please.");
             }
        } while (shouldrun);

        //it's the index of island that have a problem



        return output;
    }


    public static String[] splitString(String index) {
        int temp;
        String str = index;
        String[] output = str.split(" ", 0);


        return output;
    }
}
// This code is contributed by Aakash Hasija