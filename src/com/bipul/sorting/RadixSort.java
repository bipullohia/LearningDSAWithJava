package com.bipul.sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//RadixSort uses CountSort - so that should be known before starting this!
public class RadixSort {

    public void radixSort(int[] arr){
        int max = maxDigitCount(arr);

        for (int exp = 1; exp <= max; exp++) { //exponent
            countSort(arr, (int) Math.pow(10, exp));
        }
    }

    //this will sort only based on the Xth digit from the right (here, exponent - not exactly since it starts from 10 instead of 1)
    //no return, reference object changed directly
    private void countSort(int[] arr, int exponent){
        if(arr == null || arr.length <= 1) return;

        //we know everytime we will be using max 9 digits at a time, so directly form frequency array[10] and prepopulate with empty lists
        List<List<Integer>> frequencyArrlist = new ArrayList<>(10); //this has to be arr of arr since we have to store complete digits
        for (int i = 0; i < 10; i++) {
            frequencyArrlist.add(new LinkedList<>());
        }

        for(int num: arr){
            //get xth digit from the right of the number num
            int temp = num;
            int x = exponent;
            while(x > 10){
                //bring x back to 10 to deal with digit's place - keep chipping from the temp
                temp = temp/10;
                x = x/10;
            }
            int digitToSort = temp%10;
            frequencyArrlist.get(digitToSort).add(num);
        }

        //repopulate the original array
        int index = 0;
        for (int i = 0; i < 10; i++) { //we can have it run from min to max for efficiency
            if(frequencyArrlist.get(i) != null){
                List<Integer> nums = frequencyArrlist.get(i);
                for(Integer num: nums){
                    arr[index] = num;
                    index++;
                }
            }
        }
    }

    //gets the max item of the array and returns the no. of digits
    private int maxDigitCount(int[] arr){
        if(arr.length == 0) return 0;
        int max = Arrays.stream(arr).max().getAsInt();

        //count digits
        int digits = 0;
        while(max > 0){
            digits++;
            max = max/10;
        }
        return digits;
    }

}
