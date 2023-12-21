package com.bipul.datastructures.stacksqueues.implementation;

public class DynamicQueue extends CircularQueue{

    public DynamicQueue(){
        super();
    }

    public DynamicQueue(int size){
        super(size);
    }

    @Override
    public void insert(int value) throws Exception {
        //we make sure that if the array has become full, we double it
        if(isFull()){
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) { //we want to copy data.length times (< symbol since starting from 0)
                temp[i] = data[(front+i) % data.length]; //modulo concept to make sure circular queue values are copied
            }
            //front and end will straighten out in the new array of double length
            front = 0;
            end = data.length;
            data = temp;
        }

        //array size is not the issue anymore, hence we can directly insert item
        super.insert(value);
    }
}
