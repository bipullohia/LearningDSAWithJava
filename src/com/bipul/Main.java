package com.bipul;

import com.bipul.sorting.CountSort;
import com.bipul.sorting.RadixSort;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        RadixSort sort = new RadixSort();
        int[] arr = {29,83,471,3666,91,8};
        System.out.println(Arrays.toString(arr));
        sort.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
