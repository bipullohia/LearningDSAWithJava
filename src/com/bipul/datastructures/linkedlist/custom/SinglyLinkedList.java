package com.bipul.datastructures.linkedlist.custom;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    //adding a value to the end of the Linked List
    public void add(int value){
        if(this.head == null){ //the LinkedList is empty, creating new head with assigned value
            this.head = new Node(value);
            this.tail = this.head;
        }else{
            //Linked List already present, starting traversal from head
            Node node = this.head; //finding the tail
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node(value);
            this.tail = node.next;
        }
        size++;
    }

    public void addFirst(int value){
        Node temp = this.head;
        this.head = new Node(value);
        this.head.next = temp;
        this.size++;

        //if this is the first element
        if (tail == null){
            this.tail = this.head;
        }
    }

    public void addLast(int value){
        if(tail == null){
            //it is the first element being added
            this.addFirst(value);
            return;
        }

        this.tail.next = new Node(value);
        this.tail = this.tail.next;
        this.size++;
    }

    //Tricky - many things to keep in mind!!
    public void add(int index, int value){
        //checking if index given is valid
        if(index < 0 || index > this.size){
            System.out.println("Index entered (" + index + ") isn't valid. Cannot insert the value (" + value +")");
            throw new ArrayIndexOutOfBoundsException();
        }

        //the LinkedList is empty, creating new head with assigned value
        if(this.head == null || index == 0){
            this.addFirst(value);
            return;
        }

        if(index == this.size){
            this.addLast(value);
            return;
        }

        //inserting the value at index i (LinkedList already present)
        Node temp = this.head;
        for (int i=1; i<index; i++){
            temp = temp.next;
        }

        /* Usual way of adding a new node in the middle
        Node remainItems = temp.next; //this represents the pending items after the index provided in the arg
        Node node = new Node(value);
        temp.next = node; //pointing the previous element's node to the new value's node
        node.next = remainItems; //new value's next now connects to the remaining list
        */

        //adding the new node in middle using the constructor
        Node node = new Node(value, temp.next); //we are creating new node with new value and remaining elements of the list
        temp.next = node;
        this.size++;
    }

    //not to be exposed
    private Node getNode(int index){
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
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

    //returns value at index i
    public int get(int index){
        //checking if index given is valid
        if(index < 0 || index >= this.size){
            System.out.println("Index entered (" + index + ") isn't valid. Cannot get the value");
            throw new ArrayIndexOutOfBoundsException();
        }

        Node temp = this.head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp.value;
    }

    public void removeFirst(){
        if(this.size == 0){
            System.out.println("Linked List is already empty!");
            throw new ArrayIndexOutOfBoundsException();
        }
        if(head.next == null){
            this.clear();
        }else{
            this.head = this.head.next;
            size--;
        }
    }

    //PAIN POINT of Singly Linked List - have to traverse the entire list to remove this
    public void removeLast(){
        if(this.size == 0){
            System.out.println("Linked List is already empty!");
            throw new ArrayIndexOutOfBoundsException();
        }
        if(this.size == 1){
            this.removeFirst();
            return;
        }
        Node lastSecond = getNode(size-2); //getting the last second node
        this.tail = lastSecond;
        lastSecond.next = null;
        size--;
    }

    public void remove(int index){
        //checking if index given is valid
        if(index < 0 || index >= this.size){
            System.out.println("Index entered (" + index + ") isn't valid. Cannot get the value");
            throw new ArrayIndexOutOfBoundsException();
        }

        if(index == 0){
            this.removeFirst();
            return;
        }
        if(index == this.size-1){
            this.removeLast();
            return;
        }
        Node prev = getNode(index-1);
        prev.next = prev.next.next;
        size--;
    }

    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //The Node class containing the structure of each node
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = this.head;
        while(temp != null){
            sb.append(temp.value);
            temp = temp.next;
            if(temp != null){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
