package com.bipul.recursion.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class LinearSearchFindAllIndex {
    public static void main(String[] args) {
        int[] arr = {45,77,6,45,45,23,8,22};
        int target = 45;
        System.out.println(find2(arr, target, 0));
    }

    /* Implementation 1 (we are allowed to have a list as an argument)
        Assumptions:
        1.

        Params:
        array to be searched into, target element, current index to be checked, ArrayList being maintained for storing the indexes

        Return value:
        ArrayList<Integer> containing the indexes of the target element (empty list means target not found)
     */
    static ArrayList<Integer> find1(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length) return list;
        if(arr[index] == target)
            list.add(index);
        return find1(arr, target, index+1, list);
    }

    /* Implementation 2 (we are NOT allowed to have a list as an argument - it has be the part of the func body)
    Assumptions:
    1.

    Params:
    array to be searched into, target element, current index to be checked

    Return value:
    ArrayList<Integer> containing the indexes of the target element (empty list means target not found)
 */
    static ArrayList<Integer> find2(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length) return list;
        if(arr[index] == target)
            list.add(index);

        //index elements from the downstream calls
        ArrayList<Integer> listRecurse = find2(arr, target, index+1);

        //adding the downstream elements with the local list and return the local list
        list.addAll(listRecurse);
        return list;
    }
}
