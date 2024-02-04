package com.bipul.questions;

public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(2147483647));
    }

    private static boolean isPowerOf2(int n){
        int counter = 0;
        long result;
        do{
            result = (long) Math.pow(2, counter);
            if(result == n) return true;
            else counter++;

        }while(result <= n);

        return false;
    }
}
