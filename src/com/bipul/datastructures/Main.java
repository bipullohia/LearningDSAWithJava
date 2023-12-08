package com.bipul.datastructures;

import com.bipul.datastructures.stacksqueues.questions.QueueUsingStacksInsertEff;
import com.bipul.datastructures.stacksqueues.questions.QueueUsingStacksRemoveEff;

public class Main {

    public static void main(String[] args) throws Exception {

        QueueUsingStacksRemoveEff queue = new QueueUsingStacksRemoveEff();
        System.out.println("IsEmpty: " + queue.empty());

        queue.push(12);
        queue.push(13);
        queue.push(14);
        queue.push(17);
        System.out.println("Peek2: " + queue.peek());

        System.out.println("Pop: " + queue.pop());
        System.out.println("Peek3: " + queue.peek());

        System.out.println("Pop: " + queue.pop());
        System.out.println("Peek4: " + queue.peek());

    }
}
