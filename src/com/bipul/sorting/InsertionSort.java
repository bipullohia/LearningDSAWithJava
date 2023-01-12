package com.bipul.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        //int[] arr = {3,1,5,4,22,7,88,32,1,111,0,9};
        //int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] arr = {2,5,3,4,1,2};
        printArr(getInsertionSortedArray(arr));
    }

    public static int[] getInsertionSortedArray(int[] arr){
        for(int i = 0; i <= arr.length-2; i++){
            for(int j = i+1; j>0; j--){
                if(arr[j]<arr[j-1]){
                   swap(arr, j, j-1);
                }else{
                    break;
                }
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
