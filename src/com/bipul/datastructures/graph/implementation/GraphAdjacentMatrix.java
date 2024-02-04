package com.bipul.datastructures.graph.implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphAdjacentMatrix<T> {
    //Adjacent matrix is great for dense graphs
    ArrayList<T> nodeList;
    ArrayList<ArrayList<Integer>> adjMatrix; //it should actually be an array matrix, but this would help with easy implementation
    boolean directed;

    public GraphAdjacentMatrix(boolean directed){
        nodeList = new ArrayList<>();
        adjMatrix = new ArrayList<>();
        this.directed = directed;
    }

    public void addNode(T value){
        int size = nodeList.size();
        //we set the initial values to 0 until the size of the array to make it behave like a 2D array/matrix

        //populate 0 until size+1 for newly added node, and 1 extra col of 0 for existing rows to make them also size+1

        nodeList.add(value);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<size; i++){
            list.add(0);
        }
        adjMatrix.add(list);

        //for all the rows of adj matrix, add a new col of value 0 (this takes extra O(n) in this way)
        for (ArrayList<Integer> arr : adjMatrix) {
            arr.add(0);
        }
    }

    public void addEdge(T node1, T node2) throws Exception {
        //find the index of the required node first
        int index1 = -1;
        int index2 = -1;
        for(int i=0; i<nodeList.size(); i++){
            if(nodeList.get(i) == node1) index1 = i;
            if(nodeList.get(i) == node2) index2 = i;
        }
        if(index1 == -1 || index2 == -1){
            throw new Exception("One of the node of this edge isn't present!");
        }

        adjMatrix.get(index1).set(index2, 1);

        //adding an edge for undirected graph
        if(!directed){
            adjMatrix.get(index2).set(index1, 1);
        }
    }

    public LinkedList<T> getAdjacentNodes(T node) throws Exception {
        LinkedList<T> neighbours = new LinkedList<>();

        //find the index of the required node first
        int index = -1;
        for(int i=0; i<nodeList.size(); i++){
            if(nodeList.get(i) == node) index = i;
        }
        if(index == -1){
            throw new Exception("This node doesn't exist!");
        }

        for(int j=0; j<adjMatrix.get(index).size(); j++){
            if(adjMatrix.get(index).get(j) == 1){
                neighbours.add(nodeList.get(j));
            }
        }

        return neighbours;
    }

    public boolean isConnected(T node1, T node2) throws Exception {
        int index1 = -1;
        int index2 = -1;
        for(int i=0; i<nodeList.size(); i++){
            if(nodeList.get(i) == node1) index1 = i;
            if(nodeList.get(i) == node2) index2 = i;
        }
        if(index1 == -1 || index2 == -1){
            throw new Exception("One of the node of this edge isn't present!");
        }

        return adjMatrix.get(index1).get(index2) == 1; //we are setting connections/edges as 1
    }

    public boolean isDirected(){
        return this.directed;
    }

    public void printAdjMatrix(){
        for (ArrayList<Integer> list: adjMatrix) {
            System.out.println(list.toString());
        }
    }
}
