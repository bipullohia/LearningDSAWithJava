package com.bipul.datastructures;

import com.bipul.datastructures.hashmap.implementation.HashMapWithChain;

public class Main {

    public static void main(String[] args) throws Exception {

        HashMapWithChain<Integer, String> map = new HashMapWithChain<>();
        map.put(1, "Bipul");
        map.put(2, "Kartik");
        map.put(3, "Sourabh");
        System.out.println(map.get(2));
        System.out.println(map.display());
        System.out.println(map.remove(2));
        System.out.println(map.remove(3));
        map.display();
    }
}
