package com.bipul.binarysearch;

public class SmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        int[] arr = {2,7,8,15,33,80};
        char[] chars = {'x','x','y','y'};
        System.out.println(smallestNumGreaterThanTar(chars, 'y'));
    }

    static char smallestNumGreaterThanTar(char[] arr, char target){

        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(target < arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return arr[start%arr.length];
    };
}
