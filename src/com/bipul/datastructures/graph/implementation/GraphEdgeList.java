package com.bipul.datastructures.graph.implementation;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphEdgeList<T> {

    ArrayList<T> nodeList; //we will be dealing with a lot of indexes here, better to have array-based implementation
    LinkedList<Edge> edgeList; //we can never really find an edge with index, hence better to use linked list here
    boolean directed; //to determine the edges that we need to add inside the edgeList and other results

    public GraphEdgeList(boolean directed){
        nodeList = new ArrayList<>();
        edgeList = new LinkedList<>();
        this.directed = directed;
    }

    public void addNode(T val){
        nodeList.add(val);
    }

    public void addEdge(T firstNode, T secondNode) throws Exception {
        int index1 = -1;
        int index2 = -1;
        for(int i=0; i<nodeList.size(); i++){
            if(nodeList.get(i) == firstNode) index1 = i;
            if(nodeList.get(i) == secondNode) index2 = i;
        }

        if(index1 == -1 || index2 == -1){
            throw new Exception("One of the node of this edge isn't present!");
        }
        addEdgeWithIndex(index1, index2);
    }

    public void addEdgeWithIndex(int firstIndex, int secondIndex){
        edgeList.add(new Edge(firstIndex, secondIndex));
        /*
        if(!directed){
            //for undirected graph, we can choose to add the reverse pair of nodes here, or not.
            //If we do add, we can have this code here: edgeList.add(new Edge(secondIndex, firstIndex));
            //If we don't add another pair, we need to keep this in mind for diff use cases.
            //Not adding here since it will save us extra edg
        }
        */
    }

    public LinkedList<T> getAdjacentNodes(T node) throws Exception{
        LinkedList<T> neighbours = new LinkedList<>();

        //assuming we get the node and not the index, we need to find the index of the node first
        int index = nodeList.indexOf(node);
        if(index == -1){
            throw new Exception("This node doesn't exist!");
        }

        for(Edge e: edgeList){
            if(e.firstIndex == index) neighbours.add(nodeList.get(e.secondIndex));
            //for undirected graph, we also need to check the other way round
            if(!directed && e.secondIndex == index) neighbours.add(nodeList.get(e.firstIndex));
        }

        return neighbours;
    }

    //we iterate through the edge list to see if we find a compatible connection -> O(n)
    public boolean isConnected(T node1, T node2){
        for(Edge e: edgeList){
            if(nodeList.get(e.firstIndex)==node1 && nodeList.get(e.secondIndex)==node2){
                return true;
            }

            //if it's an undirected graph, we need to check the opposite scenario too
            if(!directed && nodeList.get(e.secondIndex)==node1 && nodeList.get(e.firstIndex)==node2){
                return true;
            }
        }
        return false;
    }

    public boolean isDirected(){
        return this.directed;
    }

    //We implement edges based on indexes instead of copying the actual values
    private class Edge {
        private int firstIndex;
        private int secondIndex;
        //we can introduce an extra variable weight here if needed!

        private Edge(int firstIndex, int secondIndex){
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
        }

        public int getFirstIndex() {
            return firstIndex;
        }

        public int getSecondIndex() {
            return secondIndex;
        }
    }
}
