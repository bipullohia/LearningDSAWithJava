package com.bipul.datastructures.trees.implementation;

public class SegmentTreeSum {
    private Node root;

    //we need the constructor to take an array of elements and create a segment tree from it as a starting point
    public SegmentTreeSum(int[] arr){
        //create the segment tree
        //NOTE: Creating this segment tree will take O(n) time. But in long term, this can be assumed as constant value!
        for (int i = 0; i < arr.length; i++) {
            root = createSegmentTree(arr, 0, i);
        }
    }

    //finding the query
    public int getSum(int start, int end){
        return getSum(root, start, end);
    }

    //start, end denote user given index range for query/sum; nodeStart, nodeEnd are specific node's start/end
    private int getSum(Node node, int start, int end){
        //node interval is completely inside the query interval
        if(node.startIndex >= start && node.endIndex <= end)
            return node.sum;

        //node interval is completely outside the query interval
        if(start > node.endIndex || end < node.startIndex)
            return 0;

        //overlapping
        return getSum(node.left, start, end) + getSum(node.right, start, end);
    }

    public void updateElement2(int index, int value){
        root.sum = updateElement2(root, index, value);
    }

    private int updateElement2(Node node, int index, int newValue){
        //if index lies in the range
        if(index >= node.startIndex && index <= node.endIndex){
            if(index == node.startIndex && index == node.endIndex){
                //leaf node to be updated has been found!
                node.sum = newValue;
                return node.sum;
            }else{
                //search left and right
                int leftSum = updateElement2(node.left, index, newValue);
                int rightSum = updateElement2(node.right, index, newValue);
                node.sum = leftSum+rightSum;
                return node.sum;
            }
        }
        return node.sum;
    }

    public void updateElement(int index, int value){
        this.root = updateElement(root, index, value, root.startIndex, root.endIndex);
    }

    private Node updateElement(Node node, int index, int newValue, int startIndex, int endIndex){
        if(index < startIndex || index > endIndex){
            return node; //index out of range, return node as is
        }

        if(startIndex >= endIndex){
            //leaf node to be updated has been found!
            node.sum = newValue;
            return node;
        }

        int mid = (startIndex + endIndex)/2;
        if(index<=mid){
            //check left sub-tree
            node.left = updateElement(node.left, index, newValue, startIndex, mid);
        }else {
            //check right sub-tree
            node.right = updateElement(node.right, index, newValue, mid+1, endIndex);
        }

        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    //value i to be inserted via root node
    private Node createSegmentTree(int[] arr, int startIndex, int endIndex){
        if(startIndex >= endIndex){ //this denotes a leaf node
            //create a new leaf node with this value
            Node n = new Node(startIndex, endIndex);
            n.sum = arr[startIndex];
            return n;
        }

        //creating a new node to store left and right sub-tree and query data
        Node node = new Node(startIndex, endIndex);
        int mid = (startIndex+endIndex)/2;
        node.left = createSegmentTree(arr, startIndex, mid);
        node.right = createSegmentTree(arr,mid+1, endIndex);

        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    //displays using the root node of the object
    public void display(){
        printTreeNodes(this.root, "");
    }

    private void printTreeNodes(Node node, String indent){
        if(node == null){
            return;
        }
        printTreeNodes(node.right, indent+"\t");
        System.out.println(indent + node.sum);
        printTreeNodes(node.left, indent+"\t");
    }

    private class Node{
        private int sum; //this represents the query which is 'sum' of elements here
        private int startIndex;
        private int endIndex;
        private Node left;
        private Node right;

        public Node(int startIndex, int endIndex){
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }


}
