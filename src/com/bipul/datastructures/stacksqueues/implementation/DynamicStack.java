package com.bipul.datastructures.stacksqueues.implementation;

public class DynamicStack extends Stack{
    public DynamicStack(){
        super();
    }

    public DynamicStack(int size){
        super(size);
    }

    @Override
    public void push(int value) throws Exception {
        //we make sure that if the array has become full, we double it
        if(isFull()){
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }

        //array size is not the issue anymore, hence we can directly insert item
        super.push(value);
    }
}
