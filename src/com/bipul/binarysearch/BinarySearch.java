package com.bipul.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {22, 25, 30, 37, 40, 42, 52, 70};
        System.out.println(binarySearchSelf(arr, 27));
    }

    static int binarySearchSelf(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;
        int mid;

        while(start <= end){
            mid = (start+end)/2;
            System.out.println("mid: " + mid);
            if(target == arr[mid]){
                return mid;
            } else if(target > arr[mid]){
                start = mid+1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
