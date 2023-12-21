package com.bipul.datastructures.stacksqueues.implementation;

import java.util.EmptyStackException;

public class Stack {
    private static final int DEFAULT_SIZE = 10;
    protected int[] data;

    private int ptr = -1; //this is the pointer which maintains the current index of the stack/data

    public Stack(){
        this(DEFAULT_SIZE); //this calls the object's constructor with 1 arg
    }

    public Stack(int size){
        data = new int[size];
    }

    public void push(int value) throws Exception{
        if(isFull()){ //this is not a dynamic stack - hence it can be full
            throw new StackException("Stack is already full");
        }
        ptr++;
        data[ptr] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return data[ptr--];
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return data[ptr];
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

    public boolean isFull(){
        return ptr >= data.length-1; //since pointer starts from 0
    }

    public void display(){
        for (int i = 0; i <= ptr; i++) {
            System.out.print(data[i] + " -> ");
        }
        System.out.println("TOP");
    }
}
