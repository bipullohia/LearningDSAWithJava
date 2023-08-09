package com.bipul.recursion.sort;

import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = {3,6,1,8,3,7,2,6,9,3,5,2,56,33,55};
        //print sorted array
        merge(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //this will not call recursive func to get new array, the calc happens via indices of array
    static void merge(int[] arr, int s, int e){
        if(s == e) return; //this will mean 1 element in the s-e indices of the array
        
        int mid = (s+e)/2;
        merge(arr, s, mid);
        merge(arr, mid+1, e);

        join(arr, s, mid, e);
    }

    static void join(int[] arr, int s, int m, int e){
        int[] mix = new int[(e-s)+1]; //because the index is from 0 and we don't repeat the m in both sides of comparison

        int i = s; //for array s to m
        int j = m+1; //for array m+1 to e
        int k = 0; //for the new mix array

        //1st array is from s to m, 2nd array is from m+1 to e
        while(i<=m && j<=e){
            if(arr[i] <= arr[j]){
                mix[k] = arr[i];
                i++; k++;
            } else {
                mix[k] = arr[j];
                j++; k++;
            }
        }

        //populate the remaining elements is left in any of the two portions of array
        while(i<=m){
            mix[k] = arr[i];
            i++; k++;
        }
        while(j<=e){
            mix[k] = arr[j];
            j++; k++;
        }

        //adding the new mix (sorted part array) to the original array
        for(int l = 0; l < mix.length; l++){
            arr[s+l] = mix[l];
        }
    }
}
