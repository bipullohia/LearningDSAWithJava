package com.bipul.datastructures.stacksqueues.questions;

import java.util.EmptyStackException;
import java.util.Stack;

//this will implement insert efficient queue (where inserts are O(1) and removals are (n) - we can also implement where remove will be O(1) and insert will be O(n)
public class QueueUsingStacksInsertEff {

    private Stack<Integer> first; //primary/main queue used for storing data
    private Stack<Integer> second; //secondary queue used for holding data temporarily

    public QueueUsingStacksInsertEff(){
        first = new Stack<>();
        second = new Stack<>();
    }

    //pushes element x to the back of the queue
    public void push(int x){
        first.push(x);
    }

    //removes the element from the front of the queue and returns it
    public int pop(){
        //this will throw exception if the primary stack is empty, hence no need of those checks anymore
        if(this.empty()) throw new EmptyStackException();

        //we need to first get to the front of the queue - put all the items into the second queue - queue will invert
        while (!first.empty()){
            second.push(first.pop());
        }

        //the top of the second queue now is the front of the original queue, delete it and save to return it
        int deletedItem = second.pop();

        //put the elements from second stack back to the first one to restore original queue
        while (!second.empty()){
            first.push(second.pop());
        }
        return deletedItem;
    }

    //returns element at the front of the queue
    public int peek(){
        //this will throw exception if the primary stack is empty, hence no need of those checks anymore
        if(this.empty()) throw new EmptyStackException();

        //we need to first get to the front of the queue - put all the items into the second queue - queue will invert
        while (!first.empty()){
            int poppedItem = first.pop();
            second.push(poppedItem);
        }

        //the top of the second queue now is the front of the original queue, save it to return afterwards
        int peekedItem = second.peek();

        //put the elements from second stack back to the first one to restore original queue
        while (!second.empty()){
            int poppedItem = second.pop();
            first.push(poppedItem);
        }
        return peekedItem;
    }

    //returns true if the queue is empty, false otherwise
    public boolean empty(){
        return first.empty();
    }
}
