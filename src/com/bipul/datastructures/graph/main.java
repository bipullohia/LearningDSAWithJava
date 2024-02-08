package com.bipul.datastructures.graph;

import com.bipul.datastructures.graph.implementation.GraphAdjacentList;
import com.bipul.datastructures.graph.implementation.GraphAdjacentMatrix;
import com.bipul.datastructures.graph.implementation.GraphEdgeList;

public class main {

    public static void main(String[] args) throws Exception {

        //EdgeList implementation check
//        GraphEdgeList<String> graph = new GraphEdgeList<String>(true);
        GraphAdjacentList<String> graph = new GraphAdjacentList<String>(false);
//        GraphAdjacentMatrix<String> graph = new GraphAdjacentMatrix<String>(false);
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");
        graph.addNode("H");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "E");
        graph.addEdge("B", "F");
        graph.addEdge("C", "G");
        graph.addEdge("D", "H");
        graph.addEdge("E", "H");
        graph.addEdge("H", "F");
        graph.addEdge("H", "G");

//        System.out.println("Is connected - C and H: " + graph.isConnected("C", "H"));
//        System.out.println("Is connected - H and G: " + graph.isConnected("H", "G"));
//        System.out.println("Is connected - G and H: " + graph.isConnected("G", "H"));
//        System.out.println("Is connected - A and D: " + graph.isConnected("A", "D"));
//
//        System.out.println("Neighbours of A: " + graph.getAdjacentNodes("A"));
//        System.out.println("Neighbours of F: " + graph.getAdjacentNodes("F"));
//        System.out.println("Neighbours of H: " + graph.getAdjacentNodes("H"));
//        System.out.println("Neighbours of C: " + graph.getAdjacentNodes("C"));

        graph.printAdjacencyListGraph();

        System.out.println(graph.bfsTraversal());

        System.out.println(graph.dfsTraversal());
    }
}
