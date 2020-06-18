package com.company;// A Java program to print topological
// sorting of a DAG  

import java.util.*;

// This class represents a directed graph  
// using adjacency list representation  
class Graph {
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
        Scanner readInput = new Scanner(System.in);

        //number of islands N
        boolean shouldrun = true;
        int numberOfBridger = 0;
        int numberOfIslands = 0;

        //enter the number of island that you gonna enter
        System.out.println("Enter the number of islands");

        do {
            try {
                numberOfIslands = Integer.parseInt(readInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter valid number please.");
            }
        } while (shouldrun);

        // Create a graph given in the above diagram
        Graph g = new Graph(numberOfIslands);


        //content of ئ
        //enter content of island
        System.out.println("Enter the number of islands");
        // testing splitString function

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println(
                "Following is a Topological " +
                        "sort of the given graph");
        g.topologicalSort();
    }

    void splitString(String index) {
        String str = index;
        String[] output = str.split(" ", 0);
    }
}
// This code is contributed by Aakash Hasija