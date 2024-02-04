package com.bipul;

import com.bipul.algorithms.HuffmanCoder;
import com.bipul.algorithms.SqrtDecomposition;
import com.bipul.datastructures.linkedlist.questions.SinglyLinkedList;
import com.bipul.datastructures.trees.questions.BFS;
import com.bipul.datastructures.trees.questions.DFS;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

//        SinglyLinkedList sll = new SinglyLinkedList();
//        sll.getListWithTail();
//        System.out.println(sll);
//
//        sll.removeNodesWithVal(6);
//        System.out.println(sll);
//
//        String ss = "lleh";
//        String tt = "hell";
//        char[] arr = ss.toCharArray();
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//
        StringBuilder sb1 = new StringBuilder("hello");
        StringBuilder sb2 = new StringBuilder("hello");
        System.out.println();
//        System.out.println(ss.hashCode());
//        System.out.println(tt.hashCode());

//        boolean a = true, b = false;
//        System.out.println(a || b);
//
//
//
//       String s = "vmvvvvvzrvvpvdvvvvyfvdvvvvpkvvbvvkvvfkvvvkvbvvnvvomvzvvvdvvvkvvvvvvvvvlvcvilaqvvhoevvlmvhvkvtgwfvvzy";
//       char letter = 'v';
//       float count = 0;
//        int x = s.indexOf('c');
//        for(char c: s.toCharArray()){
//           if(c==letter)
//               count++;
//       }
//
       HashMap<Integer, Integer> map = new HashMap<>();
       map.put(4, map.getOrDefault(4, 0)+1);
       map.put(5, 0);

//       int i = map.get(5);
//       int j = map.get(8);
//
//       System.out.println(i);
//       System.out.println(j);

       String s = "Hello worldlo therelo is a dg";
        System.out.println(s.trim());

        char[] arr = s.toCharArray();
//
//       for(Map.Entry<Integer, Integer> entry: map.entrySet()){
//
//       }
//
//        int[] arr = new int[5];
//        Arrays.sort(arr);
//
//        PriorityQueue<Integer> zeroLosses =new PriorityQueue<>();
//        PriorityQueue<Integer> oneLoss =new PriorityQueue<>();
//
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<>());
//        res.get(0).add(7);
//        System.out.println(res.size());
//
//
//        HashSet<Character> set = new HashSet<>();
//        set.add('c');
//        System.out.println(set.contains('c'));
//
//        */
//
////        int[] arr1 = new int[5];
////        int[] arr2 = new int[5];
////
////        arr2 = arr1;
////        System.out.println(Arrays.toString(arr2));
//
//        int[] arr = new int[5];
//

        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(22);

        Integer val = list.indexOf(10);
        System.out.println("Val: " + val);
//        for(int i: list){
//            System.out.println(i);
//        }
//
//        HashSet<Integer> set = new HashSet<>();
//        set.add(5);
//        System.out.println(set.contains(5));
//
//        Queue<Integer> queue = new LinkedList<>();

    }





}
