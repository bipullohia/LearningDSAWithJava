package com.bipul.datastructures.linkedlist.implementation;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public int getFirst(){
        if(this.head != null)
            return this.head.value;
        else
            throw new NullPointerException("The linked list is empty!");
    }

    public int getLast(){
        if(this.head != null)
            return this.tail.value;
        else
            throw new NullPointerException("The linked list is empty!");
    }

    public int get(int index){
        //checking if index given is valid
        if(index < 0 || index >= this.size){
            System.out.println("Index entered (" + index + ") isn't valid. Cannot get the value");
            throw new ArrayIndexOutOfBoundsException();
        }

        Node node = getNode(index);
        return node.value;
    }

    public void addFirst(int value){
        if(this.head == null){
            //no element in the list, create a new one
            addFirstElement(value);
            return;
        }
        Node node = new Node(value, this.head);
        //it still points to the old head, which is our 2nd element now
        this.head.previous = node;
        this.head = node;
        size++;
    }

    public void addLast(int value){
        if(this.head == null){
            //no element in the list, create a new one
            addFirstElement(value);
            return;
        }
        this.tail.next = new Node(value);
        this.tail.next.previous = this.tail;
        this.tail = this.tail.next;
        size++;
    }

    //adds an element to the last of the list
    public void add(int value){
        if(this.head == null){
            //no element in the list, create a new one
            addFirstElement(value);
            return;
        }

        Node node = new Node(value);
        this.tail.next = node;
        node.previous = this.tail;
        this.tail = node;
        size++;
    }

    public void add(int index, int value){
        //checking if index given is valid
        if(index < 0 || index > this.size){
            System.out.println("Index entered (" + index + ") isn't valid. Cannot insert the value (" + value +")");
            throw new ArrayIndexOutOfBoundsException();
        }

        if(this.head == null || index == 0){
            //no element in the list, create a new one
            addFirstElement(value);
            return;
        }

        if(index == size-1){
            addLast(value);
            return;
        }

        Node prev = getNode(index-1);
        Node newNode = new Node(value, prev.next);
        prev.next = newNode;
        newNode.previous = prev;
        newNode.next.previous = newNode;
        size++;
    }

    public void removeFirst(){
        if(this.size == 0){
            System.out.println("Linked List is already empty!");
            throw new ArrayIndexOutOfBoundsException();
        }

        this.head = this.head.next;
        if(this.head != null){
            this.head.previous = null;
        }else{
            this.tail = null;
        }
        size--;
    }

    public void removeLast(){
        if(this.size == 0){
            System.out.println("Linked List is already empty!");
            throw new ArrayIndexOutOfBoundsException();
        }

        if(this.size == 1){
            this.removeFirst();
            return;
        }

        Node prev = this.tail.previous;
        this.tail = prev;
        prev.next = null;
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

        if(index == size-1){
            this.removeLast();
            return;
        }

        Node prev = this.getNode(index-1);
        prev.next = prev.next.next;
        prev.next.previous = prev;
        size--;
    }

    private Node getNode(int index){
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //this assumes that the doubly linked list is empty - to be used internally
    private void addFirstElement(int value){
        //no element in the list, create a new one
        this.head = new Node(value);
        this.tail = this.head;
        this.size++;
    }

    public int size(){
        return this.size;
    }

    private class Node{
        private int value;
        private Node previous;
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
                sb.append("; ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String displayDetailed(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = this.head;
        while(temp != null){
            sb.append("[prev: ");
            if(temp.previous != null){
                sb.append(temp.previous.value);
            }else{
                sb.append("NULL");
            }

            sb.append(", current: ").append(temp.value).append(", next: ");

            if(temp.next != null){
                sb.append(temp.next.value);
            }else{
                sb.append("NULL");
            }
            sb.append("]");

            temp = temp.next;
            if(temp != null){
                sb.append("; ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
