package com.bipul.recursion.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,6,1,8,3,7,2,6,9,3,5,2,56,33,55};
        //print sorted array
        quicklySort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quicklySort(int[] arr, int low, int high){
        if(low >= high) return; //base condition

        //low is the first element of the aray/sub-array to be sorted, high is the last element
        int s = low;
        int e = high;
        int m = s + (e-s)/2;
        int pivot = arr[m];

        while(e>s){
            //this differentiates it from merge sort
            while(arr[s] < pivot){
                s++;
            }
            while(arr[e] > pivot){
                e--;
            }
            //this condition is checked again to make sure e is not less than s - which will mean that it is sorted
            if(s <= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        //pivot is at correct index, and at this point e>s and hence the sorting happens before pivot (low to e) and after pivot (s to high)
        quicklySort(arr, low, e);
        quicklySort(arr, s, high);
    }

}
