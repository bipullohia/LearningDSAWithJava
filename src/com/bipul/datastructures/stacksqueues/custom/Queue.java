package com.bipul.datastructures.stacksqueues.custom;

public class Queue {
    private static final int DEFAULT_SIZE = 10;
    protected int[] data;

    private int end = 0; //acts as a pointer for the end of the queue where elements are added. This is 1 more than the number of elements actually present. If there are three elements, it'll be 4. This means 4th element will be inserted next

    public Queue(){
        this(DEFAULT_SIZE);
    }

    public Queue(int size){
        data = new int[size];
    }

    public int front() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }

    public void insert(int value) throws Exception {
        if(isFull()){
            throw new Exception("Queue is already full");
        }
        data[end++] = value;
    }

    public int remove() throws Exception { //This takes O(n) time which is pretty bad. This is solved by Circular Queues
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removedItem = data[0];
        //shift the items 1 place to left (replace data[0] with data[1] and so on..)
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removedItem;
    }

    public boolean isEmpty(){
        return end == 0;
    }

    public boolean isFull(){
        return end >= data.length-1; //since pointer starts from 0
    }

    public void display(){
        System.out.print("FRONT <- ");
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("BACK");
    }
}
