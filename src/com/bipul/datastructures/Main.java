package com.bipul.datastructures;

import com.bipul.datastructures.stacksqueues.questions.QueueUsingStacksInsertEff;
import com.bipul.datastructures.stacksqueues.questions.QueueUsingStacksRemoveEff;
import com.bipul.datastructures.trees.implementation.AVLTree;
import com.bipul.datastructures.trees.implementation.BinarySearchTree;
import com.bipul.datastructures.trees.implementation.BinaryTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        AVLTree avt = new AVLTree();
        System.out.println("Try 1: ");
        avt.insert(5);
        avt.display();
        System.out.println("Try 2: ");
        avt.insert(7);
        avt.display();
        System.out.println("Try 3: ");
        avt.insert(10);
        avt.display();
        System.out.println("Try 4: ");
        avt.insert(12);
        avt.display();
        System.out.println("Try 5: ");
        avt.insert(14);
        avt.display();
        System.out.println("Try 6: ");
        avt.insert(15);
        avt.display();
    }
}
