package com.bipul.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//printing all the subsets of the array
public class AllSubsetsIteration {
    public static void main(String[] args) {
        int[] arr = {3,5,5};
        List<List<Integer>> result = getSubsetsByIteration(arr);
        List<List<Integer>> uniqueResults = getUniqueSubsetsByIteration(arr);
        System.out.println(result.toString());
        System.out.println(uniqueResults.toString());
    }

    //forming all the subsets using iterative loop
    static List<List<Integer>> getSubsetsByIteration(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int value : arr) {
            //adding the cases when there are already elements in the result
            int size = result.size(); //to know the size of result list before we begin adding more elements
            //include the current element
            for (int j = 0; j < size; j++) {
                List<Integer> existingSubset = new ArrayList<>(result.get(j));
                existingSubset.add(value);
                result.add(existingSubset);
            }
        }

        return result;
    }

    //ignores duplicate subsets
    static List<List<Integer>> getUniqueSubsetsByIteration(int[] arr){
        //for unique subsets - we can compare only to the previous element - which means array should be sorted
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for(int i=0; i < arr.length; i++){
            start = 0;
            if(i > 0 && arr[i]==arr[i-1])
                start = end+1;
            end = result.size() - 1;

            int size = result.size();
            for(int j=start; j<size; j++){
                List<Integer> existingSubset = new ArrayList<>(result.get(j));
                existingSubset.add(arr[i]);
                result.add(existingSubset);
            }
        }
        return result;
    }
}