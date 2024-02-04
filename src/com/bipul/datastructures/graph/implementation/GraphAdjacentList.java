package com.bipul.datastructures.graph.implementation;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphAdjacentList<T> {
    //Adjacent list is great for sparse graphs
    ArrayList<Node<T>> nodeList;
    boolean directed;

    public GraphAdjacentList(boolean directed){
        nodeList = new ArrayList<>();
        this.directed = directed;
    }

    //O(1)
    public void addNode(T value){
        nodeList.add(new Node<>(value));
    }

    //O(n)
    public void addEdge(T node1, T node2) throws Exception{
        int index1 = -1;
        int index2 = -1;
        for(int i=0; i<nodeList.size(); i++){
            if(nodeList.get(i).value == node1) index1 = i;
            if(nodeList.get(i).value == node2) index2 = i;
        }
        if(index1 == -1 || index2 == -1){
            throw new Exception("One of the node of this edge isn't present!");
        }
        nodeList.get(index1).adjacentList.add(index2);

        //here, we need to add another pair for undirected graph
        if(!directed){
            nodeList.get(index2).adjacentList.add(index1);
        }
    }

    //O(1)
    public LinkedList<T> getAdjacentNodes(T node) throws Exception{
        LinkedList<T> neighbours = new LinkedList<>();

        //find the index of the required node first
        int index = -1;
        for(int i=0; i<nodeList.size(); i++){
            if(nodeList.get(i).value == node) index = i;
        }
        if(index == -1){
            throw new Exception("This node doesn't exist!");
        }

        //here i denotes the adjacent list indexes
        for(Integer i: nodeList.get(index).adjacentList){
            neighbours.add(nodeList.get(i).value);
        }
        return neighbours;
    }

    //O(n) - we have to loop through the adjacency list, and it can be as big as n
    public boolean isConnected(T node1, T node2) throws Exception{
        int index1 = -1;
        int index2 = -1;
        for(int i=0; i<nodeList.size(); i++){
            if(nodeList.get(i).value == node1) index1 = i;
            if(nodeList.get(i).value == node2) index2 = i;
        }
        if(index1 == -1 || index2 == -1){
            throw new Exception("One of the node of this edge isn't present!");
        }

        //checking for ordered pair
        for(Integer i: nodeList.get(index1).adjacentList){
            if(nodeList.get(i).value == node2){
                return true;
            }
        }

        //if undirected graph, checking for undirected pair
        if(!directed){
            for(Integer i: nodeList.get(index2).adjacentList){
                if(nodeList.get(i).value == node1){
                    return true;
                }
            }
        }
        return false;
    }

    public void printAdjacencyListGraph(){
        System.out.println("****** Adjacency List Representation of the Graph ******");
        for (Node<T> tNode : nodeList) {
            System.out.print("Node: " + tNode.value + ", Neighbours: ");
            for (Integer index : tNode.adjacentList) {
                System.out.print(nodeList.get(index).value + " ");
            }
            System.out.println();
        }
    }

    public boolean isDirected(){
        return this.directed;
    }

    private class Node<K>{
        private K value;
        private LinkedList<Integer> adjacentList;

        private Node(K value){
            this.value = value;
            this.adjacentList = new LinkedList<>();
        }

        public K getValue() {
            return value;
        }

        //stores indexes instead of the actual copy of the value
        public LinkedList<Integer> getAdjacentList() {
            return adjacentList;
        }
    }

}
