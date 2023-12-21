package com.bipul.datastructures.stacksqueues.implementation;

public class CircularQueue{

    private static final int DEFAULT_SIZE = 10;
    protected int[] data;

    protected int front = 0; //we take initial index as 0 - if elements are present it will remain 0
    protected int end = 0;
    protected int size = 0;

    public CircularQueue(){
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size){
        data = new int[size];
    }

    public void insert(int value) throws Exception {
        if(isFull()){
            throw new Exception("Circular Queue is already full");
        }
        data[end++] = value;
        end = end % data.length;
        size++;
    }

    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removedItem = data[front++]; //we move the front by 1 pretending that it's the new start
        front = front % data.length;
        size--;
        return removedItem;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == data.length;
    }

    public int front() throws Exception {
        if(isEmpty()){
            throw new Exception("Circular Queue is empty");
        }
        return data[front];
    }

    public void display() throws Exception {
        if(isEmpty()){
            throw new Exception("Circular Queue is empty");
        }
        System.out.print("FRONT <- ");
        //this logic makes sure we start at the front and print it until the end (just before the end index to be precise)
        int i = front;
        do{
            System.out.print(data[i] + " <- ");
            i++;
            i = i%data.length;
        } while(i != end);

        System.out.println("END");
    }


}
