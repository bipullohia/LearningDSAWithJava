package com.bipul.sorting;

import java.util.Arrays;
import java.util.HashMap;

public class CountSort {

    //this way is better and simpler compared to HashMap
    public int[] countSortArray(int[] arr){
        if(arr == null || arr.length <= 1) return arr;

        //get largest element in the array
        int largest = getLargestItem(arr);

        //new array of size largest+1 (so that it can contain the largest element)
        int[] frequencyArr = new int[largest+1];

        //populate the freq array
        for (int j : arr) {
            frequencyArr[j]++;
        }

        //repopulate the original array
        int index = 0;
        for (int i = 1; i < frequencyArr.length; i++) { //assuming >0 as items, hence start from 1 (we should ideally start from smallest number)
            while(frequencyArr[i] > 0){
                arr[index] = i;
                index++;
                frequencyArr[i]--;
            }
        }
        return arr;
    }

    public int[] countSortMap(int[] arr){
        if(arr == null || arr.length <= 1) return arr;

        //get largest element in the array
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        //new array of size largest+1
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        //populate the freq array
        for (int j : arr) {
            frequencyMap.put(j, frequencyMap.getOrDefault(j, 0) + 1);
        }

        //repopulate the original array (we don't know if the hash keys will come in sorted order so use for loop)
        int index = 0;
        for (int i = min; i <= max; i++) { //check from min to max to increase efficiency
            int count = frequencyMap.getOrDefault(i, 0);
            for (int j = 0; j < count; j++) {
                arr[index] = i;
                index++;
            }
        }

        return arr;
    }

    private int getLargestItem(int[] arr){
        //finding the largest element of the array
        int max = arr[0];
        for (int j : arr) {
            if (j > max)
                max = j;
        }
        return max;
    }

}
