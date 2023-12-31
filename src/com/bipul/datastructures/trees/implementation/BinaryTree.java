package com.bipul.datastructures.trees.implementation;

import java.util.Scanner;

public class BinaryTree {

    protected Node root;

    public void preorderTraversal(){
        createSampleTree();
        preorderTraversal(root);
    }

    private void preorderTraversal(Node node){
        if(node == null) return;
        //print node
        System.out.print(node.value + " ");
        //print left
        preorderTraversal(node.left);
        //print right
        preorderTraversal(node.right);
    }

    public void inorderTraversal(){
        createSampleTree();
        inorderTraversal(root);
    }

    private void inorderTraversal(Node node){
        if(node == null) return;
        //print left
        inorderTraversal(node.left);
        //print node
        System.out.print(node.value + " ");
        //print right
        inorderTraversal(node.right);
    }

    public void postorderTraversal(){
        createSampleTree();
        postorderTraversal(root);
    }

    private void postorderTraversal(Node node){
        if(node == null) return;
        //print left
        postorderTraversal(node.left);
        //print right
        postorderTraversal(node.right);
        //print node
        System.out.print(node.value + " ");
    }

    public void populate(Scanner sc){
        System.out.println("Enter the root element: ");
        int val = sc.nextInt();
        this.root = new Node(val);
        populate(sc, root);
    }

    private void populate(Scanner sc, Node node){
        System.out.println("Do you want to insert element to the left of " + node.value + "? ");
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the left element: ");
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc, node.left);
        }

        System.out.println("Do you want to insert element to the right of " + node.value + "? ");
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the right element: ");
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(sc, node.right);
        }
    }

    public void createSampleBST(){
        this.root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.left = new Node(15);
        root.right.right = new Node(30);
        root.left.left.left = new Node(1);
        root.right.left.left = new Node(12);
        root.right.right.left = new Node(25);
        root.right.right.right = new Node(40);
    }

    public void createSimpleSampleTree(){
        this.root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.left = new Node(0);
        root.left.right = new Node(2);
        root.right.left = new Node(2);
//        root.right.right = new Node(7);
    }

    public void createSimpleSampleTree2(){
        this.root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
    }

    public void createSampleTree(){
        this.root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(15);
        root.left.left.left = new Node(23);
        root.left.right = new Node(13);
        root.left.right.left = new Node(22);
        root.left.right.left.left = new Node(24);
        root.left.right.left.left.right = new Node(28);
        root.left.right.right = new Node(25);
        root.right = new Node(12);
        root.right.right = new Node(43);
        root.right.left = new Node(16);
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

    //the node structure for tree
    protected class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
