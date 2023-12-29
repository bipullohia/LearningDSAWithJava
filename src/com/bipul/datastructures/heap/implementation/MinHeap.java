package com.bipul.datastructures.heap.implementation;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> { //we can similarly create Heaps for Max/ etc.
    ArrayList<T> arrList;

    public MinHeap(){
        arrList = new ArrayList<>(); //creating a new array for a heap (using arraylist so that size isn't a constraint here)
    }

    //this is like peek(); it can be whatever we are writing the heap for (but ans is always the first element)!
    public T min(){
        return arrList.get(0);
    }

    //insert the item, and then using upheap (going up the heap) check and replace if heap is violated
    public void insert(T item){
        arrList.add(item);

        //calling upheap starting the position (last index) where the new item was added
        upheap(arrList.size()-1);
    }

    private void upheap(int i){
        if(i == 0) return; //first element was added, no parent
        int p = parent(i);
        if(arrList.get(i).compareTo(arrList.get(p)) < 0){
            //the child is smaller than the parent, swap
            swap(i, p);
            upheap(p);
        }
    }

    //this will remove the minimum item - item at index 0 - root item,
    // and we have to make sure we put the next min item at this position using downheap (going down the heap)
    public T remove() throws Exception {
        if(arrList.isEmpty()) throw new Exception("No element to be removed in the heap!");

        T removedItem = arrList.get(0); //fetching the first element
        if(arrList.size() > 1){
            int lastItem = arrList.size()-1;
            swap(0, lastItem); //swap first and last items, and start checking down from the first item
            arrList.remove(lastItem); //since smallest is now at the last index
            downheap(0);
        }else{
            arrList.remove(0); //only 1 item present, remove it
        }

        /*
            ------A simpler way for the above logic-------------
            T removedItem = arrList.get(0);
            T last = arrList.remove(arrList.size() - 1);
            if(!arrList.isEmpty()){
                list.set(0, last);
                downheap();
            }
         */

        return removedItem;
    }

    private void downheap(int i){
        int min = i; //setting min to i for the start
        int left = leftChild(i);
        int right = rightChild(i);
        //left child should be present and lower than the parent i
        if(left < arrList.size() && arrList.get(left).compareTo(arrList.get(min)) < 0){
            //left is smaller
            min = left;
        }

        //do same for right child
        if(right < arrList.size() && arrList.get(right).compareTo(arrList.get(min)) < 0){
            //right is smaller
            min = right;
        }

        //swap min with i if there's a different min
        if(min != i){
            swap(min, i);
            downheap(min); //repeat the process for new lowest item
        }
    }

    public void createHeapFromUnsortedArray(ArrayList<T> arr){
        if(arr.isEmpty()) return;
        this.arrList = arr; //setting the array provided to the root object

        //go from the level above leaf node until the top and keep doing downheap at every level
        int start = arrList.size()/2 - 1;
        for (int i = start; i >= 0; i--) {
            downheap(i); //Check if this for loop is correctly implemented
        }
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private int leftChild(int i){
        return i*2 + 1;
    }

    private int rightChild(int i){
        return i*2 + 2;
    }

    private void swap(int index1, int index2){
        T temp = arrList.get(index1);
        arrList.set(index1, arrList.get(index2));
        arrList.set(index2, temp);
    }

    public int size(){
        return arrList.size();
    }

    //ideally shouldn't be open for public
    public void display(){
        System.out.println(arrList.toString());
    }

}
