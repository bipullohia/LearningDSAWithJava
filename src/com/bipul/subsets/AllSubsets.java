package com.bipul.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//printing all the subsets of the array
public class AllSubsets {
    public static void main(String[] args) {
        int[] arr = {3,5,6};
        List<List<Integer>> result = getSubsetsByRecursion1(arr, 0, arr.length-1, new ArrayList<>());
        System.out.println(result.toString());
    }

    //the result is NOT passed on as argument
    static List<List<Integer>> getSubsetsByRecursion1(int[] arr, int s, int e, ArrayList<Integer> processedList){
        List<List<Integer>> result = new ArrayList<>();

        //this means that there are no more elements left to be processed in the original array
        if(s>e){
            //can be thought of as empty array logically
            result.add(processedList);
            return result;
        }

        //the case where indexVal is excluded
        result.addAll(getSubsetsByRecursion1(arr, s+1, e, processedList));

        int indexVal = arr[s];
        ArrayList<Integer> incList = new ArrayList<>(processedList);
        incList.add(indexVal);
        //the case where indexVal is included
        result.addAll(getSubsetsByRecursion1(arr, s+1, e, incList));

        //NOTE: For some reason - for included - I need to create a separate ArrayList. Figure out why.
        //Figured out - this can be because creating new arrrayList makes a copy of it - hence safe
        return result;
    }


}