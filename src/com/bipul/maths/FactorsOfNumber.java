package com.bipul.maths;

import java.util.ArrayList;

public class FactorsOfNumber {
    public static void main(String[] args) {
        int n = 36;
        printFactors(n);
    }

    private static void printFactors(int n) {
        ArrayList<Integer> upperFactors = new ArrayList<>();
        for(int i = 1; i*i <= n; i++){
            if(n % i == 0){
                //case for same factors - like 6x6=36
                if(n/i == i)
                    System.out.print(i + " ");
                else{
                    System.out.print(i + " ");
                    upperFactors.add(n/i); //this will insert the highest factor first. Eg. for n=20, 1 and 20 are factors if i=1. i is printed and 20 is added to arraylist
                }
            }
        }
        //will be in descending order, so printing it from last index
        for (int i = upperFactors.size()-1; i>=0; i--){
            System.out.print(upperFactors.get(i) + " ");
        }
    }


}
