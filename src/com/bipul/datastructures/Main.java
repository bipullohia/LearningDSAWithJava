package com.bipul.datastructures;

import com.bipul.datastructures.stacksqueues.questions.QueueUsingStacksInsertEff;
import com.bipul.datastructures.stacksqueues.questions.QueueUsingStacksRemoveEff;
import com.bipul.datastructures.trees.implementation.BinarySearchTree;
import com.bipul.datastructures.trees.implementation.BinaryTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        BinaryTree btree = new BinaryTree();
        btree.preorderTraversal();
        System.out.println();
        btree.inorderTraversal();
        System.out.println();
        btree.postorderTraversal();
//        BinarySearchTree bst = new BinarySearchTree();
//        bst.insert2(20);
//        bst.insert2(25);
//        bst.insert2(6);
//        bst.insert2(8);
//        bst.insert2(11);
//        bst.insert2(2);
//        bst.display();

//        BinarySearchTree bst = new BinarySearchTree();
//        int[] arr = new int[10];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i+1;
//        }
//        bst.insertSortedArr(arr);
//        bst.display();
    }
}
