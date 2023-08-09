package com.bipul.recursion.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3,5,0,9};
        //print sorted array
        System.out.println(Arrays.toString(selection(arr, arr.length-1, 0, 0)));
    }

    //Selection sort is selecting the largest element in an iteration and putting it in the end
    static int[] selection(int[] arr, int r, int c, int max){
        if(r==0) return arr; //base condition - means the sorting is complete

        if(r > c){
            //sort for particular r and push biggest element to the end
            if(arr[c] > arr[max]){
                max = c;
            }
            return selection(arr, r, c+1, max);
        }else{
            //end of the iteration
            int temp = arr[r];
            arr[r] = arr[max];
            arr[max] = temp;
            return selection(arr, r-1, 0, 0);
        }
    }
}
