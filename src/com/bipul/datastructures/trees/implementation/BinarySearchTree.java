package com.bipul.datastructures.trees.implementation;

public class BinarySearchTree {
    private Node root;

    //NOTE: Traversals are in Binary Tree class

    public BinarySearchTree(){
    }

    public BinarySearchTree(int val){
        root = new Node(val);
    }

    public void insertArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    public void insertSortedArr(int[] arr){
        insertSortedArr(arr, 0, arr.length);
    }

    //Time complexity - Nlog(N) - inserting N times * logN to insert per item
    private void insertSortedArr(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        this.insert(arr[mid]);
        insertSortedArr(arr, start, mid);
        insertSortedArr(arr, mid+1, end);
    }

    public void insert(int value){
        if(isEmpty()){
            root = new Node(value);
            return;
        }

        insert(root, value);
    }

    public void detailedDisplay(){
        detailedDisplay(root, "Root node: ");
    }

    private void detailedDisplay(Node node, String text){
        if(node == null) return;

        System.out.println(text + node.value);
        detailedDisplay(node.left, "Left child of " + node.value + ": ");
        detailedDisplay(node.right, "Right child of " + node.value + ": ");
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    //a balanced tree has height between any two nodes at the same level <= 1
    private boolean isBalanced(Node node){
        if(node == null){
            return true; //empty node means balanced
        }
        //the height diff between left and right <= 1 and all the left and right sub-trees should also be balanced
        return Math.abs(getNodeHeight(node.left) - getNodeHeight(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    //easy way - maybe NOT as good for getting height/etc.
    private void insert(Node node, int value){
        if(value < node.value){
            //insert in the left-hand side
            if(node.left == null){
                //left is null, create a new Node and assign the value
                node.left = new Node(value);
            }else{
                //left has a node, call insert func recursively
                insert(node.left, value);
            }
        }else {
            //insert in the right hand-side (same logic as left)
            if(node.right == null){
                node.right = new Node(value);
            }else{
                insert(node.right, value);
            }
        }
    }

    public void insert2(int value){
        root = insert2(root, value);
    }

    //better way to insert maybe?
    private Node insert2(Node node, int value){
        //the node is null - new node to be created here and returned
        if(node == null){
            node = new Node(value);
            return node;
        }

        //if the new value is lesser than the node
        if(value < node.value){
            node.left = insert2(node.left, value);
        }

        //we ignore the duplicate values so not writing case for equals

        //if the new value is greater than the node
        if(value > node.value){
            node.right = insert2(node.right, value);
        }

        //the height increases by 1 since a new node is now added
        node.height = Math.max(getNodeHeight(node.left), getNodeHeight(node.right)) + 1;

        //returning the node back to the caller func
        return node;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int getNodeHeight(Node node){
        if(node == null) return -1;
        return node.height;
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
        System.out.println(indent + node.value);
        printTreeNodes(node.left, indent+"\t");
    }

    private class Node{
        private int value;
        private Node left;
        private Node right;
        private int height; //to avoid traversing for finding out the height

        public Node(int value){
            this.value = value;
        }
    }
}
