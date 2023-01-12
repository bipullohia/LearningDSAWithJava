package com.bipul.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {4,77,12,5,1,3,2};
        printArr(getSelectionSortedArray(arr));
    }

    public static int[] getSelectionSortedArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //number of comparisons will be 1 less than total number of elements in the array
            int biggest = 0; //assuming the first element to be biggest
            for (int j = 0; j < arr.length - i - 1; j++){ //we want to check only the indices which haven't been sorted yet
                if (arr[j+1] > arr[biggest]) {
                    biggest = j + 1; //if a bigger element found, update the biggest's index
                }
            }
            //shifting the biggest element to the end
            swap(arr, arr.length-1-i, biggest);
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

