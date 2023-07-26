package com.bipul.maths;

public class SquareRoot {

    public static void main(String[] args) {
        int n = 52;
        int p = 4; //precision value
        System.out.printf("%.3f", squareRoot(n, p));
    }

    //Implementation2: Better way, Time Complexity: O(log(n))
    public static double squareRoot(int n, int p){
        int s = 0; int e = n;
        double root = 0.0;

        while(s<=e){
            int m = s + (e-s)/2;
            if(m*m == n)
                //found perfect root
                return m;

            //binary search logic to compare with the middle element
            if(m*m > n)
                e = m-1;
            else
                s = m+1;
        }
        root = e;

        //at this point we assume that our int value of root is in place. Now we try to find precision value
        double increment = 0.1;
        //for loop to run p times (once for each precision)
        for(int i = 0; i<p; i++){
            //for each precision digit, we will run the loop to find correct precision point from 0 to 9 (like 0.1 or 0.01 to 0.9 or 0.09)
            while(root*root <= n){
                root = root + increment;
            }

            //we have to go one level back so decrease last addition (since we want another level of precision)
            root = root - increment;
            //next level of precision
            increment = increment/10;
        }
        return root;
    }

    //Implementation 1: Bipul's naive way
    //finding the square root upto one decimal place (binary search + precision of 1)
    public static String squareRootBinarySearchPrecision1(int n){
        int s = 0; int e = n;
        int ans = 0;

        while(e>s){
            int m = s + (e-s)/2;
            if(s==m){
             ans = m;
             break;
            }

            if(m*m > n)
                e = m;
            else if(m*m < n)
                s = m;
            else
                ans = m;

            //Mistake: e = m-1 and s + m+1. We should be changing the values otherwise we can get stuck in a loop and write specific conditions for it like I did above
        }
        if(ans*ans != n) {
            double d = ans + 0.1;
            //case of imperfect root
            while(d*d <= n){
                d = d + 0.1;
            }
            return String.valueOf(d);
        } else //perfect root already achieved
            return String.valueOf(ans);
    }
}
