package com.bipul.datastructures.stacksqueues.implementation;

public class StackException extends Exception{
    StackException(){
        super("Oops! Some problem with the stack. Coder too lazy to give exact reason :D");
    }

    StackException(String message){
        super(message);
    }
}
