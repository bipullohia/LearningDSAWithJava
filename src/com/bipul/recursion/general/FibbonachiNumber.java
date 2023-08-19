package com.bipul.recursion.general;

public class FibbonachiNumber {
    public static void main(String[] args) {
        //finding Nth fibonacchi number
        System.out.println(fibo(7));
    }

    private static int fibo(int n){
        //base conditions
        if (n==0) return 0;
        if(n==1) return 1;
//        the above base condition can also be written as
//        if(n<2) return n;

        return fibo(n-1) + fibo(n-2);
    }
}
