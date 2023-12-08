package com.bipul.datastructures.stacksqueues.questions;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String bracketString = "(((";
        System.out.println("Min Steps to make string valid? " + validityCheck(bracketString));
    }

    private static int validityCheck(String bracketString){
        if(bracketString.isEmpty()) return 0;
        int bracketCount = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : bracketString.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if(stack.empty())
                    bracketCount++;
                else
                    stack.pop();
            }
        }

        if(!stack.isEmpty())
            bracketCount = bracketCount + stack.size();
        return bracketCount;
    }

    //since only 1 kind of bracket is involved - we can also simply use a int counter
    /*
    class Solution {
        public int minAddToMakeValid(String s) {
            if(s.isEmpty()) return 0;

            int bracketCount = 0;
            int openBracketCount = 0;
            char[] arr = s.toCharArray();
            for (char c : arr) {
                if (c == '(') {
                    openBracketCount++;
                } else {
                    if(openBracketCount == 0)
                        bracketCount++;
                    else
                        openBracketCount--;
                }
            }

            return bracketCount + openBracketCount;
        }
    } */
}
