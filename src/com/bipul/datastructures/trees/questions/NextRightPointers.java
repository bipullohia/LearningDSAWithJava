package com.bipul.datastructures.trees.questions;

public class NextRightPointers {
    private Node root;

    public NextRightPointers(){}

    //Populating next right pointers in each node (do it without using queues since with queues it's pretty easy)
    public void connectNextRightPointers(){
        if(root == null) return;
        Node leftMost = root;

        while (leftMost.left != null){ //this being true means we are at the leaf node
            Node current = leftMost;
            while(current != null){
               current.left.next = current.right;
               if(current.next != null){
                   current.right.next = current.next.left;
               }
               current = current.next;
            }

            leftMost = leftMost.left;
        }
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
        System.out.println(indent + node.value + ", " + (node.next != null ? node.next.value: "null"));
        printTreeNodes(node.left, indent+"\t");
    }

    public void createSampleCompleteBinaryTree(){
        this.root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
    }

    private class Node {
        private int value;
        private Node left;
        private Node right;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }
}
