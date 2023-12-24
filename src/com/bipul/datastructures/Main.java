package com.bipul.datastructures;

import com.bipul.datastructures.stacksqueues.questions.QueueUsingStacksInsertEff;
import com.bipul.datastructures.stacksqueues.questions.QueueUsingStacksRemoveEff;
import com.bipul.datastructures.trees.implementation.AVLTree;
import com.bipul.datastructures.trees.implementation.BinarySearchTree;
import com.bipul.datastructures.trees.implementation.BinaryTree;
import com.bipul.datastructures.trees.implementation.SegmentTreeSum;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        int[] arr = {3,8,7,6,-2,-8,4,9};
        SegmentTreeSum stree = new SegmentTreeSum(arr);
        stree.display();

        System.out.println();
        System.out.println();
        System.out.println();

        stree.updateElement2(6,-3);
        stree.display();

        System.out.println("Sum between 2nd and 4th index: ");
        System.out.println(stree.getSum(2,4));
    }
}
