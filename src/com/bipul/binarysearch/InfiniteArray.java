package com.bipul.binarysearch;

public class InfiniteArray {

    public static void main(String[] args) {
        int[] arr = {2,3,5,6,7,8,9,10,11,12,14,16,18,22, 25, 30, 37, 40, 42, 52, 70};
        System.out.println(infiniteArraySearch(arr, 37));
    }

    //we assume array to be infinite
    static int infiniteArraySearch(int[] arr, int tar){
        int s = 0;
        int e = 1;
        while(tar > arr[e]){
           //logic
        }
        return binarySearch(arr, s, e, tar);
    }

    static int binarySearch(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = (start+end)/2;
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
