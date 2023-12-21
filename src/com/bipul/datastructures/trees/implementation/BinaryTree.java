package com.bipul.datastructures.trees.implementation;

import java.util.Scanner;

public class BinaryTree {

    private Node root;

    public void preorderTraversal(){
        getSampleTree();
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
        getSampleTree();
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
        getSampleTree();
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

    private void getSampleTree(){
        this.root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(15);
        root.left.right = new Node(13);
        root.right = new Node(12);
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
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }
}
