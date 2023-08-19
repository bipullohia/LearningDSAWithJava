package com.bipul.recursion.general;

public class ReverseOfNumber {
    public static void main(String[] args) {
        int n = 7654;
        System.out.println(reverse(n));
    }

    //this concept can be used for finding palindrome of a number too
    static int reverse(int n){
        if(n < 10) return n;
//      int len = String.valueOf(n).length(); //this is another way if conversion to string is allowed
        int len = (int) (Math.log10(n)) + 1; //this is used to count number of digits
        return (int) ((n%10)*(Math.pow(10, len-1)) + reverse(n/10));
    }
}
