package com.bipul;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,7,43,22,77,12,45,33};
        System.out.println(linearSearch(arr, 43));
    }

    //search array, return index or -1
    static int linearSearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
