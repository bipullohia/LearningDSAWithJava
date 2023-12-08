package com.bipul.datastructures.stacksqueues.questions;

import java.util.Stack;

public class GameOf2Stacks {

    public static void main(String[] args) {

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(6);
        stack1.push(4);
        stack1.push(2);
        stack1.push(4);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(5);
        stack2.push(8);
        stack2.push(1);
        stack2.push(2);

        //denotes the max number of elements we can remove from the stacks
        int maxElements = twoStacks(10, stack1, stack2, 0, 0);
        System.out.println("Answer: " + (maxElements-1)); //since the maxElements will include 1 extra step of going over the max sum
    }

    //helper function
    private static int twoStacks(int maxSum, Stack<Integer> stack1, Stack<Integer> stack2, int currentSum, int currentCount){
        if(currentSum > maxSum) return currentCount;

        if(stack1.empty() || stack2.empty()) return currentCount;

        //taking stack 1 (left stack)
        int popped1 = stack1.pop();
        int stack1Count = twoStacks(maxSum, stack1, stack2, currentSum+popped1, ++currentCount);
        stack1.push(popped1); //to restore the original stack1
        currentCount--; //this is so that current count resets to what was originally in the function (to not influence currentCount2)

        //taking stack 2 (right stack)
        int popped2 = stack2.pop();
        int stack2Count = twoStacks(maxSum, stack1, stack2, currentSum+popped2, ++currentCount);
        stack2.push(popped2);

        return Math.max(stack1Count, stack2Count);
    }

    //leetcode has this as array instead of stack - solution becomes a bit simpler that way
}
