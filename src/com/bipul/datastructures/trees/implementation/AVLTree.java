package com.bipul.datastructures.trees.implementation;

public class AVLTree {
    private Node root;

    public AVLTree(){
    }

    public AVLTree(int val){
        root = new Node(val);
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

    public void insert(int value){
        root = insert(root, value);
    }

    private Node insert(Node node, int value){
        //the node is null - new node to be created here and returned
        if(node == null){
            node = new Node(value);
            return node;
        }

        //if the new value is lesser than the node
        if(value < node.value){
            node.left = insert(node.left, value);
        }

        //we ignore the duplicate values so not writing case for equals

        //if the new value is greater than the node
        if(value > node.value){
            node.right = insert(node.right, value);
        }

        //the height increases by 1 since a new node is now added
        node.height = Math.max(getNodeHeight(node.left), getNodeHeight(node.right)) + 1;

        //returning the node back to the caller func
        return rotate(node);
    }

    //This is where the magic of AVL happens - the self-balancing!
    private Node rotate(Node node) {
        if(getNodeHeight(node.left) - getNodeHeight(node.right) > 1){
            //left heavy cases
            if(getNodeHeight(node.left.left) - getNodeHeight(node.left.right) > 0){
                //left-left case
                return rightRotate(node); //right-rotate on Parent
            }

            if(getNodeHeight(node.left.left) - getNodeHeight(node.left.right) < 0){
                //left-right case
                node.left = leftRotate(node.left); //left-rotate on Grandchild
                return rightRotate(node); //right-rotate on Parent
            }
        }

        if(getNodeHeight(node.right) - getNodeHeight(node.left) > 1){
            //right heavy cases
            if(getNodeHeight(node.right.right) - getNodeHeight(node.right.left) > 0){
                //right-right case
                return leftRotate(node); //left-rotate on Parent
            }

            if(getNodeHeight(node.right.right) - getNodeHeight(node.right.left) < 0){
                //right-left case
                node.right = rightRotate(node.right); //right-rotate on Grandchild
                return leftRotate(node); //left-rotate on Parent
            }
        }

        return node;
    }

    private Node rightRotate(Node parent) {
        Node child = parent.left;
        parent.left = child.right;
        child.right = parent;

        //updating heights of parent and child since they were reconfigured
        parent.height = Math.max(getNodeHeight(parent.left), getNodeHeight(parent.right)) + 1;
        child.height = Math.max(getNodeHeight(child.left), getNodeHeight(child.right)) + 1;

        return child; //child is the new node
    }

    private Node leftRotate(Node parent) {
        Node child = parent.right;
        parent.right = child.left;
        child.left = parent;

        //updating heights of parent and child since they were reconfigured
        parent.height = Math.max(getNodeHeight(parent.left), getNodeHeight(parent.right)) + 1;
        child.height = Math.max(getNodeHeight(child.left), getNodeHeight(child.right)) + 1;

        return child; //child is the new node
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
