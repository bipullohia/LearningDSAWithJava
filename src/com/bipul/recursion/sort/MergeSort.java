package com.bipul.recursion.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,6,1,8,3,7,2,6,9,3,5,2,56,33,55};
        //print sorted array
        System.out.println(Arrays.toString(merge(arr)));
    }

    static int[] merge(int[] arr){
        if(arr.length == 1) return arr;

        int mid = arr.length/2;
        int[] arrLeft = merge(Arrays.copyOfRange(arr, 0, mid));
        int[] arrRight = merge(Arrays.copyOfRange(arr, mid, arr.length));

        return joinArrays(arrLeft, arrRight);
    }

    static int[] joinArrays(int[] firstArray, int[] secondArray){
        int[] joinedArr = new int[firstArray.length + secondArray.length];
        int i=0, j=0; //initializing both starting values from 0 for two arrays in the args
        int k=0; //index for populating joinedArray

        while(i < firstArray.length && j < secondArray.length){
            if(firstArray[i] < secondArray[j]){
                joinedArr[k] = firstArray[i];
                i++;
            }else{
                joinedArr[k] = secondArray[j];
                j++;
            }
            k++;
        }

        //populate the remaining elements if one of the array finished early
        while(i < firstArray.length){
            joinedArr[k] = firstArray[i];
            k++; i++;
        }
        while(j < secondArray.length){
            joinedArr[k] = secondArray[j];
            k++; j++;
        }

        return joinedArr;
    }
}
