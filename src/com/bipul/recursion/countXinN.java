package com.bipul.recursion;

public class countXinN {
    public static void main(String[] args) {
        int n = 30204;
        int x = 0;
        System.out.println(countX(n,x));
    }

    //this will count the digit x in the number n
    static int countX(int n, int x){
        if(n == 0) return 0;

        if(n%10 == 0) //if the last digit is 0, count +1 and recurse
            return 1 + countX(n/10, x);
        else //only recurse
            return countX(n/10, x);
    }

    //we can also do it by having count inside as an argument
}
