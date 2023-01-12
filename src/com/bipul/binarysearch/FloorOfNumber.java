package com.bipul.binarysearch;

public class FloorOfNumber {
    //Floor of a Num: largest element of the array lesser-than/equal-to the target element
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        System.out.println(floor(arr, 0));
    }

    static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return target;
            }
        }
        return end;
    }
}



