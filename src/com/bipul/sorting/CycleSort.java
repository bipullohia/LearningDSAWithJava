package com.bipul.sorting;

public class CycleSort {

    public static void main(String[] args) {
        int[] arr = {3,5,2,7,6,10,8,9,1,4}; //numbers 1-N
        printArr(getCycleSortedArray(arr));
    }

    //Solution1: This fails if we include 0 in the input array (so does Kunal's solution) - in that case - match the index with the value
    public static int[] getCycleSortedArray(int[] arr){
        for(int i = 0; i<arr.length-1; i++){
            while(arr[i] != i+1){
                swap(arr, i, arr[i]-1);
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void printArr(int[] arr){
        for (int n: arr) {
            System.out.println(n);
        }
    }

    //Solution: Kunal's way
    public static void getCycleSortedArrayKun(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
    }
}
