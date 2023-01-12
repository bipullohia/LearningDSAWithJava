package com.bipul.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3,1,5,4,22,7,88,32,1,111,0,9};
        //int[] arr = {1,2,3,4,5,6,7,8,9};
        printArr(getBubbleSortedArray(arr));
    }

    public static int[] getBubbleSortedArray(int[] arr){
        boolean swapped;
        for(int i=0; i<arr.length-1; i++){
            swapped = false;
            //in every iteration, we bubble up the largest element to the end
            for(int j=1; j<arr.length-i; j++){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                    swapped = true;
                }
            }
            if(!swapped){
                System.out.println("Array already sorted, skipping the whole process");
                break;
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
}
