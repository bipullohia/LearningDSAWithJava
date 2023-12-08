package com.bipul.datastructures.stacksqueues.questions;

import java.util.EmptyStackException;
import java.util.Stack;

//this will implement remove efficient queue (where removes are O(1) and inserts are (n) - we can also implement where insert will be O(1) and removes will be O(n)
public class QueueUsingStacksRemoveEff {

    private Stack<Integer> first; //primary/main queue used for storing data
    private Stack<Integer> second; //secondary queue used for holding data temporarily

    public QueueUsingStacksRemoveEff(){
        first = new Stack<>();
        second = new Stack<>();
    }

    //pushes element x to the back of the queue
    public void push(int x){
        //we need to first get to the front of the queue - put all the items into the second queue - queue will invert
        while (!first.empty()){
            second.push(first.pop());
        }

        //insert the new item into the first stack (to make it the last item of the queue)
        first.push(x);

        //put the elements from second stack back to the first one to restore original queue on top of the first item
        while (!second.empty()){
            first.push(second.pop());
        }
    }

    //removes the element from the front of the queue and returns it
    public int pop(){
        //this will throw exception if the primary stack is empty
        if(this.empty()) throw new EmptyStackException();

        return first.pop();
    }

    //returns element at the front of the queue
    public int peek(){
        //this will throw exception if the primary stack is empty
        if(this.empty()) throw new EmptyStackException();

        return first.peek();
    }

    //returns true if the queue is empty, false otherwise
    public boolean empty(){
        return first.empty();
    }
}
