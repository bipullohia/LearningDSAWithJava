package com.bipul.recursion.arraysAndSearch;

public class BinarySearch {

    public static void main(String[] args) {
        //returns the index of the number to be searched (-1 if not present)
        int arr[] = {4,5,7,9,22,56,86};
        int index = findBinarySearchIndex(arr, 3, 0, arr.length-1);
        System.out.println(index);
    }

    //s denotes start element, e denotes end element
    static int findBinarySearchIndex(int[] arr, int target, int s, int e){
        if (s>e) return -1;
        int m = s + (e-s)/2;

        if(arr[m] == target) return m;

        if(target > arr[m])
            return findBinarySearchIndex(arr, target, m+1, e);
        else
            return findBinarySearchIndex(arr, target, s, m-1);
    }
}
