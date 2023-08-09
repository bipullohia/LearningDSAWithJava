package com.bipul.recursion.arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {45,77,6,23,8,22};
        int target = 45;
        System.out.println(search(arr, target, 0));
    }

    /* Implementation
        Assumptions:
        1.

        Params:
        array to be searched into, target element, and current index to be checked

        Return value:
        the position of the found element (-1 if not found or empty array)
     */
    static int search(int[] arr, int target, int index){
        if(index >= arr.length) return -1;
        if(arr[index] == target)
            return index;
        else
            return search(arr, target, index+1);
    }
}
