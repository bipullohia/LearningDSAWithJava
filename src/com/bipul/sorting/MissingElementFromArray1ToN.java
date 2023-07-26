package com.bipul.sorting;

public class MissingElementFromArray1ToN {

    public static void main (String[] args){
        //given array is 0-N -> find the missing number
        int n = 4;
        int[] arr = {2,3,0};
        System.out.println("Missing number:  " + missingNumber(arr));
    }

    private static int missingNumber(int[] arr) {
        int missingNumber = -1;
        int[] sortedArray = cyclesortedArray0ToN(arr);
        System.out.println(sortedArray);
        //step 1: sort the array (apply cycle sort because number is 0-N)

        //step 2: find the missing number in the sorted array

        return missingNumber;
    }

    private static int[] cyclesortedArray0ToN(int[] arr){
        int i = 0;
        while(i<arr.length){
//            if(arr[i] == i)
        }
        return arr;
    }

    private static void swap(int[] arr, int firstInd, int secondInd){
        int temp = arr[firstInd];
        arr[firstInd] = arr[secondInd];
        arr[secondInd] = temp;
    }

}
