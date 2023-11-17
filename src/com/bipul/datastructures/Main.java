package com.bipul.datastructures;

import com.bipul.datastructures.linkedlist.custom.DoublyLinkedList;
import com.bipul.datastructures.linkedlist.custom.SinglyLinkedList;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
//        System.out.println("------------JAVA provided Linked List----------------");
//        LinkedList<Integer> ll = new LinkedList<>();
//        System.out.println("Size initial: " + ll.size());
//        ll.add(34);
//        ll.add(0, 2); //index, value
//        ll.addFirst(55);
//        ll.addLast(11);
//        System.out.println("LL: " + ll.toString());
//        System.out.println("Size: " + ll.size());
//
//        System.out.println("LL: " + ll.toString());
//        System.out.println("Size" + ll.size());
//
//        System.out.println("---------------Custom Linked List---------------------");
//        SinglyLinkedList sll = new SinglyLinkedList();
//        sll.add(23);
//        sll.add(11);
//        sll.add(44);
//        sll.add(55);
//        System.out.println("CLL: " + sll);
//
//        sll.remove(2);
//        System.out.println("CLL: " + sll);
//
//        System.out.println(sll.size());

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(34);
        dll.add(12);
        dll.add(23);
        dll.add(11);
        dll.addFirst(22);
        dll.addLast(45);
        dll.add(2, 25);

        System.out.println(dll);

        dll.removeFirst();
        System.out.println(dll);

        dll.removeLast();
        System.out.println(dll);

        dll.remove(2);
        System.out.println(dll);

    }
}
