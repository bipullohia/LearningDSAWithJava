package com.bipul;

import com.bipul.algorithms.HuffmanCoder;
import com.bipul.sorting.CountSort;
import com.bipul.sorting.RadixSort;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws Exception {

        String str = "abbccda";
        HuffmanCoder hc = new HuffmanCoder(str);

        String encoded = hc.encode(str);
        System.out.println(encoded);
        System.out.println(hc.decode(encoded));
    }
}
