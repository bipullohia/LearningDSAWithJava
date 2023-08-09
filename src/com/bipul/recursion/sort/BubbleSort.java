package com.bipul.recursion.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3};
        //print sorted array
        System.out.println(Arrays.toString(bubble(arr, arr.length-1, 0)));
    }

    /* Implementation
    Assumptions:
    1.

    Params:
    array to be searched into, row (length of the array, iteration i), column (denotes the length to be searched with each iteration)

    Return value:
    sorted array
 */
    static int[] bubble(int[] arr, int r, int c){
        if(r==0) return arr; //base condition - means the sorting is complete

        if(r > c){
            //sort for particular r and push biggest element to the end
            if(arr[c] > arr[c+1]){
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            return bubble(arr, r, c+1);
        }else{
            return bubble(arr, r-1, 0);
        }
    }
}
