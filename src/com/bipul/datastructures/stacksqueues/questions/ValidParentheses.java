package com.bipul.datastructures.stacksqueues.questions;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String bracketString = "}";
        System.out.println("IsValid? " + validityCheck(bracketString));
    }

    private static boolean validityCheck(String bracketString){
        if(bracketString.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();

        for (char c : bracketString.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.empty() || !isComplimentaryBracket(c, stack.pop()))
                    return false;
            }
        }

        return stack.empty(); //will return false if there are brackets remaining in the stack (which haven't been closed)
    }

    private static boolean isComplimentaryBracket(char c, char peek){
        if(peek == '(' && c == ')') return true;
        if(peek == '{' && c == '}') return true;
        if(peek == '[' && c == ']') return true;
        return false;
    }
}
