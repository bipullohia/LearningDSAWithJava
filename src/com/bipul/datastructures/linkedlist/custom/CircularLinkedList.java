package com.bipul.datastructures.linkedlist.custom;

public class CircularLinkedList {

    private int size;
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        size = 0;
    }

    public void display(){
        if(head == null){
            System.out.println("Empty Circular List!");
            return;
        }

        System.out.print(head.value + " -> "); //printing the first element
        Node temp = head.next;
        while(temp != head){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("REPEAT");
    }

    public int getFirst(){
        if(head != null)
            return this.head.value;
        else
            throw new NullPointerException("The linked list is empty!");
    }

    public int getLast(){
        if(head != null)
            return this.tail.value;
        else
            throw new NullPointerException("The linked list is empty!");
    }

    private void createFirstElement(int value){
        //no list exists, creating a new one
        head = new Node(value);
        tail = head;
        size++;
    }

    public void addFirst(int value){
        if(head == null){
            createFirstElement(value);
            return;
        }

        Node node = new Node(value, head);
        tail.next = node;
        head = node; //in addLFirst - the head position will change, but tail remains same
        size++;
    }

    public void addLast(int value){
        if(head == null){
            createFirstElement(value);
            return;
        }

        Node node = new Node(value, head);
        tail.next = node;
        tail = node; //in addLast - the tail position will change, but head remains same
        size++;
    }

    public void add(int value){
        if(head == null){
            createFirstElement(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }


    public int size(){
        return size;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
