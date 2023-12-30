package com.bipul;

import com.bipul.algorithms.HuffmanCoder;
import com.bipul.algorithms.SqrtDecomposition;

public class Main {

    public static void main(String[] args) throws Exception {

        int arr[] = {1,3,5,2,7,6,3,1,4,8};
        SqrtDecomposition sqrt = new SqrtDecomposition();
        System.out.println(sqrt.rangeQuery(arr, 5,9));
    }
}
