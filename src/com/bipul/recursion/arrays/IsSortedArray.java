package com.bipul.recursion.arrays;

public class IsSortedArray {
    public static void main(String[] args) {
        int[] arr = {45,77,77,344,2327};
        System.out.println(isArraySorted2(arr, 0)); //the input index has to be 0 when func is called initially
    }

    /* Implementation 1
        Assumptions:
        1. we won't get an empty array (we can insert a condition here, but skipping that check for now)
        2. Array has positive integers only

        Params:
        array and input index

        Returns:
        true/false for sorted. true is empty array passed
     */
    static boolean isArraySorted1(int[] arr, int i){
        if(i==arr.length-1) return true; //last index
        if(arr[i] > arr[i+1]) return false;
        return isArraySorted1(arr, i+1);
    }

    /* Implementation 2 (more concise)
        Assumptions:
        1. we won't get an empty array (we can insert a condition here, but skipping that check for now)
        2. Array has positive integers only

        Params:
        array and input index

        Returns:
        true/false for sorted. true is empty array passed
     */
    static boolean isArraySorted2(int[] arr, int i){
        if(i==arr.length-1) return true; //last index
        return arr[i] <= arr[i+1] && isArraySorted2(arr, i+1);
    }

}
