package com.bipul;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //output
        System.out.println("Hello world!");

        //input
        Scanner inputScanner = new Scanner(System.in); //System.in means we are taking input from the keyboard
        int rollNo = inputScanner.nextInt(); // other options like inputScanner.nextFloat() are possible
        System.out.println(rollNo);

        //type casting
        int num = (int) 67.67f;
        System.out.println(num);

        //automatic type promotion in expressions
        int a = 257;
        byte b = (byte) a;
        System.out.println(b);
    }
}
